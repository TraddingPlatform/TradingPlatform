package org.citi.training.TradingPlatform.module.tradehistory;

import java.util.List;

public interface TradeHistoryOption {
	
	public void insertIntoTradeHistory(List<TradeHistory> trades);
	
	public List<TradeHistory> getTradeHistory(int limit, int offset, int traderId, String symbol);
	
}
