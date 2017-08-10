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
	}

	@Test
	public void testBookTradeFokFill() {
		bookTrade = (BookTrade) ctx.getBean("bookTradeByFok");
		boolean result = bookTrade.bookTrade(1, "ABT", 1, 100.67, true);
		assertEquals(result,true);
	}

	@Test
	public void testBookTradeFokKill() {
		bookTrade = (BookTrade) ctx.getBean("bookTradeByFok");
		boolean result = bookTrade.bookTrade(1, "ABT", 1, 100.67, false);
		assertEquals(result,false);
	}
	
	@Test
	public void testBookTradeGtcFill() {
		bookTrade = (BookTrade) ctx.getBean("bookTradeByGtc");
		boolean result = bookTrade.bookTrade(1, "ABT", 1, 100.67, true);
		assertEquals(result,true);
	}
	
	@Test
	public void testBookTradeGtcUnfill() {
		bookTrade = (BookTrade) ctx.getBean("bookTradeByGtc");
		boolean result = bookTrade.bookTrade(1, "ABT", 1, 100.67, false);
		assertEquals(result,false);
	}
	
	@Test
	public void testBookTradeIoc() {
		bookTrade = (BookTrade) ctx.getBean("bookTradeByIoc");
		boolean result = bookTrade.bookTrade(1, "ABT", 1, 1, true);
		assertEquals(result,true);
	}
	@Test
	public void testBookTradeMrkt() {
		bookTrade = (BookTrade) ctx.getBean("bookTradeByMrkt");
		boolean result = bookTrade.bookTrade(1, "ABT", 1, 1, true);
		assertEquals(result,true);
	}
}
