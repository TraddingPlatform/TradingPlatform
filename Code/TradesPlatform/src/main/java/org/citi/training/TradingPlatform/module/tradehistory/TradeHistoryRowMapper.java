package org.citi.training.TradingPlatform.module.tradehistory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class TradeHistoryRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		TradeHistory tradeHistory = new TradeHistory();
		tradeHistory.setId(rs.getInt("id"));
		tradeHistory.setTraderId(rs.getInt("trader_id"));
		tradeHistory.setPrice(rs.getDouble("price"));
		tradeHistory.setEquitySymbol(rs.getString("equity_symbol"));
		tradeHistory.setIsBuy(rs.getInt("is_buy"));
		tradeHistory.setAmount(rs.getInt("amount"));
		tradeHistory.setCreatetime(convertStringToDate(rs.getString("create_time")));
		return null;
	}
	
	private Date convertStringToDate(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
