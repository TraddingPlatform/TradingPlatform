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

    /**
     * @RequestParam注解的作用是：根据参数名从URL中取得参数值
     * @param username
     *            用户名，一定要对应着表单的name才行
     * @param password
     *            用户密码，也应该对应表单的数据项
     * @param model
     *            一个域对象，可用于存储数据值
     * @return
     */
	
    @RequestMapping("/login") // @RequestMapping 注解可以用指定的URL路径访问本控制层
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
            Model model) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
    	SelectSpecifiedTraderImp selectSpecifiedTraderServiceImp = (SelectSpecifiedTraderImp) ctx.getBean("traderService");
    	Trader trader = selectSpecifiedTraderServiceImp.getTrader(username);
    	if(trader == null) {
			return "no";
		} else if (trader.getPassword().equals(password)) {
			return "ok";

		} else {
			return "no";
		}

    }
    
    private String encoderByMd5(String str) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		BASE64Encoder base64en = new BASE64Encoder();
		String newstr = null;
		try {
			newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return newstr;
	}
    
    @Test
    public void loginTest(){
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
    	SelectSpecifiedTraderImp selectSpecifiedTraderServiceImp = (SelectSpecifiedTraderImp) ctx.getBean("traderService");
    	String username = "111";
		Trader trader = selectSpecifiedTraderServiceImp.getTrader(username);

		String password = trader.getPassword();
		assertEquals("222","222");
		
    }

}
