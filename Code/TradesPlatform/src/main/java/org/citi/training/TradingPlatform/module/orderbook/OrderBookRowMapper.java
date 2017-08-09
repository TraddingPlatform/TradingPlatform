package org.citi.training.TradingPlatform.module.orderbook;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class OrderBookRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderBook orderBook = new OrderBook();
		orderBook.setId(rs.getInt("id"));
		orderBook.setEquitySymbol(rs.getString("equity_symbol"));
		orderBook.setQuantity(rs.getInt("quantity"));
		orderBook.setIsBuy(rs.getInt("is_buy"));
		orderBook.setPrice(rs.getDouble("price"));
		return orderBook;
	}
}
