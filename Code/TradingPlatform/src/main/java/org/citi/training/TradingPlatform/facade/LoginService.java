package org.citi.training.TradingPlatform.facade;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.citi.training.TradingPlatform.controller.Loginable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Path("/calculateservice")
@Component
@Scope("request")
public class LoginService {
	
	private ApplicationContext ctx;
	private Loginable loginManager;
	
	public LoginService() {
		ctx = new ClassPathXmlApplicationContext("bean.xml");
		loginManager = (Loginable) ctx.getBean("repoCalculator");
	}
	
	@GET
	@Path("/dirtyprice")
	@Produces("text/plain")
	public String login(@QueryParam("traderId")String traderId, 
						@QueryParam("password")String password) {
		boolean success = loginManager.login(traderId, password);
		if(success) {
			return "";
		}
		else {
			return "";
		}
	}
}
