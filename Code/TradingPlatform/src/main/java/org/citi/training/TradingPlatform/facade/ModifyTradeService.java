package org.citi.training.TradingPlatform.facade;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.citi.training.TradingPlatform.controller.modifytrade.ModifyTrade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Path("/modifytradeservice")
@Component
@Scope("request")
public class ModifyTradeService {
	private ModifyTrade modifyTrade;
	private ApplicationContext ctx;
	
	public ModifyTradeService() {
		ctx = new ClassPathXmlApplicationContext("bean.xml");
		modifyTrade = (ModifyTrade) ctx.getBean("modifyTrade");
	}

	@POST
	@Path("/modifytrade")
	@Produces("text/plain")
	public String login(@FormParam("orderBookId")int orderBookId, 
						@FormParam("equitySymbol")String equitySymbol,
						@FormParam("quantity")int quantity,
						@FormParam("price")double price,
						@FormParam("isBuy")boolean isBuy,
						@FormParam("tradeType")String tradeType) {
		boolean success = modifyTrade.modifyTrade(orderBookId, equitySymbol, quantity, price, isBuy);
		if(success) {
			return "true";
		}
		else {
			return "false";
		}
	}
}
