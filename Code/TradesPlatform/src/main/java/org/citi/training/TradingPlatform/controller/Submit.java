package org.citi.training.TradingPlatform.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import org.citi.training.TradingPlatform.controller.booktrade.BookTrade;

import org.citi.training.TradingPlatform.module.trader.Trader;
import org.citi.training.TradingPlatform.utils.JSONUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;


@Controller // @Controller 代表本Java类是controller控制层
public class submit {

    /**
     * @RequestParam注解的作用是：根据参数名从URL中取得参数值
     * @param username
     *            用户名，一定要对应着表单的name才行
     * @param password
     *            用户密码，也应该对应表单的数据项
     * @param model
     *            一个域对象，可用于存储数据值
     * @return
     */
	
	
	
	
    
    @RequestMapping(value = "/submit", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteManagerById(@RequestBody String j)throws IOException{


	        JSONObject jo= JSONUtil.toJsonObject(j);
	        System.out.println("transfered json:"+jo);
	       String equitySymbol=jo.getString("equitySymbol");
	        System.out.println("managerid:"+equitySymbol);

//	        int res=fundManagerService.deleteManager();
//	        System.out.println("res:["+res+"]");
        Map<String,Object> map=new HashMap();
//	        String message="";
//	        if(res>=1)message="success";
//	        else message="failed";
	        map.put("message","success");
	        return JSONUtil.toJsonString(map);
    }
   
    
    
    @RequestMapping(value = "/submit2", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String submit2(@RequestBody String j)throws IOException{


	        JSONObject jo= JSONUtil.toJsonObject(j);

	        System.out.println("submit json:"+jo);

	       
//	        int res=fundManagerService.deleteManager(managerid);
//	        System.out.println("res:["+res+"]");
	        Map<String,Object> map=new HashMap();
	        String message="";
	        
	        
	    	ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
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
	

    
    
    
   