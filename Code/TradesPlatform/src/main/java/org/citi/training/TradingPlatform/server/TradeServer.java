package org.citi.training.TradingPlatform.server;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class TradeServer implements HttpSessionListener{

	private static Map<String, Double> currentPrice;
	
	public TradeServer() {
		currentPrice = new HashMap<String, Double>();
	}
	
	public void sessionCreated(HttpSessionEvent se) {
		while(true) {
			
		}
	}

	public void sessionDestroyed(HttpSessionEvent se) {
	}
	
	public static Map<String, Double> getCurrentPrice() {
		return currentPrice;
	}
}
