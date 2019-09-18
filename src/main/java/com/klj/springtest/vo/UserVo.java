package com.klj.springtest.vo;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.Serializable;

/**
 * @author klj
 * @Title: UserVo
 * @Description: TODO
 * @date 2018/7/2610:54
 */
public class UserVo implements Serializable {
    private int index;
    private String name;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
