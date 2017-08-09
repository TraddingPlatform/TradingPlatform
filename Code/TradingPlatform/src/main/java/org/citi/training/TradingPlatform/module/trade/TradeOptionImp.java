package org.citi.training.TradingPlatform.module.trade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class TradeOptionImp implements TradeOption {
	
	private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
	public void insertIntoTrade(List<Trade> trades) {
		StringBuilder sql = new StringBuilder("INSERT INTO trade(trader_id, price, equity_symbol, is_buy, amount, create_time) VALUES");
		for(Trade trade : trades) {
			sql.append("(");
			sql.append(trade.getTraderId() + ",");
			sql.append(trade.getPrice() + ",\'");
			sql.append(trade.getEquitySymbol() + "\',");
			sql.append(trade.getIsBuy() + ",");
			sql.append(trade.getAmount() + ",");
			String dateString = "\'" + convertDateToString(trade.getCreatetime()) + "\'";
			sql.append(dateString);
			sql.append("),");
		}
		String resultSql = sql.substring(0, sql.length()-1);
    	jdbcTemplate.execute(resultSql);
	}
	
	private String convertDateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
}
