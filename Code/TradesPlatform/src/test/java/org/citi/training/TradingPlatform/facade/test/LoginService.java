package org.citi.training.TradingPlatform.facade.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.citi.training.TradingPlatform.controllertest.Loginable;
import org.json.JSONObject;


@Path("/loginservice")
@Component
@Scope("request")
public class LoginService {
	
	private Loginable loginManager;
	private ApplicationContext ctx;
	
	public LoginService() {
		ctx = new ClassPathXmlApplicationContext("bean.xml");
		loginManager = (Loginable) ctx.getBean("loginManager");
	}
	
	@GET
	@Path("/login")
	@Produces("text/plain")
	public String login(@QueryParam("username")String traderName, 
						@QueryParam("password")String password) {
		JSONObject jsonObj = new JSONObject("json");    //将JSON格式的字符串构造成JSON对象
        String loginName = jsonObj.getString("loginName"); //获取JSON对象中的loginName属性的值
        String password2 = jsonObj.getString("password");    //获取JSON对象中的password属性的值
        System.out.println(loginName+ " "+ password2);
		boolean success = loginManager.login(traderName, password);
		if(success) {
			return "true";
		}
		else {
			return "false";
		}
	}
}
