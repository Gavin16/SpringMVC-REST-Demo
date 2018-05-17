package com.test.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @Package com.test.config
 * @Description: 配置类暂未生效
 * @author: Minsky
 * @date 2018/5/16 14:36
 */
@Configuration
public class JsonParamConfig extends WebMvcConfigurerAdapter {
//    @Autowired
//    private FastJsonHttpMessageConverter fastJsonHttpMessageConverter;
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        System.out.println("83245385934706545");
//        //converters.add(getConverter());
//        converters.add(fastJsonHttpMessageConverter);
//    }
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(fastJsonHttpMessageConverter);
//    }

    @Bean
    public StringHttpMessageConverter getConverter(){
        System.out.println("+++++++++++++++++++");
        StringHttpMessageConverter converter = new StringHttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        return converter;
    }

    @Bean
    public FastJsonHttpMessageConverter getJsonConverter(){
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        System.out.println("***********************");
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8,MediaType.TEXT_HTML));
        return converter;
    }

}
