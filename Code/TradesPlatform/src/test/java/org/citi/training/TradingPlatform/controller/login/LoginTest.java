package org.citi.training.TradingPlatform.controller.login;

import static org.junit.Assert.*;

import org.citi.training.TradingPlatform.module.trader.SelectSpecifiedTraderImp;
import org.citi.training.TradingPlatform.module.trader.Trader;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoginTest {

	private ApplicationContext ctx;
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("bean.xml");
	}

	@Test
    public void loginTest(){
    	SelectSpecifiedTraderImp selectSpecifiedTraderServiceImp = (SelectSpecifiedTraderImp) ctx.getBean("traderService");
    	String username = "admin";
		Trader trader = selectSpecifiedTraderServiceImp.getTrader(username);
		String password = trader.getPassword();
		assertEquals("admin",password);
		
    }
}
