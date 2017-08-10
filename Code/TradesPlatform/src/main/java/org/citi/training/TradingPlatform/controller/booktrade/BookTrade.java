package org.citi.training.TradingPlatform.controller.booktrade;

public interface BookTrade {
	public boolean bookTrade(int traderId, String equitySymbol,
						int quantity, double price, boolean isBuy);
}
