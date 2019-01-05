package com.demo.enums;

/**
 * @Title: ${FILE_NAME}
 * @Package: com.demo.enums
 * @Description:
 * @author: Minsky
 * @date: 2018/5/19 16:02
 */
public enum ResultEnum {

    SUCCESS(10000,"调用成功"),
    QUERY_FAILURE(10001,"系统调用失败");

    private Integer code;

    private String msg;

    ResultEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

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
}
