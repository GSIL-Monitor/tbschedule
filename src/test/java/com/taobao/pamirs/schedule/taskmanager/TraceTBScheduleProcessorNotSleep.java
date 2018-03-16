package com.taobao.pamirs.schedule.taskmanager;

import com.taobao.pamirs.schedule.IScheduleTaskDeal;

public class TraceTBScheduleProcessorNotSleep extends TBScheduleProcessorNotSleep {

    protected final String traceId;

    /**
     * ����һ�����ȴ�����
     *
     * @param aManager
     * @param aTaskDealBean
     * @param aStatisticsInfo
     * @throws Exception
     */
    public TraceTBScheduleProcessorNotSleep(TBScheduleManager aManager, IScheduleTaskDeal aTaskDealBean, StatisticsInfo aStatisticsInfo, String traceId) throws Exception {
        super(aManager, aTaskDealBean, aStatisticsInfo);
        this.traceId = traceId;
    }
}
