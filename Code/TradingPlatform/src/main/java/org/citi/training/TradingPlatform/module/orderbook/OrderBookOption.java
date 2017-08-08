package org.citi.training.TradingPlatform.module.orderbook;

import java.util.List;

public interface OrderBookOption {
	
	public void insertIntoOrderBook(OrderBook orderBook);
	
	public void deleteOrderBooks(double lowestPrice, double hightestPrice, int isBuy);
	
	public void modifyOrderBookQuantity(OrderBook orderBook);
	
	public List<OrderBook> getOrderBookList(String equitySymbol, boolean isBuy);
}
