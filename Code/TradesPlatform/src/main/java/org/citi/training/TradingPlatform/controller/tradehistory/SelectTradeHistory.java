package org.citi.training.TradingPlatform.controller.tradehistory;

public interface SelectTradeHistory {
	
	public String selectTradeHistory(int limit, int offset, int traderId, String symbol);
	
}
