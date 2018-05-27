package com.demo.result;

/**
 * @Title: dubbo-springboot-myms
 * @Package result
 * @Description:
 * @author: eta
 * @date 2018/5/8 14:27
 */
public class ResultBody<T> {
    private Integer code;

    private String msg;

    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
