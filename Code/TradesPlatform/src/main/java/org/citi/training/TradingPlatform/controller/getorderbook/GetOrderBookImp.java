package org.citi.training.TradingPlatform.controller.getorderbook;

import java.util.ArrayList;
import java.util.List;

import org.citi.training.TradingPlatform.module.orderbook.OrderBook;
import org.citi.training.TradingPlatform.module.orderbook.OrderBookOption;

public class GetOrderBookImp implements GetOrderBook {

	private OrderBookOption orderBookOption;
	
	public void setOrderBookOption(OrderBookOption orderBookOption) {
		this.orderBookOption = orderBookOption;
	}

	public String getOrderBook() {
		List<OrderBook> orderBookList = orderBookOption.getOrderBookList();
		List<OrderBook> buyOrderBook = new ArrayList<OrderBook>();
		List<OrderBook> sellOrderBook = new ArrayList<OrderBook>();
		for(OrderBook orderBook : orderBookList) {
			if(orderBook.getIsBuy() == 1) 
				buyOrderBook.add(orderBook);
			else 
				sellOrderBook.add(orderBook);
		}
		
		return null;
	}

}
