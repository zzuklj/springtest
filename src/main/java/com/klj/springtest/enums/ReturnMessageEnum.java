package com.klj.springtest.enums;

public enum ReturnMessageEnum {

    PPUKEY_ERROR(1 , "ppukey参数错误"),
    NO_LOGIN_RECORD(2 , "无登录记录"),
    LOGIN_EXPIRE(3 , "登录过期");

    public static String getMessageByIndex(int index){
        String result = "";
        for(ReturnMessageEnum rme:ReturnMessageEnum.values()){
            if (rme.getIndex() == index){
                result = rme.getMessage();
            }
        }
        return result;
    }


    private int index;
    private String message;

    private ReturnMessageEnum(int index, String message) {
        this.index = index;
        this.message = message;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
