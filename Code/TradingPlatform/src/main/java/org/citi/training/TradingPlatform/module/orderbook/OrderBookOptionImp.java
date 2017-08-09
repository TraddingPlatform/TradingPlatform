package org.citi.training.TradingPlatform.module.orderbook;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderBookOptionImp implements OrderBookOption {
	
	private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public void insertIntoOrderBook(OrderBook orderBook) {
    	StringBuilder sql = new StringBuilder("INSERT INTO `OrderBook` (`equity_symbol`, `quantity`, `is_buy`, `price`) VALUES");
		sql.append("(\'");
		sql.append(orderBook.getEquitySymbol());
		sql.append("\',");
		sql.append(orderBook.getQuantity());
		sql.append(",");
		sql.append(orderBook.getIsBuy());
		sql.append(",");
		sql.append(orderBook.getPrice());
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
		List<OrderBook> list = jdbcTemplate.query("select * from orderbook where equity_symbol = \"" 
				+ equitySymbol + "\" and is_buy = " + isBuyOrderBook, new OrderBookRowMapper());
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<OrderBook> getOrderBookListByTraderId(int traderId) {
		List<OrderBook> list = jdbcTemplate.query("select * from orderbook where trader_id = \"" 
				+ traderId + "\"", new OrderBookRowMapper());
		return list;
	}
	
}
