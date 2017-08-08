package org.citi.training.TradingPlatform.facade;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.citi.training.TradingPlatform.controller.booktrade.BookTrade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Path("/booktradeservice")
@Component
@Scope("request")
public class BookTradeService {
	
	private BookTrade bookTrade;
	private ApplicationContext ctx;
	
	public BookTradeService() {
		ctx = new ClassPathXmlApplicationContext("bean.xml");
	}
	
	@POST
	@Path("/booktrade")
	@Produces("text/plain")
	public String bookTrade(@FormParam("traderId")int traderId, 
							@FormParam("equitySymbol")String equitySymbol,
							@FormParam("quantity")int quantity,
							@FormParam("price")double price,
							@FormParam("isBuy")boolean isBuy,
							@FormParam("tradeType")String tradeType) {
		
		bookTrade = (BookTrade) ctx.getBean("bookTradeBy"+tradeType);
		boolean success = bookTrade.bookTrade(traderId, equitySymbol, quantity, price, isBuy);
		if(success) {
			return "true";
		}
		else {
			return "false";
		}
	}
}
