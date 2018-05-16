package com.test.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: test-normal-config
 * @Package com.test.config
 * @Description:
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
