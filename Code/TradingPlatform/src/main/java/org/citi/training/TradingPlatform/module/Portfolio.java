package org.citi.training.TradingPlatform.module;

public class Portfolio
{
    private String id;
    private String traderId;
    private String equityId;
    private int amount;
    private Double price;
    public Portfolio ()
    {
        super ();
        // TODO Auto-generated constructor stub
    }
    public Portfolio (String id, String traderId, String equityId, int amount,
        Double price)
    {
        super ();
        this.id = id;
        this.traderId = traderId;
        this.equityId = equityId;
        this.amount = amount;
        this.price = price;
    }
    public String getId ()
    {
        return id;
    }
    public void setId (String id)
    {
        this.id = id;
    }
    public String getTraderId ()
    {
        return traderId;
    }
    public void setTraderId (String traderId)
    {
        this.traderId = traderId;
    }
    public String getEquityId ()
    {
        return equityId;
    }
    public void setEquityId (String equityId)
    {
        this.equityId = equityId;
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
