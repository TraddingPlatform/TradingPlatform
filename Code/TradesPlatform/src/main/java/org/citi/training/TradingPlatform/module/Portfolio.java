package org.citi.training.TradingPlatform.module;

import org.citi.training.TradingPlatform.module.tradehistory.TradeHistory;
import org.citi.training.TradingPlatform.server.TradeServer;

public class Portfolio {
	
	private String equitySymbol;
	private int quantity;
	private double principle;
	private double currentValue;
	
	public String getEquitySymbol() {
		return equitySymbol;
	}
	public void setEquitySymbol(String equitySymbol) {
		this.equitySymbol = equitySymbol;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrinciple() {
		return principle;
	}
	public void setPrinciple(double principle) {
		this.principle = principle;
	}
	public double getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}
	public void update(TradeHistory tradeHistory) {
		quantity += tradeHistory.getAmount();
		principle += tradeHistory.getPrice()*tradeHistory.getAmount();
		currentValue = quantity*TradeServer.getCurrentPrice().get(equitySymbol);
	}
}
