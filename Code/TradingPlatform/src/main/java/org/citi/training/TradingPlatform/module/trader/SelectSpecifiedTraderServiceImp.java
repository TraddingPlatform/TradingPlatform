package org.citi.training.TradingPlatform.module.trader;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class SelectSpecifiedTraderServiceImp implements SelectSpecifiedTraderService {

	private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
	public Trader getTrader(String traderId) {
		@SuppressWarnings("unchecked")
		List<Trader> list = jdbcTemplate.query("select * from trader where id = " + traderId ,
										new TraderRowMapper());
        return list.get(0);
	}

}
