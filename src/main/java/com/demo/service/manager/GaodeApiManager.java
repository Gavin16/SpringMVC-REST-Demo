package com.demo.service.manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.service.impl.AddressServiceImpl;
import com.demo.utils.HttpUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Auther: Minsky
 * @Date: 2019/1/5 16:36
 * @Description:
 */
@Service
public class GaodeApiManager {
    private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

    @Value("${gaode.addrParse.key}")
    private String appkey;

    private static final String KEY = "key";

    /**
     * 高德地理编码 API 服务
     * @param url
     * @param param
     * @return
     */
    public JSONObject geoEncodeService(String url, Map<String,String> param){
        // 添加调用 appKey
        param.put(KEY,appkey);
        logger.info("高德地理编码接口调用传参为：{}",param);
        String res = HttpUtil.get(url,param);
        logger.info("高德地理编码接口返回结果：{}",res);
        if(StringUtils.isNotEmpty(res)){
            JSONObject jsonRes = JSON.parseObject(res);
            return jsonRes;
        }
        return null;
    }
}
