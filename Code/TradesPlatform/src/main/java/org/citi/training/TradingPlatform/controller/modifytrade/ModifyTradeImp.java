package org.citi.training.TradingPlatform.controller.modifytrade;

import org.citi.training.TradingPlatform.module.orderbook.OrderBook;
import org.citi.training.TradingPlatform.module.orderbook.OrderBookOption;

public class ModifyTradeImp implements ModifyTrade {
	
	private OrderBookOption orderBookOption;

	public void setOrderBookOption(OrderBookOption orderBookOption) {
		this.orderBookOption = orderBookOption;
	}
	
	public boolean modifyTrade(int orderBookId, String equitySymbol,
											int quantity, double price, boolean isBuy, int traderId) {
		OrderBook orderBook = new OrderBook(orderBookId, equitySymbol, quantity, isBuy?1:0, price, traderId);
		try {
			orderBookOption.modifyOrderBook(orderBook);
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	public boolean cancelTrade(int orderBookId) {
		return orderBookOption.deleteOrderBooks(orderBookId);
	}
}
