package org.citi.training.TradingPlatform.controllertest;

import static org.junit.Assert.*;

import org.citi.training.TradingPlatform.module.trader.SelectSpecifiedTraderImp;
import org.citi.training.TradingPlatform.module.trader.Trader;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller // @Controller 代表本Java类是controller控制层
public class LoginTest {

    
    @Test
    public void loginTest(){
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
    	SelectSpecifiedTraderImp selectSpecifiedTraderServiceImp = (SelectSpecifiedTraderImp) ctx.getBean("traderService");
    	String username = "admin";
		Trader trader = selectSpecifiedTraderServiceImp.getTrader(username);
		String password = trader.getPassword();
		assertEquals("admin",password);
		
    }

}
