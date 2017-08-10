package org.citi.training.TradingPlatform.server;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.citi.training.TradingPlatform.controller.booktrade.BookTrade;
import org.springframework.context.ApplicationContext;

public class TradeServer implements HttpSessionListener{

	private static Set<String> symbolSet;
	private static Map<String, Double> currentPrice;
	private BookTrade bookTrade;
	private ApplicationContext ctx;
	private String[] symbolArrays;
	
	public TradeServer() {
		symbolSet = new HashSet<String>();
		symbolSet.add("ABT");
		symbolSet.add("citi");
		currentPrice = new HashMap<String, Double>();
		currentPrice.put("ABT", 40.56);
		currentPrice.put("citi", 52.64);
		bookTrade = (BookTrade) ctx.getBean("bookTradeByGtc");
	}
	
	public void sessionCreated(HttpSessionEvent se) {
		Random rand = new Random();
		
		while(true) {
			int randTraderId = rand.nextInt(2);
			symbolArrays = null;
			symbolSet.toArray(symbolArrays);
			String randSymbol = symbolArrays[rand.nextInt(symbolSet.size())];
			int randQuantity = rand.nextInt(200);
			double price = rand.nextDouble() - 0.5 + currentPrice.get(randSymbol);
			boolean isBuy = rand.nextInt(2)==1 ? true : false;
			bookTrade.bookTrade(randTraderId, randSymbol, randQuantity, price, isBuy);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void sessionDestroyed(HttpSessionEvent se) {
	}
	
	public static Map<String, Double> getCurrentPrice() {
		return currentPrice;
	}
	
	public static Set<String> getSymbolSet() {
		return symbolSet;
	}
}
