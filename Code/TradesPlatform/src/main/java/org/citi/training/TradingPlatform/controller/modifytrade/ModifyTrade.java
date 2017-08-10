package org.citi.training.TradingPlatform.controller.modifytrade;

public interface ModifyTrade {
	public boolean modifyTrade(int orderBookId, String equitySymbol,
			int quantity, double price, boolean isBuy, int traderId);
	
	public boolean cancelTrade(int orderBookId);
}
