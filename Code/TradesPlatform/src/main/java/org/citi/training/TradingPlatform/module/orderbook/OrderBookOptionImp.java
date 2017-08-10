package org.citi.training.TradingPlatform.module.orderbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
=======
import java.sql.ResultSet;
import java.sql.SQLException;
>>>>>>> 687f7c3596b4ed879672f2ebda82e05a3ec75499
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class OrderBookOptionImp implements OrderBookOption {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insertIntoOrderBook(OrderBook orderBook) {
		StringBuilder sql = new StringBuilder(
				"INSERT INTO `OrderBook` (`equity_symbol`, `quantity`, `is_buy`, `price`, `trader_id`) VALUES");
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public void insertIntoOrderBook(OrderBook orderBook) {
    	StringBuilder sql = new StringBuilder("INSERT INTO `orderbook` (`equity_symbol`, `quantity`, `is_buy`, `price`, `trader_id`) VALUES");
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

	public boolean deleteOrderBooks(int orderBookId) {
		StringBuilder sql = new StringBuilder("DELETE FROM orderbook WHERE id = ");
		sql.append(orderBookId);
		try {
			jdbcTemplate.execute(sql.toString());
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
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
	public List<OrderBook> getOrderBookListByTraderId(int limit, int offset, int traderId, String symbol) {
		StringBuilder sql = new StringBuilder("SELECT * FROM orderbook WHERE trader_id = ");
		sql.append(traderId);
		sql.append(" ");
		System.out.println(symbol.length());
		if (symbol.length() != 0) {
			sql.append(" AND equity_symbol = \'");
			sql.append(symbol);
			sql.append("\' ");
		}
		sql.append("LIMIT ");
		sql.append(offset);
		sql.append(", ");
		sql.append(limit);
		System.out.println(sql);
		return jdbcTemplate.query(sql.toString(),new OrderBookRowMapper());
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
	
	@SuppressWarnings("rawtypes")
	private class CountRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Integer count= rs.getInt("COUNT(*)");
			return count;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public int getOrderBookTotalNums (int traderId) {
		List<Integer> elementNumberList = jdbcTemplate.query("SELECT COUNT(*) FROM orderbook where trader_id=" + traderId, new CountRowMapper());
        int elementNumber = elementNumberList.get(0);
        return elementNumber;
	}
}
