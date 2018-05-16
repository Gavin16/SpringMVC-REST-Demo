package com.test.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.util.Arrays;

/**
 * @Title: test-normal-config
 * @Package com.test.config
 * @Description: 配置类暂未生效
 * @author: Minsky
 * @date 2018/5/16 14:36
 */
@Configuration
public class JsonParamConfig {

    @Bean
    public StringHttpMessageConverter getConverter(){
        StringHttpMessageConverter converter = new StringHttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        return converter;
    }

    @Bean
    public FastJsonHttpMessageConverter getJsonConverter(){
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8,MediaType.TEXT_HTML));
        return converter;
    }

}
