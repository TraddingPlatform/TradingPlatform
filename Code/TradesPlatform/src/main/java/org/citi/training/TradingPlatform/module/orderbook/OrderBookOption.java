package org.citi.training.TradingPlatform.module.orderbook;

import java.util.List;

public interface OrderBookOption {
	
	public void insertIntoOrderBook(OrderBook orderBook);
	
	public void deleteOrderBooks(double lowestPrice, double hightestPrice, int isBuy);
	
	public void modifyOrderBookQuantity(OrderBook orderBook);
	
	public void modifyOrderBook(OrderBook orderBook);
	
	public List<OrderBook> getOrderBookListBySymbol(String equitySymbol, boolean isBuy);
	
	public List<OrderBook> getOrderBookListByTraderId(int traderId);
	
	public List<OrderBook> getOrderBookList();
}
