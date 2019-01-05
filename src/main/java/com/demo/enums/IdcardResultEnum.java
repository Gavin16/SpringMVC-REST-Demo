package com.demo.enums;

/**
 * @Auther: Minsky
 * @Date: 2019/1/5 15:22
 * @Description:
 */
public enum IdcardResultEnum {

    SUCCESS(100100,"调用成功"),
    FAIL(100101,"调用失败"),
    ERROR_IDCARD(100102,"无效的身份证号码"),
    ERROR_BIRTHDAY(100103,"无效的出生日期"),
    ERROR_AREACODE(100104,"无效的地区编号"),
    EMPTY_IDCARD(100105,"Idcard为空")
    ;

    private Integer code;
    private String msg;

    IdcardResultEnum(Integer code,String msg){
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
