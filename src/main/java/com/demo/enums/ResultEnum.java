package com.demo.enums;

/**
 * @Title: ${FILE_NAME}
 * @Package: com.demo.enums
 * @Description:
 * @author: Minsky
 * @date: 2018/5/19 16:02
 */
public enum ResultEnum {
    SUCCESS(200,"调用成功"),
    FAIL(201,"调用失败"),
    ERROR_IDCARD(202,"无效的身份证号码"),
    ERROR_BIRTHDAY(203,"无效的出生日期"),
    ERROR_AREACODE(204,"无效的地区编号"),
    EMPTY_IDCARD(205,"Idcard为空")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
