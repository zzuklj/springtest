package com.klj.springtest.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @description: 问答社区用户
 * @author: liushui
 * @create: 2018-05-29 10:58
 **/
public class CommunityUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String userId;  //用户id
    private String userName;  //用户名称
    private String unitId;    //用户组织id
    private String unitName;   //用户组织名称
    private String mobilePhone;   //用户电话号码

    private double random;    //随机数，用于推荐
    private int userType;     //用户类型，0-正常用户 1-后台测试用户
    private int sex;   //性别
    private String imgPath;  //头像
    private int answerCount;  //回答数
    private String field;    //用户所属领域
    private int questionCount;//问题数
    private int answerCommentCount; //回答评论数

    private String pUnitName;   //上级组织名称

    private int isDelete;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public double getRandom() {
        return random;
    }

    public void setRandom(double random) {
        this.random = random;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    public int getAnswerCommentCount() {
        return answerCommentCount;
    }

    public void setAnswerCommentCount(int answerCommentCount) {
        this.answerCommentCount = answerCommentCount;
    }

    public String getpUnitName() {
        return pUnitName;
    }

    public void setpUnitName(String pUnitName) {
        this.pUnitName = pUnitName;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
