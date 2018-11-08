package com.maolin.bootlink.enums;

/**
 * Created by shaomaolin on 2018/11/8.
 */
public enum ErrorCodeEnum {

    PARAM_BLANK("0", "参数为空！"),
    QUERY_FAIL("1", "查询失败！");

    private ErrorCodeEnum (String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;
    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
