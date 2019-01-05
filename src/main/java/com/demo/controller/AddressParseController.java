package com.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.domain.queryparam.AddressParam;
import com.demo.enums.AddressResultEnum;
import com.demo.exception.AddressException;
import com.demo.service.impl.AddressServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Minsky
 * @Date: 2019/1/5 15:09
 * @Description: 解析地址返回 省市区+经纬度+城市编码
 *  如
 */
@RestController
@RequestMapping("address")
public class AddressParseController {

    private static final Logger logger = LoggerFactory.getLogger(AddressParseController.class);

    @Autowired
    private AddressServiceImpl addressService;


    @RequestMapping("parse")
    public JSONObject parseAddress(@RequestBody AddressParam param) throws Exception {
        if (!isParamOk(param)) {
            logger.error("接口调用必传参数为空");
            throw new AddressException(AddressResultEnum.PARAM_EMPTY_ERROR);
        }

        return addressService.parseAddress(param);
    }


    /**
     * 判断必传参数是否为空
     *
     * @param param
     * @return
     */
    private boolean isParamOk(AddressParam param) {
        if (null == param || StringUtils.isEmpty(param.getAddress())) {
            return false;
        }
        return true;
    }
}
