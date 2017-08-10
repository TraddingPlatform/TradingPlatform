package org.citi.training.TradingPlatform.controller.tradehistory;

import java.io.IOException;

import org.citi.training.TradingPlatform.utils.JSONUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
public class TradeHistory {

    private ApplicationContext ctx;

    @RequestMapping(value = "/orderHistory", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String GetTradeHistory(@RequestBody String j)throws IOException{
	        JSONObject jo= JSONUtil.toJsonObject(j);
	        System.out.println("transfered json tradehistory:"+jo);
	        Integer limit=Integer.valueOf(jo.getString("limit"));
	        Integer offset=Integer.valueOf(jo.getString("offset"));
	        Integer traderId=Integer.valueOf(jo.getString("traderId"));
	        String symbol=jo.getString("symbol");
	        ctx = new ClassPathXmlApplicationContext("bean.xml");
	        SelectTradeHistoryImp selectTradeHistoryImp = (SelectTradeHistoryImp) ctx.getBean("selectTradeHistory");
	    	String result = selectTradeHistoryImp.selectTradeHistory(limit,offset,traderId,symbol);
	        return result;
    }
    
}
