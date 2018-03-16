package com.taobao.pamirs.schedule.strategy;

import com.taobao.pamirs.schedule.ScheduleUtil;
import com.taobao.pamirs.schedule.taskmanager.TraceTBScheduleManagerStatic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ��ִ�е�����, ����trace id, ����׷�ٵ���������.
 */
public class TraceTBScheduleManagerFactory extends TBScheduleManagerFactory {

    /**
     * �������ȷ�����
     *
     * @param strategy
     * @return
     * @throws Exception
     */
    public IStrategyTask createStrategyTask(ScheduleStrategy strategy)
            throws Exception {
        return createStrategyTask(strategy, UUID.randomUUID().toString());
    }

    public IStrategyTask createStrategyTask(ScheduleStrategy strategy, String traceId)
            throws Exception {
        IStrategyTask result = null;
        try {
            if (ScheduleStrategy.Kind.Schedule == strategy.getKind()) {
                String baseTaskType = ScheduleUtil.splitBaseTaskTypeFromTaskType(strategy.getTaskName());
                String ownSign = ScheduleUtil.splitOwnsignFromTaskType(strategy.getTaskName());
                result = new TraceTBScheduleManagerStatic(this, baseTaskType, ownSign, getScheduleDataManager(), traceId);
            } else if (ScheduleStrategy.Kind.Java == strategy.getKind()) {
                result = (IStrategyTask) Class.forName(strategy.getTaskName()).newInstance();
                result.initialTaskParameter(strategy.getStrategyName(), strategy.getTaskParameter());
            } else if (ScheduleStrategy.Kind.Bean == strategy.getKind()) {
                result = (IStrategyTask) this.getBean(strategy.getTaskName());
                result.initialTaskParameter(strategy.getStrategyName(), strategy.getTaskParameter());
            }
        } catch (Exception e) {
            logger.error("strategy ��ȡ��Ӧ��java or bean ����,schedule��û�м��ظ�����,��ȷ��" + strategy.getStrategyName(), e);
        }
        return result;
    }


    private Map<String, List<IStrategyTask>> managerMap = new ConcurrentHashMap<String, List<IStrategyTask>>();


    @Override
    public void reRunScheduleServer() throws Exception {
        for (ScheduleStrategyRunntime run : this.getScheduleStrategyManager().loadAllScheduleStrategyRunntimeByUUID(getUuid())) {
            List<IStrategyTask> list = this.managerMap.get(run.getStrategyName());
            if (list == null) {
                list = new ArrayList<IStrategyTask>();
                this.managerMap.put(run.getStrategyName(), list);
            }
            while (list.size() > run.getRequestNum() && !list.isEmpty()) {
                IStrategyTask task = list.remove(list.size() - 1);
                try {
                    task.stop(run.getStrategyName());
                } catch (Throwable e) {
                    logger.error("ע���������strategyName=" + run.getStrategyName(), e);
                }
            }
            //���㣬���ӵ�����
            ScheduleStrategy strategy = this.getScheduleStrategyManager().loadStrategy(run.getStrategyName());

            String traceId = UUID.randomUUID().toString();
            System.err.println("traceId:" + traceId);
            while (list.size() < run.getRequestNum()) {
                IStrategyTask result = this.createStrategyTask(strategy, traceId);
                if (result == null) {
                    logger.error("strategy ��Ӧ�����������⡣ strategy name=" + strategy.getStrategyName());
                }
                list.add(result);
            }
        }
    }
}
