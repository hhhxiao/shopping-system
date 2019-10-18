package com.xhy.shoppingsystem.pojo;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Date;

public class SoldRecord {
    private Integer itemId;
    private Integer userID;
    private Date soldTime;
    private Integer soldNum;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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
