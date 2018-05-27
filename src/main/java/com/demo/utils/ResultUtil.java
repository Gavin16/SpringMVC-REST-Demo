package com.demo.utils;

import com.demo.enums.ResultEnum;
import com.demo.result.ResultBody;

/**
 * @Title: ${FILE_NAME}
 * @Package: com.demo.utils
 * @Description:
 * @author: Minsky
 * @date: 2018/5/19 15:56
 */
public class ResultUtil {

    public static ResultBody success(Object obj) {
        ResultBody result = new ResultBody();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(obj);
        return result;
    }

    public static ResultBody error(ResultEnum resultEnum) {
        ResultBody result = new ResultBody();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(null);
        return result;
    }
}
