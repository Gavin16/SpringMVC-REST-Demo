package com.demo.service;


import com.alibaba.fastjson.JSONObject;
import com.demo.domain.queryparam.AddressParam;
import com.demo.exception.ServiceException;

public interface AddressService {

    /**
     * 解析格式化的地址：地址可以不包含省市 但是地址位置要求唯一
     * @param formatedAddress
     * @return
     */
    JSONObject parseAddress(String formatedAddress);


    /**
     *
     * @param addressParam
     * @return
     */
    JSONObject parseAddress(AddressParam addressParam) throws ServiceException;
}
