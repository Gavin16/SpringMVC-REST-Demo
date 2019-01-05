package com.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.demo.domain.queryparam.AddressParam;
import com.demo.enums.AddressResultEnum;
import com.demo.exception.AddressException;
import com.demo.exception.ServiceException;
import com.demo.service.AddressService;
import com.demo.service.manager.GaodeApiManager;
import com.demo.utils.Constants;
import com.demo.utils.ConvertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * @Auther: Minsky
 * @Date: 2019/1/5 15:02
 * @Description: 提供地理编码功能
 */
@Service
public class AddressServiceImpl implements AddressService {

    private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

    @Value("${gaode.geocode.url}")
    private String gdAddressGeoUrl;

    @Autowired
    private GaodeApiManager gaodeApiManager;

    @Override
    public JSONObject parseAddress(String formatedAddress) {
        return null;
    }

    @Override
    public JSONObject parseAddress(AddressParam addressParam) throws ServiceException {
        logger.info("地址解析传入参数为:{}",String.valueOf(addressParam));
        Map<String, String> queryparam = ConvertUtil.convertBeanToMap(addressParam);

        if (CollectionUtils.isEmpty(queryparam)) {
            throw new AddressException(AddressResultEnum.SYS_BUSY_ERROR);
        }

        JSONObject queryResult = gaodeApiManager.geoEncodeService(gdAddressGeoUrl,queryparam);

        if(CollectionUtils.isEmpty(queryResult)){
            throw new AddressException(AddressResultEnum.SYS_BUSY_ERROR);
        }else if("0".equals(queryResult.getString(Constants.AddressConstants.STATUS))){
            // 外部接口调用失败
            throw new AddressException(AddressResultEnum.EXT_SERVICE_MSG.getCode(),
                    queryResult.getString(Constants.AddressConstants.INFO));
        }

        return queryResult;
    }


}
