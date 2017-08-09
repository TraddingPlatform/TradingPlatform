package org.citi.training.TradingPlatform.controller.login;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.citi.training.TradingPlatform.module.trader.SelectSpecifiedTraderImp;
import org.citi.training.TradingPlatform.module.trader.Trader;
import org.citi.training.TradingPlatform.utils.JSONUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
@Controller
public class Login {

    private ApplicationContext ctx;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String login(@RequestBody String j)throws IOException{
	        JSONObject jo= JSONUtil.toJsonObject(j);
	        System.out.println("transfered jsonaaaSlogin:"+jo);
	        String username=jo.getString("username");
	        String inputPassword=jo.getString("inputPassword");
	        Map<String,Object> map=new HashMap<String,Object>();
	        ctx = new ClassPathXmlApplicationContext("bean.xml");
	        SelectSpecifiedTraderImp selectSpecifiedTraderServiceImp = (SelectSpecifiedTraderImp) ctx.getBean("traderService");
	    	Trader trader = selectSpecifiedTraderServiceImp.getTrader(username);
	    	if(trader == null) {
		        map.put("message","failed");
			} else if (trader.getPassword().equals(encoderByMd5(inputPassword))) {
		        map.put("message","success");
		        map.put("traderId", trader.getId());
			} else {
		        map.put("message","failed");
			}
	        return JSONUtil.toJsonString(map);
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
