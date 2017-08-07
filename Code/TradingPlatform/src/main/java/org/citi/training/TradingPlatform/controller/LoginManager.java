package org.citi.training.TradingPlatform.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.citi.training.TradingPlatform.module.SelectSpecifiedTraderService;
import org.citi.training.TradingPlatform.module.Trader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class LoginManager {
	
	private SelectSpecifiedTraderService service;
	private ApplicationContext ctx;
	
	public LoginManager() {
		ctx = new ClassPathXmlApplicationContext("bean.xml");
		service = (SelectSpecifiedTraderService) ctx.getBean("repoCalculator");
	}
	
	public boolean login(String traderId, String password) {
		Trader trader = service.getTrader(traderId);
		String passwordEncoderByMd5 = encoderByMd5(password);
		boolean result = trader.getPassword().equals(passwordEncoderByMd5);
		return result;
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
}
