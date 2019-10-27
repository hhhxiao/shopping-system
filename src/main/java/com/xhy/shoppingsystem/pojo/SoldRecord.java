package com.xhy.shoppingsystem.pojo;

import org.apache.ibatis.type.Alias;


import java.sql.Timestamp;


@Alias("soldRecord")
public class SoldRecord {
    private int soldId;
    private Integer itemId;
    private String userEmail;
    private Timestamp soldTime;
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
                "itemId=" + itemId +
                ", userEmail='" + userEmail + '\'' +
                ", soldTime=" + soldTime +
                ", soldNum=" + soldNum +
                '}';
    }
}
