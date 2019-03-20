package com.demo.exception;

public class ServiceException extends RuntimeException{
    private Integer code;

    private String msg;

    public ServiceException(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public ServiceException(String msg,Throwable e){
        super(msg,e);
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
