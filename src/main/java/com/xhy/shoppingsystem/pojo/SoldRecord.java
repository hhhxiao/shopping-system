package com.xhy.shoppingsystem.pojo;

import org.apache.ibatis.type.Alias;


import java.sql.Timestamp;


@Alias("soldRecord")
public class SoldRecord {
    private Integer soldId;
    private Integer itemId;
    private String userEmail;
    private Timestamp soldTime;
    private Integer soldNum;


    public Integer getSoldId() {
        return soldId;
    }

    public void setSoldId(Integer soldId) {
        this.soldId = soldId;
    }

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

    public Timestamp getSoldTime() {
        return soldTime;
    }

    public void setSoldTime(Timestamp soldTime) {
        this.soldTime = soldTime;
    }

    public Integer getSoldNum() {
        return soldNum;
    }

    public void setSoldNum(Integer soldNum) {
        this.soldNum = soldNum;
    }

    @Override
    public String toString() {
        return "SoldRecord{" +
                "soldId=" + soldId +
                ", itemId=" + itemId +
                ", userEmail='" + userEmail + '\'' +
                ", soldTime=" + soldTime +
                ", soldNum=" + soldNum +
                '}';
    }
}
