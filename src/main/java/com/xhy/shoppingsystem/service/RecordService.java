package com.xhy.shoppingsystem.service;

import com.xhy.shoppingsystem.pojo.SoldRecord;

import java.util.ArrayList;

public interface RecordService {
    ArrayList<SoldRecord> getAllSoldRecord(String email);//获取所有交易
}
