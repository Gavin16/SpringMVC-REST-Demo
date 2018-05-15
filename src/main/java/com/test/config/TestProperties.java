package com.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: ${FILE_NAME}
 * @Package: com.test.config
 * @Description:
 * @author: Minsky
 * @date: 2018/5/15 20:41
 */
@RestController
@RequestMapping("test")
@PropertySource(value = {"classpath:abc.properties"})
public class TestProperties {

    @Value("${user.name}")
    private String name;

    @GetMapping("method")
    public String getValue(){
        return "Hello"+name;
    }

}
