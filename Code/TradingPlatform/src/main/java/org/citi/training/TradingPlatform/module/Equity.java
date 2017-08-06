package org.citi.training.TradingPlatform.module;

public class Equity
{
    private int id;
    private String symbol;
    private String latestPrice;
    public Equity ()
    {
        super ();
        // TODO Auto-generated constructor stub
    }
    public Equity (int id, String symbol, String latestPrice)
    {
        super ();
        this.id = id;
        this.symbol = symbol;
        this.latestPrice = latestPrice;
    }
    public int getId ()
    {
        return id;
    }
    public void setId (int id)
    {
        this.id = id;
    }
    public String getSymbol ()
    {
        return symbol;
    }
    public void setSymbol (String symbol)
    {
        this.symbol = symbol;
    }
    public String getLatestPrice ()
    {
        return latestPrice;
    }
    public void setLatestPrice (String latestPrice)
    {
        this.latestPrice = latestPrice;
    }
    
    
}
