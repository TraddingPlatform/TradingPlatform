package org.citi.training.TradingPlatform.module;

public class Portfolio
{
    private int id;
    private int traderId;
    private String equitySymbol;
    private int amount;
    private Double price;
    public Portfolio ()
    {
        super ();
        // TODO Auto-generated constructor stub
    }
    public Portfolio (int id, int traderId, String equitySymbol, int amount,
        Double price)
    {
        super ();
        this.id = id;
        this.traderId = traderId;
        this.equitySymbol = equitySymbol;
        this.amount = amount;
        this.price = price;
    }
    public int getId ()
    {
        return id;
    }
    public void setId (int id)
    {
        this.id = id;
    }
    public int getTraderId ()
    {
        return traderId;
    }
    public void setTraderId (int traderId)
    {
        this.traderId = traderId;
    }
    public String getequitySymbol ()
    {
        return equitySymbol;
    }
    public void setequitySymbol (String equitySymbol)
    {
        this.equitySymbol = equitySymbol;
    }
    public int getAmount ()
    {
        return amount;
    }
    public void setAmount (int amount)
    {
        this.amount = amount;
    }
    public Double getPrice ()
    {
        return price;
    }
    public void setPrice (Double price)
    {
        this.price = price;
    }
    
    
}