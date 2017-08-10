package org.citi.training.TradingPlatform.server;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.citi.training.TradingPlatform.controller.booktrade.BookTrade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TradeServer implements ServletContextListener {

	private static Set<String> symbolSet;
	private static Map<String, Double> currentPrice;
	private static BookTrade bookTrade;
	private static ApplicationContext ctx;
	private static String[] symbolArrays;
	static {
		ctx = new ClassPathXmlApplicationContext("bean.xml");
		symbolSet = new HashSet<String>();
		symbolSet.add("ABT");
		symbolSet.add("citi");
		currentPrice = new HashMap<String, Double>();
		currentPrice.put("ABT", 40.56);
		currentPrice.put("citi", 52.64);
		bookTrade = (BookTrade) ctx.getBean("bookTradeByGtc");
	}
	public TradeServer() {
	}
	
	public static Map<String, Double> getCurrentPrice() {
		return currentPrice;
	}
	
	public static Set<String> getSymbolSet() {
		return symbolSet;
	}

	public void contextInitialized(ServletContextEvent sce) {
		Random rand = new Random();
		
		while(true) {
			int randTraderId = rand.nextInt(2);
			symbolArrays = new String[symbolSet.size()];
			symbolSet.toArray(symbolArrays);
			String randSymbol = symbolArrays[rand.nextInt(symbolSet.size())];
			int randQuantity = rand.nextInt(200);
			DecimalFormat df = new DecimalFormat("#.00");
			double price = rand.nextDouble() - 0.5 + currentPrice.get(randSymbol);
			double formatPrice = Double.parseDouble(df.format(price));
			boolean isBuy = rand.nextInt(2)==1 ? true : false;
			bookTrade.bookTrade(randTraderId, randSymbol, randQuantity, formatPrice, isBuy);
			System.out.println("BookTrade automatic success");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}
}
