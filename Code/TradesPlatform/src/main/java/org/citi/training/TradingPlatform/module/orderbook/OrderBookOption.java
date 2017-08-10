package org.citi.training.TradingPlatform.module.orderbook;

import java.util.HashMap;
import java.util.List;

public interface OrderBookOption {
	
	public void insertIntoOrderBook(OrderBook orderBook);
	
	public void deleteOrderBooks(double lowestPrice, double hightestPrice, int isBuy);
	
	public boolean deleteOrderBooks(int orderBookId);
	
	public void modifyOrderBookQuantity(OrderBook orderBook);
	
	public void modifyOrderBook(OrderBook orderBook);
	
	public List<OrderBook> getOrderBookListBySymbol(String equitySymbol, boolean isBuy);
	
	public List<OrderBook> getOrderBookListByTraderId(int traderId);

	public List<OrderBook> getOrderBookListByTraderId(int limit, int offset, int traderId, String symbol);
	
	public List<OrderBook> getOrderBookList(String symbol);

	public HashMap<String, List<OrderBook>> getAllSymbolOrders (String symbol);

	public int getOrderBookTotalNums (int traderId);

}
