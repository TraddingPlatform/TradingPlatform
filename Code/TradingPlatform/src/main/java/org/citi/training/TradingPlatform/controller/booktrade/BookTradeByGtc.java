package org.citi.training.TradingPlatform.controller.booktrade;

import java.util.ArrayList;
import java.util.List;

import org.citi.training.TradingPlatform.module.orderbook.OrderBook;

public class BookTradeByGtc extends BookTradeByGeneral {

	@Override
	protected List<OrderBook> getMatchOrderBookList(int quantity, double price, boolean isBuy)
			throws CloneNotSupportedException {
		if(isBuy)
			deleteLowPrice(price);
		else
			deleteHightPrice(price);
		
		List<OrderBook> matchOrderBookList = new ArrayList<OrderBook>();
		OrderBook orderBookTemp = null;
		OrderBook remain = (OrderBook) orderBookList.get(0).clone();
		while(true) {
			orderBookTemp = getBestPrice(isBuy);
			
			if(orderBookTemp == null) {
				deleteOrderBook(matchOrderBookList);
				remain.setQuantity(quantity);
				remain.setPrice(price);
				remain.setIsBuy(isBuy?1:0);
				orderBookOption.insertIntoOrderBook(remain);
				break;
			}
			
			if(orderBookTemp.getQuantity() > quantity) {
				deleteOrderBook(matchOrderBookList);
				OrderBook orderBookClone = (OrderBook) orderBookTemp.clone();
				orderBookClone.setQuantity(quantity);
				matchOrderBookList.add(orderBookClone);
				orderBookTemp.setQuantity(orderBookTemp.getQuantity()-quantity);
				modifyOrderBook(orderBookTemp);
				break;
			}
			quantity -= orderBookTemp.getQuantity();
			matchOrderBookList.add(orderBookTemp);
			orderBookList.remove(orderBookTemp);
		}
		return matchOrderBookList;
	}

}
