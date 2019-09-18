package com.klj.springtest.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

/**
 * Created by 0 on 2018/9/13.
 */
@Data
public class User {
    private Integer id;

    private String userName;

    private Integer age;

    private Date ctm;

    private Integer androidCount;

    private Integer iosCount;

    private JSONObject description;

    /*public User(Integer id, Integer androidCount, Integer iosCount) {
        this.id = id;
        this.androidCount = androidCount;
        this.iosCount = iosCount;
    }*/

    @Data
    public static class Desc{
        private Integer age;
        private String name;
        private String address;
    }
}
