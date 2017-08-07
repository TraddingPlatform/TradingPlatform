package org.citi.training.TradingPlatform.module;

public class Trader {
	
	private String id;
	private String name;
	private String password;
	private String email;
	
    public Trader ()
    {
        super ();
        // TODO Auto-generated constructor stub
    }
    
    public Trader (String id, String name, String password, String email)
    {
        super ();
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }
    public String getId ()
    {
        return id;
    }
    public void setId (String id)
    {
        this.id = id;
    }
    public String getName ()
    {
        return name;
    }
    public void setName (String name)
    {
        this.name = name;
    }
    public String getPassword ()
    {
        return password;
    }
    public void setPassword (String password)
    {
        this.password = password;
    }
    public String getEmail ()
    {
        return email;
    }
    public void setEmail (String email)
    {
        this.email = email;
    }
}
