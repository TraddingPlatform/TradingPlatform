package org.citi.training.TradingPlatform.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

import com.sun.jersey.spi.resource.PerRequest;

@Controller
@RequestMapping("/login")
public class LoginController {
	@RequestMapping("/logindata")
	public String login(ModelMap model){
		model.addAttribute("message","login sucess");
		JSONObject jsonObj = new JSONObject("json");    //将JSON格式的字符串构造成JSON对象
        String loginName = jsonObj.getString("loginName"); //获取JSON对象中的loginName属性的值
        String password2 = jsonObj.getString("password");    //获取JSON对象中的password属性的值
        System.out.println(loginName+ " "+ password2);
		return "loginsucess";
		
	}

}
