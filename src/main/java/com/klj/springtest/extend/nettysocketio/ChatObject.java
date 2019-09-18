package com.klj.springtest.extend.nettysocketio;

/**
 * @author klj
 * @Title: ChatObject
 * @Description: TODO
 * @date 2018/8/2016:23
 */
public class ChatObject {
    private String userName;
    private String message;

    public ChatObject(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
