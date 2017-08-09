package org.citi.training.TradingPlatform.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.citi.training.TradingPlatform.module.trader.SelectSpecifiedTrader;
import org.citi.training.TradingPlatform.module.trader.SelectSpecifiedTraderImp;
import org.citi.training.TradingPlatform.module.trader.Trader;
import org.citi.training.TradingPlatform.utils.JSONUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import sun.misc.BASE64Encoder;

@Controller // @Controller 代表本Java类是controller控制层
public class Login {

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
	
   /* @RequestMapping("/login") // @RequestMapping 注解可以用指定的URL路径访问本控制层
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
            Model model) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		SelectSpecifiedTraderServiceImp selectSpecifiedTraderServiceImp = (SelectSpecifiedTraderServiceImp) ctx.getBean("traderService");
    	Trader trader = selectSpecifiedTraderServiceImp.getTrader(username);
    	if(trader == null) {
			return "no";
		} else if (trader.getPassword().equals(password)) {
			return "newSubmit";

		} else {
			return "no";
		}

    }*/
    
    private String encoderByMd5(String str) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		BASE64Encoder base64en = new BASE64Encoder();
		String newstr = null;
		try {
			newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return newstr;
	}
    
    
    
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String login(@RequestBody String j)throws IOException{


	        JSONObject jo= JSONUtil.toJsonObject(j);
	        System.out.println("transfered jsonaaaSlogin:"+jo);
	        String username=jo.getString("username");
	        String inputPassword=jo.getString("inputPassword");

	        /*System.out.println("equitySymbol:"+equitySymbol);
	        System.out.println("quantity:"+jo.getString("quantity"));
	        System.out.println("price:"+jo.getString("price"));
	        System.out.println("isBuy:"+jo.getString("isBuy"));
	        System.out.println("tradeType:"+jo.getString("tradeType"));
	        System.out.println("profit:"+jo.getString("profit"));
	        System.out.println("loss:"+jo.getString("loss"));*/

	       
//	        int res=fundManagerService.deleteManager(managerid);
//	        System.out.println("res:["+res+"]");
	        Map<String,Object> map=new HashMap();
	        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
	        SelectSpecifiedTraderImp selectSpecifiedTraderServiceImp = (SelectSpecifiedTraderImp) ctx.getBean("traderService");
	    	Trader trader = selectSpecifiedTraderServiceImp.getTrader(username);
	    	if(trader == null) {
	    		
		        map.put("message","failed");

			} else if (trader.getPassword().equals(inputPassword)) {
		        map.put("message","success");
		        map.put("traderId", trader.getId());

			} else {
		        map.put("message","failed");

			}
	        
	    	/*ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
	    	BookTrade bookTrade = (BookTrade) ctx.getBean("bookTradeBy"+jo.getString("tradeType"));
	        String quantity=jo.getString("quantity");
	        String price=jo.getString("price");
	        String isBuy=jo.getString("isBuy");

			//boolean success = bookTrade.bookTrade(1, equitySymbol, quantity, price, isBuy);
*/
	        
	        return JSONUtil.toJsonString(map);
	        
	        
    }

}
