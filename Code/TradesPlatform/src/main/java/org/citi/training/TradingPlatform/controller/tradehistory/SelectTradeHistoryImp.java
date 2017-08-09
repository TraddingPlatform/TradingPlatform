package org.citi.training.TradingPlatform.controller.tradehistory;

import java.util.List;

import org.citi.training.TradingPlatform.module.tradehistory.TradeHistory;
import org.citi.training.TradingPlatform.module.tradehistory.TradeHistoryOption;
import net.sf.json.JSONArray; 

public class SelectTradeHistoryImp implements SelectTradeHistory {

	private TradeHistoryOption tradeHistoryOption;

	public void setTradeHistoryOption(TradeHistoryOption tradeHistoryOption) {
		this.tradeHistoryOption = tradeHistoryOption;
	}

	public String selectTradeHistory(int limit, int offset, int traderId, String symbol) {
		List<TradeHistory> tradeHistoryList = tradeHistoryOption.getTradeHistory(limit, offset, traderId, symbol);
		JSONArray json = JSONArray.fromObject(tradeHistoryList);
		return json.toString();
	}

}
