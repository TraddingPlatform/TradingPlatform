/*package org.citi.training.TradingPlatform.facade;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.citi.training.TradingPlatform.controller.login.Login;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Path("/loginservice")
@Component
@Scope("request")
public class LoginService {
	
	private Login loginManager;
	private ApplicationContext ctx;
	
	public LoginService() {
		ctx = new ClassPathXmlApplicationContext("bean.xml");
		loginManager = (Login) ctx.getBean("loginManager");
	}

	@POST
	@Path("/login")
	@Produces("text/plain")
	public String login(@FormParam("traderName")String traderName, 
			@FormParam("password")String password) {
		boolean success = loginManager.login(traderName, password);
		if(success) {
			return "true";
		}
		else {
			return "false";
		}
	}
}
*/