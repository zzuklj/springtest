package com.klj.springtest.vo;

import org.apache.http.util.EntityUtils;

/**
 * @author klj
 * @Title: HttpResult
 * @Description: TODO
 * @date 2018/8/610:56
 */
public class HttpResult {
    // 响应的状态码
    private int code;

    // 响应的响应体
    private String body;

    public HttpResult(int code, String body) {
        this.code = code;
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
