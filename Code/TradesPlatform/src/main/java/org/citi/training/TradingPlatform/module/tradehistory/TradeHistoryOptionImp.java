package org.citi.training.TradingPlatform.module.tradehistory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class TradeHistoryOptionImp implements TradeHistoryOption {
	
	private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
	public void insertIntoTradeHistory(List<TradeHistory> trades) {
		StringBuilder sql = new StringBuilder("INSERT INTO tradehistory(trader_id, price, equity_symbol, is_buy, amount, create_time) VALUES");
		for(TradeHistory trade : trades) {
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

	@SuppressWarnings("unchecked")
	public List<TradeHistory> getTradeHistory(int limit, int offset, int traderId, String symbol) {
		int elementNumber = getTradesTotalNums (traderId);
		StringBuilder sql = new StringBuilder("SELECT * FROM tradehistory WHERE trader_id = ");
		sql.append(traderId);
		sql.append(" ");
		if(symbol != null) {
			sql.append(", AND equity_symbol = \'");
			sql.append(symbol);
			sql.append("\' ");
		}
		int startIndex = 0;
		if(elementNumber >= limit + (offset-1)*limit) {
			startIndex = elementNumber - limit - (offset-1)*limit;
		}
		sql.append("LIMIT ");
		sql.append(startIndex);
		sql.append(", ");
		sql.append(limit);
		return jdbcTemplate.query(sql.toString(),new TradeHistoryRowMapper());
	}
	
	@SuppressWarnings("rawtypes")
	private class CountRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Integer count= rs.getInt("COUNT(*)");
			return count;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TradeHistory> getTradeHistory(int traderId) {
		StringBuilder sql = new StringBuilder("SELECT * FROM tradehistory WHERE trader_id = ");
		sql.append(traderId);
		return jdbcTemplate.query(sql.toString(),new TradeHistoryRowMapper());
	}

    @SuppressWarnings("unchecked")
    public int getTradesTotalNums (int traderId)
    {
        // TODO Auto-generated method stub
        List<Integer> elementNumberList = jdbcTemplate.query("SELECT COUNT(*) FROM tradehistory",new CountRowMapper());
        int elementNumber = elementNumberList.get(0);
        return elementNumber;
    }
}
