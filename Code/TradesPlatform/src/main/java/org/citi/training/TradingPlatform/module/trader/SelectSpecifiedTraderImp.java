package org.citi.training.TradingPlatform.module.trader;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class SelectSpecifiedTraderImp implements SelectSpecifiedTrader {

	private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
	public Trader getTrader(String traderName) {
		@SuppressWarnings("unchecked")
		List<Trader> list = jdbcTemplate.query("select * from trader where name = \"" 
									+ traderName + "\"",new TraderRowMapper());
		if(list.size() == 0) {
			return null;
		}
        return list.get(0);
	}

}
