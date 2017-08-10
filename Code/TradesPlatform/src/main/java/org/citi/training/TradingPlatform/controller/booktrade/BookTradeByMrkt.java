package org.citi.training.TradingPlatform.controller.booktrade;

import java.util.ArrayList;
import java.util.List;

import org.citi.training.TradingPlatform.module.orderbook.OrderBook;

public class BookTradeByMrkt extends BookTradeByGeneral {

	protected List<OrderBook> getMatchOrderBookList(int quantity, double price, boolean isBuy) throws CloneNotSupportedException {
		List<OrderBook> matchOrderBookList = new ArrayList<OrderBook>();
		OrderBook orderBook = null;
		while(true) {
			orderBook = getBestPrice(isBuy);
			
			if(orderBook == null) {
				matchOrderBookList.clear();
				break;
			}
			
			if(orderBook.getQuantity() > quantity) {
				deleteOrderBook(matchOrderBookList);
				OrderBook orderBookClone = (OrderBook) orderBook.clone();
				orderBookClone.setQuantity(quantity);
				matchOrderBookList.add(orderBookClone);
				orderBook.setQuantity(orderBook.getQuantity()-quantity);
				modifyOrderBook(orderBook);
				break;
			}
			quantity -= orderBook.getQuantity();
			matchOrderBookList.add(orderBook);
			orderBookList.remove(orderBook);
		}
		return matchOrderBookList;
	}
}
