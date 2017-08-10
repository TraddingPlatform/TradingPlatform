package org.citi.training.TradingPlatform.controller.tradehistory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SelectTradeHistoryTest {
	
	private ApplicationContext ctx;
	private SelectTradeHistory selectTradeHistory;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("bean.xml");
		selectTradeHistory = (SelectTradeHistory) ctx.getBean("getOrderBook");
	}

	@Test
	public void test() {
		String result = selectTradeHistory.selectTradeHistory(10, 1, 1, "ABT");
		boolean isNull = result.equals(null);
		assertEquals(isNull,false);
	}

}
