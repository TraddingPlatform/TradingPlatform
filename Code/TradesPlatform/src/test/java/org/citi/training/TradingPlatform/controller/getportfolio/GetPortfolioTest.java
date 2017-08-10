package org.citi.training.TradingPlatform.controller.getportfolio;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetPortfolioTest {

	private ApplicationContext ctx;
	private GetPortfolio getPortfolio;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("bean.xml");
		getPortfolio = (GetPortfolio) ctx.getBean("getOrderBook");
	}

	@Test
	public void testSuccess() {
		String result = getPortfolio.getPortfolio(1);
		boolean isEqualsNull = result.equals(null);
		assertEquals(isEqualsNull,false);
	}
	
	@Test
	public void testFail() {
		String result = getPortfolio.getPortfolio(3);
		String target = "";
		assertEquals(result,target);
	}

}
