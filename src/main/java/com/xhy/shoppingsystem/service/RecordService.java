package com.xhy.shoppingsystem.service;

import com.xhy.shoppingsystem.pojo.Item;
import com.xhy.shoppingsystem.pojo.SoldRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


public interface RecordService {
    ArrayList<SoldRecord> getAllPersonalSoldRecord(String email);//获取所有交易
    ArrayList<SoldRecord> getAllSoldRecord();//管理员获取所有交易记录
    void addSoldRecord(SoldRecord soldRecord);//购买商品，增加商品记录
}
