package org.citi.training.TradingPlatform.controllertest;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.citi.training.TradingPlatform.module.trader.SelectSpecifiedTraderImp;
import org.citi.training.TradingPlatform.module.trader.Trader;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sun.misc.BASE64Encoder;

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
