package org.citi.training.TradingPlatform.module.orderbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderBookOptionImp implements OrderBookOption {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insertIntoOrderBook(OrderBook orderBook) {
		StringBuilder sql = new StringBuilder(
				"INSERT INTO `OrderBook` (`equity_symbol`, `quantity`, `is_buy`, `price`, `trader_id`) VALUES");
		sql.append("(\'");
		sql.append(orderBook.getEquitySymbol());
		sql.append("\',");
		sql.append(orderBook.getQuantity());
		sql.append(",");
		sql.append(orderBook.getIsBuy());
		sql.append(",");
		sql.append(orderBook.getPrice());
		sql.append(",");
		sql.append(orderBook.getTraderId());
		sql.append(")");
		jdbcTemplate.execute(sql.toString());
	}

	public void deleteOrderBooks(double lowestPrice, double hightestPrice, int isBuy) {
		StringBuilder sql = new StringBuilder("DELETE FROM orderbook WHERE is_buy = ");
		sql.append(isBuy);
		sql.append(" AND price >= ");
		sql.append(lowestPrice);
		sql.append(" AND price <= ");
		sql.append(hightestPrice);
		jdbcTemplate.execute(sql.toString());
	}

	public void modifyOrderBookQuantity(OrderBook orderBook) {
		StringBuilder sql = new StringBuilder("UPDATE orderbook SET quantity = ");
		sql.append(orderBook.getQuantity());
		sql.append(" WHERE id = ");
		sql.append(orderBook.getId());
		jdbcTemplate.execute(sql.toString());
	}

	public void modifyOrderBook(OrderBook orderBook) {
		StringBuilder sql = new StringBuilder("UPDATE orderbook SET equity_symbol = \'");
		sql.append(orderBook.getEquitySymbol());
		sql.append("\', quantity = ");
		sql.append(orderBook.getQuantity());
		sql.append(", is_buy = ");
		sql.append(orderBook.getIsBuy());
		sql.append(", price = ");
		sql.append(orderBook.getPrice());
		sql.append(" WHERE id = ");
		sql.append(orderBook.getId());
		jdbcTemplate.execute(sql.toString());
	}

	@SuppressWarnings("unchecked")
	public List<OrderBook> getOrderBookListBySymbol(String equitySymbol, boolean isBuy) {
		int isBuyOrderBook = isBuy ? 0 : 1;
		List<OrderBook> list = jdbcTemplate.query(
				"select * from orderbook where equity_symbol = \"" + equitySymbol + "\" and is_buy = " + isBuyOrderBook,
				new OrderBookRowMapper());
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<OrderBook> getOrderBookListByTraderId(int traderId) {
		List<OrderBook> list = jdbcTemplate.query("select * from orderbook where trader_id = \"" + traderId + "\"",
				new OrderBookRowMapper());
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<OrderBook> getOrderBookList(String symbol) {
		List<OrderBook> list = jdbcTemplate.query("select * from orderbook WHERE equity_symbol = \"" + symbol + "\"",
				new OrderBookRowMapper());
		return list;
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, List<OrderBook>> getAllSymbolOrders(String symbol) {
		// TODO Auto-generated method stub
		List<OrderBook> returnDataType0 = jdbcTemplate.query(
				"select * from orderbook WHERE equity_symbol = \"" + symbol + "\"  and is_buy =  true order by price",
				new OrderBookRowMapper());
		List<OrderBook> returnDataType1 = jdbcTemplate.query("select * from orderbook WHERE equity_symbol = \"" + symbol
				+ "\"  and is_buy = false order by price desc", new OrderBookRowMapper());

		HashMap<String, List<OrderBook>> result = new HashMap<String, List<OrderBook>>();
		result.put("bid", returnDataType0);
		result.put("ask", returnDataType1);

		return result;
	}

	/*
	 * public HashMap<String, ArrayList<OrderBook>> getAllSymbolOrders (String
	 * symbol) throws ClassNotFoundException, SQLException {
	 * ArrayList<OrderBook> returnDataType1 = new ArrayList<> ();
	 * ArrayList<OrderBook> returnDataType0 = new ArrayList<> (); Connection
	 * connection = MySQLConnUtils.getMySQLConnection (); String sql1 =
	 * "select * from OrderBook where symbol = ? and type=1 order by price";
	 * PreparedStatement preparedStatement1 = connection.prepareStatement
	 * (sql1); preparedStatement1.setString (1, symbol); ResultSet rs1 =
	 * preparedStatement1.executeQuery (); while (rs1.next()){ OrderBook
	 * tradeBook = new OrderBook (); tradeBook.setId (rs1.getInt (1));
	 * tradeBook.setSymbol (rs1.getString (2)); tradeBook.setQuanlity
	 * (rs1.getInt (3)); tradeBook.setType (rs1.getInt (4)); tradeBook.setPrice
	 * (rs1.getDouble (5)); returnDataType1.add (tradeBook); }
	 * 
	 * System.out.println (returnDataType1);
	 * 
	 * String sql0 =
	 * "select * from OrderBook where symbol = ? and type=0 order by price desc"
	 * ; PreparedStatement preparedStatement0 = connection.prepareStatement
	 * (sql0); preparedStatement0.setString (1, symbol); ResultSet rs0 =
	 * preparedStatement0.executeQuery (); while (rs0.next()){ OrderBook
	 * tradeBook = new OrderBook (); tradeBook.setId (rs0.getInt (1));
	 * tradeBook.setSymbol (rs0.getString (2)); tradeBook.setQuanlity
	 * (rs0.getInt (3)); tradeBook.setType (rs0.getInt (4)); tradeBook.setPrice
	 * (rs0.getDouble (5)); returnDataType0.add (tradeBook); }
	 * System.out.println (returnDataType0);
	 * 
	 * rs1.close(); preparedStatement1.close(); rs0.close();
	 * preparedStatement0.close(); connection.close(); HashMap<String,
	 * ArrayList<OrderBook>> result = new HashMap<> (); result.put ("bid",
	 * returnDataType1); result.put ("ask", returnDataType0);
	 * 
	 * return result; }
	 */

}
