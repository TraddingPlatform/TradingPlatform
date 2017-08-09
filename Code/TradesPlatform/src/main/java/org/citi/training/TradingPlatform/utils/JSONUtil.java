package org.citi.training.TradingPlatform.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

import java.util.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @ClassName: JSONUtil
 * @Description: TODO
 * @Function List: TODO
 * @author: xtf
 * @version:
 * @Date: 2016/3/4 15:48
 * @History: //鍘嗗彶淇敼璁板綍
 * <author>  // 淇敼浜�
 * <time> //淇敼鏃堕棿
 * <version> //鐗堟湰
 * <desc> // 鎻忚堪淇敼鍐呭
 */
public class JSONUtil {
    protected static final Logger logger = LogManager.getLogger(JSONUtil.class);
    private static SerializeConfig mapping = new SerializeConfig();
    private static String dateFormat;
    static {
        dateFormat = "yyyy-MM-dd HH:mm:ss";
        mapping.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
    }
    /**
     * 瀵硅薄杞琷son瀛楃涓�
     * @param obj
     * @return
     */
    public static String toJsonString(Object obj) {
        try{;
            return JSON.toJSONString(obj, mapping);}
        catch (Exception e){
            logger.error(e);
            logger.info("json tranfer failure");
            return "";
        }

    }

    /**
     * 鑾峰彇json瀛楃涓蹭腑鎸囧畾灞炴�у悕鐨勫��
     * @param json
     * @param propertyName
     * @return
     */
    public static Object getPropertyValue(String json,String propertyName) {
        try {
            JSONObject obj = JSON.parseObject(json);
            return obj.get(propertyName);
        }catch (Exception e){
            logger.error(e);
            logger.info("json tranfer failure");
            return null;
        }
    }

    /**
     * 鑾峰彇json瀛楃涓蹭腑鎸囧畾灞炴�у悕String鍊�
     * @param json
     * @param propertyName
     * @return
     */
    public static String getPropertyStrValue(String json,String propertyName) {
        try {
            JSONObject obj = JSON.parseObject(json);
            String str = (String)(obj.get(propertyName));
            if(str != null)
                return str;
            return "";
        }catch (Exception e){
            logger.error(e);
            logger.info("json tranfer failure");
            return "";
        }
    }



    /**
     * 绉婚櫎json瀛楃涓蹭腑鎸囧畾灞炴�у悕锛屽苟杩斿洖绉婚櫎鍚庣殑缁撴灉
     * @param json
     * @param propertyName
     * @return
     */
    public static String removeProperty(String json, String propertyName){
        try{
            JSONObject obj = JSON.parseObject(json);
            Set set = obj.keySet();
            Object propertyValue = set.remove(propertyName);
            return obj.toString();
        }
        catch (Exception e){
            logger.error(e);
            logger.info("json tranfer failure");
            return "";
        }
    }

    /**
     * 淇敼json涓殑鏌愪釜灞炴�х殑鍊�
     * @param json
     * @param propertyName
     * @param propertyValue
     * @return
     */
    public static String updateProperty(String json,String propertyName, Object propertyValue){
        try{
            JSONObject obj = JSON.parseObject(json);
            Set set = obj.keySet();
            if(set.contains(propertyName))
                obj.put(propertyName, JSON.toJSONString(propertyValue));
            return obj.toString();
        }catch (Exception e){
            logger.error(e);
            logger.info("json tranfer failure");
            return "";
        }
    }

    /**
     * 鍒ゆ柇json涓槸鍚﹀瓨鍦ㄦ煇灞炴��
     * @param json
     * @param propertyName
     * @return
     */
    public static boolean isContainProperty(String json, String propertyName){
        try{
            boolean isContain = false;
            JSONObject obj = JSON.parseObject(json);
            Set set = obj.keySet();
            isContain = set.contains(propertyName);
            return isContain;
        }catch (Exception e){
            logger.error(e);
            logger.info("json tranfer failure");
            return false;
        }
    }

    /**
     * 娣诲姞json瀛楃涓蹭腑鏂扮殑灞炴�у強瀵瑰簲鐨勫�硷紝骞惰繑鍥炴坊鍔犲悗鐨勭粨鏋�
     * @param json
     * @param propertyName
     * @param propertyValue
     * @return
     */
    public static String addProperty(String json,String propertyName, Object propertyValue){
        try {
            JSONObject obj = JSON.parseObject(json);
            if (propertyValue instanceof String) {
                obj.put(propertyName, propertyValue);//濡傛灉鏄瓧绗︿覆涓嶉渶瑕佸啀杞垚json
            } else {
                obj.put(propertyName, JSON.toJSONString(propertyValue));
            }
            return obj.toString();
        }catch (Exception e){
            logger.error(e);
            logger.info("json tranfer failure");
            return "";
        }
    }




    /**
     * 娣诲姞澶氫釜灞炴��
     * @param json
     * @param propertyMap
     * @return
     */
    public static String addProperties(String json,Map<String,Object> propertyMap){
        try {
            JSONObject obj = JSON.parseObject(json);
            Set<String> set = propertyMap.keySet();
            for (String key : set) {
                Object propertyValue = propertyMap.get(key);
                if (propertyValue instanceof String) {
                    obj.put(key, propertyValue);//濡傛灉鏄瓧绗︿覆涓嶉渶瑕佸啀杞垚json
                } else {
                    obj.put(key, JSON.toJSONString(propertyValue));
                }

            }
            return obj.toString();
        }catch (Exception e){
            logger.error(e);
            logger.info("json tranfer failure");
            return "";
        }
    }

    /**
     * 娣诲姞澶氫釜灞炴��
     * @param propertyMap
     * @return
     */
    public static String addProperties(Map<String,Object> propertyMap){
        try {
            JSONObject obj = new JSONObject();
            Set<String> set = propertyMap.keySet();
            for (String key : set) {
                Object propertyValue = propertyMap.get(key);
                obj.put(key, propertyValue);
            }
            return toJsonString(obj);
        }catch (Exception e){
            logger.error(e);
            logger.info("json tranfer failure");
            return "{}";
        }
    }



    /**
     * 鍏堝皢瀵硅薄杞垚json瀛楃涓诧紝骞舵坊鍔犳柊鐨勫睘鎬�
     * @param obj
     * @param propertyName
     * @param propertyValue
     * @return
     */
    public static String convertAndAddProperty(Object obj, String propertyName, Object propertyValue){
        try {
            String json = toJsonString(obj);
            return addProperty(json, propertyName, propertyValue);
        }catch (Exception e){
            logger.error(e);
            logger.info("json tranfer failure");
            return "";
        }
    }


    /**
     * json瀛楃涓茶浆JSONObject
     * @param json
     * @return
     */
    public static JSONObject toJsonObject(String json){
        try {
            return JSON.parseObject(json);
        }catch (Exception e){
            logger.error(e);
            logger.info("json tranfer failure");
            return null;
        }
    }

    /**
     * json瀛楃涓茶浆javaBean瀵硅薄
     * @param str
     * @param clazz
     * @return
     */
    public static Object toBean(String str, Class<?> clazz){
        try {
            return JSON.parseObject(str, clazz);
        }
        catch (Exception e){
            logger.error(e);
            logger.info("json tranfer failure");
            return null;
        }
    }

    public static List toBeanList(String str, Class<?> clazz){
        try {
            List list = new ArrayList();
            JSONArray jsonArray = JSONArray.parseArray(str);
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(toBean(jsonArray.get(i).toString(),clazz));
            }
            return list;
        }
        catch (Exception e){
            logger.error(e);
            logger.info("json tranfer failure");
            return null;
        }
    }


    /**
     * 灏嗘暟缁勫舰寮忕殑json瀛楃涓茶浆鎴怢ist
     * @param jsonStr
     * @return
     */
    public static List<String> jsonArrayToList(String jsonStr) {
        try {

//            if(jsonStr.startsWith("{")){
//                jsonStr="["+jsonStr+"]";
//            }
            logger.info("transfer jsonArray start and json:["+jsonStr+"]");
            List<String> messages = new ArrayList<String>();
            JSONArray jsonArray = JSONArray.parseArray(jsonStr);
            for (int i = 0; i < jsonArray.size(); i++) {
                String message = (jsonArray.get(i)).toString();//蹇呴』浣跨敤toString
                messages.add(message);
            }
            return messages;
        } catch (Exception e) {
            logger.error(e);
            logger.info("transfer jsonArray failure");
            return null;
        }
    }


    public static Map jsonToMap(String json){
        return JSON.parseObject(json);
    }


}
