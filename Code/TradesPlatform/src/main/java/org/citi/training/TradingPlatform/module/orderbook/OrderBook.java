package org.citi.training.TradingPlatform.module.orderbook;

public class OrderBook implements Cloneable{
	
	private int id;
	private String equitySymbol;
	private int quantity;
	private int isBuy;
	private double price;
	
	public OrderBook() {
	}
	
	public OrderBook(int id, String equitySymbol, int quantity, int isBuy, double price) {
		super();
		this.id = id;
		this.equitySymbol = equitySymbol;
		this.quantity = quantity;
		this.isBuy = isBuy;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getIsBuy() {
		return isBuy;
	}

	public void setIsBuy(int isBuy) {
		this.isBuy = isBuy;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
