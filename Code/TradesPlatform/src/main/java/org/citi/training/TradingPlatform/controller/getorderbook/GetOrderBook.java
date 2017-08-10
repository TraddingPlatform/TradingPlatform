package org.citi.training.TradingPlatform.controller.getorderbook;

public interface GetOrderBook {
	public String getOrderBook(String symbol);
	public String getOrderBookByTraderId(int limit, int offset, int traderId, String symbol);
}
