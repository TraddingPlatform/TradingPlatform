package org.citi.training.TradingPlatform.module;

public class Strategy
{
    private int id;
    private int equityId;
    private int lossThreshold;
    private int profitThreshold;
    private int traderId;
    private String createtime;
    public Strategy ()
    {
        super ();
        // TODO Auto-generated constructor stub
    }
    public Strategy (int id, int equityId, int lossThreshold,
        int profitThreshold, int traderId, String createtime)
    {
        super ();
        this.id = id;
        this.equityId = equityId;
        this.lossThreshold = lossThreshold;
        this.profitThreshold = profitThreshold;
        this.traderId = traderId;
        this.createtime = createtime;
    }
    public int getId ()
    {
        return id;
    }
    public void setId (int id)
    {
        this.id = id;
    }
    public int getEquityId ()
    {
        return equityId;
    }
    public void setEquityId (int equityId)
    {
        this.equityId = equityId;
    }
    public int getLossThreshold ()
    {
        return lossThreshold;
    }
    public void setLossThreshold (int lossThreshold)
    {
        this.lossThreshold = lossThreshold;
    }
    public int getProfitThreshold ()
    {
        return profitThreshold;
    }
    public void setProfitThreshold (int profitThreshold)
    {
        this.profitThreshold = profitThreshold;
    }
    public int getTraderId ()
    {
        return traderId;
    }
    public void setTraderId (int traderId)
    {
        this.traderId = traderId;
    }
    public String getCreatetime ()
    {
        return createtime;
    }
    public void setCreatetime (String createtime)
    {
        this.createtime = createtime;
    }
    
    
}
