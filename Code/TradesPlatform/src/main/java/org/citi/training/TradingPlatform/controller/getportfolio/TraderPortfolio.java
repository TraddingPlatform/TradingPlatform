package org.citi.training.TradingPlatform.controller.getportfolio;

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
public class TraderPortfolio {

    private ApplicationContext ctx;

    @RequestMapping(value = "/traderPortfolio", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String GetTradeHistory(@RequestBody String j)throws IOException{
    			System.out.println(j);
	        JSONObject jo= JSONUtil.toJsonObject(j);
	        System.out.println("transfered json tradehistory:"+jo);
	        Integer traderId=Integer.valueOf(jo.getString("traderId"));
	        ctx = new ClassPathXmlApplicationContext("bean.xml");
	        GetPortfolioImp getPortfolioImp = (GetPortfolioImp) ctx.getBean("getTraderPortfolio");
	    	String result = getPortfolioImp.getPortfolio(traderId);
	        return result;
    }
    
}