package com.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.domain.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

/**
 * @Package: com.demo.controller
 * @Description:
 * @author: Minsky
 * @date: 2018/5/15 20:41
 */
@RestController
@RequestMapping("/test")
@PropertySource(value = {"classpath:test/abc.properties", "classpath:test/def.properties"})
public class TestPropertyController {

    private static final Logger logger = LoggerFactory.getLogger(TestPropertyController.class);

    @Value("${user.nickname}")
    private String name;

    @Value("${user.age}")
    private String age;

    @Value("${user.gender}")
    private String gender;

    @GetMapping(value = "/getMethod")
    public Object getValue(){
        System.out.println("getValue called"+",name is "+name);
        UserDTO user = new UserDTO();
        user.setName("张三");
        user.setAge(age);
        user.setGender(gender);
        return user;
    }

    @PostMapping(value = "/postMethod")
    public Object postValue(@RequestBody String username){
        logger.info("postValue传入参数为:{}",username);

        JSONObject json = JSONObject.parseObject(username);
        String jsonName = json.getString("username");

        UserDTO user = new UserDTO();
        user.setName(jsonName);
        user.setAge(age);
        user.setGender(gender);
        return user;
    }
}
