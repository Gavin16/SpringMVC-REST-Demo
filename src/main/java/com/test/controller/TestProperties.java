package com.test.controller;

import com.test.domain.UserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: ${FILE_NAME}
 * @Package: com.test.controller
 * @Description:
 * @author: Minsky
 * @date: 2018/5/15 20:41
 */
@RestController
@RequestMapping("/test")
@PropertySource(value = {"classpath:abc.properties","classpath:def.properties"})
public class TestProperties {

    @Value("${user.nickname}")
    private String name;

    @Value("${user.age}")
    private String age;

    @Value("${user.gender}")
    private String gender;

    @GetMapping(value = "/method")
    public Object getValue(){
        System.out.println("getValue called"+",name is "+name);
        UserDTO user = new UserDTO();
        user.setName("张三");
        user.setAge(age);
        user.setGender(gender);
        return user;
    }

}
