package com.demo.utils;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Minsky
 * @Date: 2019/1/5 16:18
 * @Description: 提供集合到Bean之间的转换
 */
public class ConvertUtil {

    private static final Logger logger = LoggerFactory.getLogger(ConvertUtil.class);

    /**
     * JavaBean 转化为 Map
     *
     * @param object
     * @return 若调用失败返回null
     */
    public static Map<String, String> convertBeanToMap(Object object) {
        Map<String, String> map = new HashMap<>();

        // 获取Object中所有的属性
        Field[] fields = object.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);

                if (field.get(object) != null && !"".equals(field.get(object).toString())) {
                    // 将属性名及属性所在对象的值存入 Map
                    map.put(field.getName(), field.get(object).toString());
                }
            }
            return map;
        } catch (IllegalAccessException e) {
            logger.error("javaBean转为Map处理异常{}", e);
        }

        return null;
    }

    /**
     * @param map
     * @return
     * @Desctiption: 使用JSON 将map转化为Object;
     */
    public static <T> T convertMapToBean(Map<String,Object> map,Class<T> clazz){
        String jsonString = JSON.toJSONString(map);
        return JSON.parseObject(jsonString,clazz);
    }

    /**
     * 使用 fastJson 将JavaBean 对象转化为Map
     * @return
     */
    public static Map<String,String> convertBeanToMapWithJson(Object obj){
        try {
            String jsonStr = JSON.toJSONString(obj);
            Map<String,String> map = JSON.parseObject(jsonStr,Map.class);
            return map;
        } catch (Exception e) {
            logger.error("使用json将Bean转Map异常:{}",e);
        }
        return null;
    }
}
