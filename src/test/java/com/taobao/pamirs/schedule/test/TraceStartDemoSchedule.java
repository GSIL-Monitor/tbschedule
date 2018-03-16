package com.taobao.pamirs.schedule.test;


import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByName;

/**
 * ���Ȳ���, �����ڵ��������� trace id, ����׷�ٵ�����
 * @author xuannan
 *
 */
@SpringApplicationContext( { "schedule-trace.xml" })
public class TraceStartDemoSchedule extends UnitilsJUnit4{
	@SpringBeanByName
	TBScheduleManagerFactory scheduleManagerFactory;
	
    public void setScheduleManagerFactory(
			TBScheduleManagerFactory tbScheduleManagerFactory) {
		this.scheduleManagerFactory = tbScheduleManagerFactory;
	}
	@Test    
	public void testRunData() throws Exception {
		Thread.sleep(100000000000000L);
	}
}
