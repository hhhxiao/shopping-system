package com.xhy.shoppingsystem.pojo;

import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("soldRecord")
public class SoldRecord {
    private Integer itemId;
    private String userEmail;
    private Date soldTime;
    private Integer soldNum;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getSoldTime() {
        return soldTime;
    }

    public void setSoldTime(Date soldTime) {
        this.soldTime = soldTime;
    }

    public Integer getSoldNum() {
        return soldNum;
    }

    public void setSoldNum(Integer soldNum) {
        this.soldNum = soldNum;
    }
}