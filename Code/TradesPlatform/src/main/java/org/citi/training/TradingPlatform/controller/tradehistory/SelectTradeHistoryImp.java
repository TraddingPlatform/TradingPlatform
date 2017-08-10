package org.citi.training.TradingPlatform.controller.tradehistory;

import java.util.HashMap;
import java.util.List;

import org.citi.training.TradingPlatform.module.tradehistory.TradeHistory;
import org.citi.training.TradingPlatform.module.tradehistory.TradeHistoryOption;

import com.google.gson.Gson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject; 

public class SelectTradeHistoryImp implements SelectTradeHistory {

	private TradeHistoryOption tradeHistoryOption;

	public void setTradeHistoryOption(TradeHistoryOption tradeHistoryOption) {
		this.tradeHistoryOption = tradeHistoryOption;
	}

	public String selectTradeHistory(int limit, int offset, int traderId, String symbol) {
		List<TradeHistory> tradeHistoryList = tradeHistoryOption.getTradeHistory(limit, offset, traderId, symbol);
		int totalNums = tradeHistoryOption.getTradesTotalNums (traderId);
		HashMap<String, Object> returnResult = new HashMap<String, Object> ();
		returnResult.put ("total", totalNums);
		returnResult.put ("rows", tradeHistoryList);
		// JSONObject json = JSONObject.fromObject(returnResult);
		String json = new Gson().toJson(returnResult);
		return json;
	}

}
