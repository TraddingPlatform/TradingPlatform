package org.citi.training.TradingPlatform.controller.booktrade;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.citi.training.TradingPlatform.module.orderbook.OrderBook;
import org.citi.training.TradingPlatform.module.orderbook.OrderBookOption;
import org.citi.training.TradingPlatform.module.tradehistory.TradeHistory;
import org.citi.training.TradingPlatform.module.tradehistory.TradeHistoryOption;
import org.citi.training.TradingPlatform.server.TradeServer;

public abstract class BookTradeByGeneral implements BookTrade {

	private TradeHistoryOption tradeHistoryOption;
	protected OrderBookOption orderBookOption;
	protected List<OrderBook> orderBookList;
	
	public void setTradeHistoryOption(TradeHistoryOption tradeHistoryOption) {
		this.tradeHistoryOption = tradeHistoryOption;
	}

	public void setOrderBookOption(OrderBookOption orderBookOption) {
		this.orderBookOption = orderBookOption;
	}
	
	public boolean bookTrade(int traderId, String equitySymbol, int quantity, double price, boolean isBuy) {
		orderBookList = orderBookOption.getOrderBookListBySymbol(equitySymbol, isBuy);
		List<OrderBook> matchOrderBookList = null;
		try {
			matchOrderBookList = getMatchOrderBookList(quantity, price, isBuy,traderId);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		if(matchOrderBookList==null || matchOrderBookList.size() == 0) {
			return false;
		}
		
		try {
			recordTrade(traderId, matchOrderBookList);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	protected abstract List<OrderBook> getMatchOrderBookList(int quantity, double price, boolean isBuy, int traderId) throws CloneNotSupportedException;
	
	protected final OrderBook getBestPrice(boolean isBuy) {
		double bestPrice = isBuy ? Double.MAX_VALUE : 0;
		OrderBook target = null;
		for(OrderBook orderBook : orderBookList) {
			if((isBuy && orderBook.getPrice() < bestPrice) ||
					(!isBuy && orderBook.getPrice() > bestPrice)) {
				target = orderBook;
				bestPrice = orderBook.getPrice();
			}
		}
		return target;
	}

	protected final void recordTrade(int traderId, List<OrderBook> matchOrderBookList) throws CloneNotSupportedException {
		List<TradeHistory> trades = new ArrayList<TradeHistory>();
		for(OrderBook orderBook : matchOrderBookList){
			TradeHistory trade = new TradeHistory();
			trade.setTraderId(traderId);
			trade.setPrice(orderBook.getPrice());
			trade.setEquitySymbol(orderBook.getEquitySymbol());
			int isBuy = orderBook.getIsBuy()==0 ? 1 : 0;
			trade.setIsBuy(isBuy);
			trade.setAmount(orderBook.getQuantity());
			trade.setCreatetime(new Date(System.currentTimeMillis()));
			TradeHistory tradeAnother = (TradeHistory) trade.clone();
			tradeAnother.setTraderId(orderBook.getTraderId());
			int anotherIsBuy = orderBook.getIsBuy()==0 ? 0 : 1;
			trade.setIsBuy(anotherIsBuy);
			trades.add(trade);
			trades.add(tradeAnother);
			recordMarketPrice(trade);
		}
		tradeHistoryOption.insertIntoTradeHistory(trades);
	}
	
	private void recordMarketPrice(TradeHistory trade) {
		TradeServer.getCurrentPrice().put(trade.getEquitySymbol(),trade.getPrice());
		TradeServer.getSymbolSet().add(trade.getEquitySymbol());
	}
	
	protected final void deleteOrderBook(List<OrderBook> matchOrderBookList) {
	    if (matchOrderBookList.size () == 0)
        {
	        return;
        }
		double lowestPrice = Integer.MAX_VALUE;
		double hightestPrice = 0;
		int isBuy = matchOrderBookList.get(0).getIsBuy();
		for(OrderBook orderBook : matchOrderBookList) {
			if(orderBook.getPrice() > hightestPrice) {
				hightestPrice = orderBook.getPrice();
			}
			if(orderBook.getPrice() < lowestPrice) {
				lowestPrice = orderBook.getPrice();
			}
		}
		orderBookOption.deleteOrderBooks(lowestPrice, hightestPrice, isBuy);
	}
	
	protected final void modifyOrderBook(OrderBook orderBook) {
		orderBookOption.modifyOrderBookQuantity(orderBook);
	}
	
	protected void deleteLowPrice(double price) {
		Iterator<OrderBook> iterator = orderBookList.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getPrice() < price) {
				iterator.remove();
			}
		}
	}
	
	protected void deleteHightPrice(double price) {
		Iterator<OrderBook> iterator = orderBookList.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getPrice() > price) {
				iterator.remove();
			}
		}
	}
}
