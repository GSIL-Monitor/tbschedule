package com.taobao.pamirs.schedule.taskmanager;

interface IScheduleProcessor {
    /**
     * �Ƿ��Ѿ��������ڴ������е����ݣ��ڽ��ж����л���ʱ��
     * ���뱣֤�����ڴ�����ݴ������
     *
     * @return
     */
    boolean isDealFinishAllData();

    /**
     * �жϽ����Ƿ�������״̬
     *
     * @return
     */
    boolean isSleeping();

    /**
     * ֹͣ��������
     *
     * @throws Exception
     */
    void stopSchedule() throws Exception;

    /**
     * ��������Ѿ�ȡ���ڴ��е����ݣ��������߳�ʧ�ܵ�ʱ����ã����������ظ�
     */
    void clearAllHasFetchData();
}
