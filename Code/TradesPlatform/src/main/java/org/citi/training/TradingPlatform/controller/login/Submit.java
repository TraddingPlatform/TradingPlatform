package org.citi.training.TradingPlatform.controller.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.citi.training.TradingPlatform.controller.booktrade.BookTrade;
import org.citi.training.TradingPlatform.utils.JSONUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;


@Controller // @Controller 代表本Java类是controller控制层
public class Submit {
    
    private ApplicationContext ctx;

	@RequestMapping(value = "/submit", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String submit2(@RequestBody String j)throws IOException{

	        JSONObject jo= JSONUtil.toJsonObject(j);

	        System.out.println("submit json:"+jo);
	        Map<String,Object> map=new HashMap<String, Object>();
	    	ctx = new ClassPathXmlApplicationContext("bean.xml");
	    	BookTrade bookTrade = (BookTrade) ctx.getBean("bookTradeBy"+jo.getString("tradeType"));
	        Integer traderId=Integer.valueOf(jo.getString("traderId"));
	        String equitySymbol=jo.getString("equitySymbol");

	        Integer quantity=Integer.valueOf(jo.getString("quantity"));
	        Double price=Double.valueOf(jo.getString("price"));
	        boolean isBuy=jo.getString("isBuy").equals("BUY");
			boolean success = bookTrade.bookTrade(traderId, equitySymbol, quantity, price, isBuy);
			
	        map.put("message",success);
	        
	        return JSONUtil.toJsonString(map);
    }
	
}
	

    
    
    
   