package com.klj.springtest.exception;

/**
 * @author lvxi
 * Create Time: 2018/7/31 10:37
 */
public enum ExceptionEnum {

    UNKONW_ERROR(-1,"未知错误"),
    UNLOGIN_ERROR(0,"未登录"),
    PARAMS_ERROR(3,"参数错误"),
    OPERATE_ERROR(1,"操作错误"),
    PERMISSION_ERROR(2,"没有权限操作"),
    SYSTEM_ERROR(99,"系统繁忙"),
    ;

    private Integer code;
    private String message;

    ExceptionEnum(Integer code , String message){
        this.code=code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
