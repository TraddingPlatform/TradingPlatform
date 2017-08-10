package org.citi.training.TradingPlatform.controller.modifytrade;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.citi.training.TradingPlatform.utils.JSONUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

@Controller
public class TradeCancle {

    private ApplicationContext ctx;

    @RequestMapping(value = "/tradeCancle", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String GetTradeHistory(@RequestBody String j)throws IOException{
    			System.out.println(j);
	        JSONObject jo= JSONUtil.toJsonObject(j);
	        System.out.println("transfered json tradehistory:"+jo);
	        Integer orderBookId = Integer.valueOf(jo.getString("orderBookId"));
	        ctx = new ClassPathXmlApplicationContext("bean.xml");
	        	ModifyTradeImp modifyTradeImp = (ModifyTradeImp)ctx.getBean("modifyTrade");
	        boolean result = modifyTradeImp.cancelTrade(orderBookId);
	        Map<String, Object> returnMap = new HashMap<String, Object>();
	        returnMap.put("result", result);
	        return new Gson().toJson(returnMap);
    }
    
}
