package org.citi.training.TradingPlatform.controller.getportfolio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.citi.training.TradingPlatform.module.Portfolio;
import org.citi.training.TradingPlatform.module.tradehistory.TradeHistory;
import org.citi.training.TradingPlatform.module.tradehistory.TradeHistoryOption;

import com.google.gson.Gson;

import net.sf.json.JSONArray;

public class GetPortfolioImp implements GetPortfolio{

	private TradeHistoryOption tradeHistoryOption;

	public void setTradeHistoryOption(TradeHistoryOption tradeHistoryOption) {
		this.tradeHistoryOption = tradeHistoryOption;
	}

	public String getPortfolio(int traderId) {
		List<TradeHistory> tradeHistoryList = tradeHistoryOption.getTradeHistory(traderId);
		Map<String,Portfolio> protfolioMap = groupbyEquitySymbol(tradeHistoryList);
		// JSONArray json = JSONArray.fromObject(protfolioMap.values());
		
		return new Gson().toJson(protfolioMap);
	}

	private Map<String,Portfolio> groupbyEquitySymbol(List<TradeHistory> tradeHistoryList) {
		Map<String,Portfolio> protfolioMap = new HashMap<String,Portfolio>();
		for(TradeHistory tradeHistory: tradeHistoryList) {
			if(protfolioMap.get(tradeHistory.getEquitySymbol()) == null) {
				Portfolio portfolio = new Portfolio();
				portfolio.setEquitySymbol(tradeHistory.getEquitySymbol());
				protfolioMap.put(tradeHistory.getEquitySymbol(), portfolio);
			}
			protfolioMap.get(tradeHistory.getEquitySymbol()).update(tradeHistory);
		}
		return protfolioMap;
	}
}
