package org.citi.training.TradingPlatform.module;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class TraderRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Trader trader = new Trader();
		trader.setId(rs.getString("id"));
		trader.setPassword(rs.getString("password"));
		return trader;
	}

}
