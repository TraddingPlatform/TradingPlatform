package org.citi.training.TradingPlatform.controller.modifytrade;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ModifyTradeTest {
	
	private ApplicationContext ctx;
	private ModifyTrade modifyTrade;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("bean.xml");
		modifyTrade = (ModifyTrade) ctx.getBean("getOrderBook");
	}

	@Test
	public void testModifySuccess() {
		boolean result = modifyTrade.modifyTrade(120, "ABT", 100000, 100000.87, true, 1);
		assertEquals(result,true);
	}
	@Test
	public void testModifyFail() {
		boolean result = modifyTrade.modifyTrade(10, "ABT", 100000, 100000.87, true, 1);
		assertEquals(result,false);
	}
	@Test
	public void testCancelSuccess() {
		boolean result = modifyTrade.cancelTrade(121);
		assertEquals(result,true);
	}
	@Test
	public void testCancelFail() {
		boolean result = modifyTrade.cancelTrade(-1);
		assertEquals(result,false);
	}
}
