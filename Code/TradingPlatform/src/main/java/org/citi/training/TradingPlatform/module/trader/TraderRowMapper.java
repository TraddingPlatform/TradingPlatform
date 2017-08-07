package org.citi.training.TradingPlatform.module.trader;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class TraderRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Trader trader = new Trader();
		trader.setId(rs.getInt("id"));
		trader.setPassword(rs.getString("password"));
		trader.setName(rs.getString("name"));
		trader.setEmail(rs.getString("email"));
		return trader;
	}

}
