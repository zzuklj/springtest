package com.klj.springtest.enums;

/**
 * @author klj
 * @Title: ActStatus
 * @Description: TODO
 * @date 2018/10/3115:28
 */
public enum ActStatus {
    /**
     * 待审批
     */
    PENDING_APPROVE("1", "待审批"),
    /**
     * 审批中
     */
    APPROVING("2","审批中");


    private String engValue;

    private String chnValue;

    ActStatus(String engValue, String chnValue) {
        this.engValue = engValue;
        this.chnValue = chnValue;
    }

    public String getEngValue() {
        return engValue;
    }
    public String getChnValue() {
        return chnValue;
    }

    public static ActStatus getByEngValue(String engValue){
        for(ActStatus actStatus : values()){
            if(actStatus.getEngValue().equals(engValue)){
                return actStatus;
            }
        }
        return null;
    }

    public static String getChnByEngValue(String engValue){
        ActStatus byEngValue = getByEngValue(engValue);
        return byEngValue.getChnValue();
    }
}
