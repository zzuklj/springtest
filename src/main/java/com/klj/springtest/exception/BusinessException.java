package com.klj.springtest.exception;

/**
 * @author lvxi
 * Create Time: 2018/7/31 9:53
 */
public class BusinessException extends RuntimeException {

    /**
     * 错误编码
     */
    private Integer code;



    public BusinessException(ExceptionEnum e){
        super(e.getMessage());
        this.code = e.getCode();
    }

    public BusinessException(Integer code , String message){
        super(message);
        this.code=code;
    }

    public BusinessException(ExceptionEnum e, Throwable te){
        super(e.getMessage(),te);
        this.code = e.getCode();
    }


    public BusinessException(Integer code , String message, Throwable e){
        super(message,e);
        this.code=code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
