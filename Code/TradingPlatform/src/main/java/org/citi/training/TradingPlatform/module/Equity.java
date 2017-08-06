package org.citi.training.TradingPlatform.module;

public class Equity
{
    private String id;
    private String symbol;
    private String latestPrice;
    public Equity ()
    {
        super ();
        // TODO Auto-generated constructor stub
    }
    public Equity (String id, String symbol, String latestPrice)
    {
        super ();
        this.id = id;
        this.symbol = symbol;
        this.latestPrice = latestPrice;
    }
    public String getId ()
    {
        return id;
    }
    public void setId (String id)
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
