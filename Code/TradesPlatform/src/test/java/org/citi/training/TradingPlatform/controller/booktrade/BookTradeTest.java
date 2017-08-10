package org.citi.training.TradingPlatform.controller.booktrade;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookTradeTest {

	private ApplicationContext ctx;
	private BookTrade bookTrade;
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("bean.xml");
		bookTrade = (BookTrade) ctx.getBean("bookTradeByFok");
	}

	@Test
	public void testBookTradeFokFill() {
		boolean result = bookTrade.bookTrade(1, "ABT", 1, 100.67, true);
		assertEquals(result,true);
	}

	@Test
	public void testBookTradeFokKill() {
		boolean result = bookTrade.bookTrade(1, "ABT", 1, 100.67, false);
		assertEquals(result,false);
	}
	
}
