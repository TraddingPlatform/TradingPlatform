package org.citi.training.TradingPlatform.controller.getorderbook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.citi.training.TradingPlatform.module.orderbook.OrderBook;
import org.citi.training.TradingPlatform.module.orderbook.OrderBookOption;

import net.sf.json.JSONArray;

public class GetOrderBookImp implements GetOrderBook {

	private OrderBookOption orderBookOption;
	
	public void setOrderBookOption(OrderBookOption orderBookOption) {
		this.orderBookOption = orderBookOption;
	}

	public String getOrderBook(String symbol) {
		List<OrderBook> orderBookList = orderBookOption.getOrderBookList(symbol);
		List<OrderBook> buyOrderBook = new ArrayList<OrderBook>();
		List<OrderBook> sellOrderBook = new ArrayList<OrderBook>();
		for(OrderBook orderBook : orderBookList) {
			if(orderBook.getIsBuy() == 1) 
				buyOrderBook.add(orderBook);
			else 
				sellOrderBook.add(orderBook);
		}
		buyOrderBook.sort(new MyASCComparator());
		sellOrderBook.sort(new MyDESCComparator());
		JSONArray buyOrderBookJson = JSONArray.fromObject(buyOrderBook);
		JSONArray sellOrderBookJson = JSONArray.fromObject(sellOrderBook);
		StringBuilder jsonResult = new StringBuilder();
		jsonResult.append("{bid:[");
		jsonResult.append(buyOrderBookJson);
		jsonResult.append("],ask:[");
		jsonResult.append(sellOrderBookJson);
		jsonResult.append("]}");
		return jsonResult.toString();
	}
	
	private class MyASCComparator implements Comparator<OrderBook> {
		public int compare(OrderBook orderBook1, OrderBook orderBook2) {
			if(orderBook1.getPrice() < orderBook2.getPrice())
				return -1;
			if(orderBook1.getPrice() > orderBook2.getPrice()) 
				return 1;
			return 0;
		}
	}

	private class MyDESCComparator implements Comparator<OrderBook> {
		public int compare(OrderBook orderBook1, OrderBook orderBook2) {
			if(orderBook1.getPrice() > orderBook2.getPrice())
				return -1;
			if(orderBook1.getPrice() < orderBook2.getPrice()) 
				return 1;
			return 0;
		}
	}
}
