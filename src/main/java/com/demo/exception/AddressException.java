package com.demo.exception;

import com.demo.enums.AddressResultEnum;

/**
 * @Auther: Minsky
 * @Date: 2019/1/5 15:17
 * @Description:
 */
public class AddressException extends ServiceException {

    public AddressException(Integer code, String msg) {
        super(code, msg);
    }

    public AddressException(AddressResultEnum resultEnum){
        super(resultEnum.getCode(),resultEnum.getMsg());
    }


}
