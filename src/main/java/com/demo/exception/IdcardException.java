package com.demo.exception;

import com.demo.enums.IdcardResultEnum;

public class IdcardException extends ServiceException {


    public IdcardException(Integer code, String msg) {
        super(code, msg);
    }

    public IdcardException(IdcardResultEnum resultEnum){
        super(resultEnum.getCode(),resultEnum.getMsg());
    }
}
