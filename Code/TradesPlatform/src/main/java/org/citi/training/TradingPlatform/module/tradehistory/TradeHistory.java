package org.citi.training.TradingPlatform.module.tradehistory;

import java.util.Date;

public class TradeHistory
{
    private int id;
    private int traderId;
    private Double price;
    private String equitySymbol;
    private int isBuy;
    private int amount;
    private Date createtime;
    public TradeHistory ()
    {
        super ();
        // TODO Auto-generated constructor stub
    }
	public TradeHistory(int id, int traderId, Double price, String equitySymbol, int isBuy, int amount,
			Date createtime) {
		super();
		this.id = id;
		this.traderId = traderId;
		this.price = price;
		this.equitySymbol = equitySymbol;
		this.isBuy = isBuy;
		this.amount = amount;
		this.createtime = createtime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTraderId() {
		return traderId;
	}
	public void setTraderId(int traderId) {
		this.traderId = traderId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getEquitySymbol() {
		return equitySymbol;
	}
	public void setEquitySymbol(String equitySymbol) {
		this.equitySymbol = equitySymbol;
	}
	public int getIsBuy() {
		return isBuy;
	}
	public void setIsBuy(int isBuy) {
		this.isBuy = isBuy;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
   
}
