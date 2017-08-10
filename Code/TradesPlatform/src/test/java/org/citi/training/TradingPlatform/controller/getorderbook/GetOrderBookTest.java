package org.citi.training.TradingPlatform.controller.getorderbook;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetOrderBookTest {

	private ApplicationContext ctx;
	private GetOrderBook getOrderBook;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("bean.xml");
		getOrderBook = (GetOrderBook) ctx.getBean("getOrderBook");
	}

	@Test
	public void testSuccess() {
		String result = getOrderBook.getOrderBook("ABT");
		boolean isEqualsNull = result.equals(null);
		assertEquals(isEqualsNull,false);
	}
	
	@Test
	public void testFail() {
		String result = getOrderBook.getOrderBook("A");
		String target = "{bid:[],ask:[]}";
		assertEquals(result,target);
	}
	
}
