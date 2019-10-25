package com.xhy.shoppingsystem.service;


import com.xhy.shoppingsystem.mapper.RecordMapper;
import com.xhy.shoppingsystem.pojo.Item;
import com.xhy.shoppingsystem.pojo.SoldRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Service("RecordService")
public class RecordServiceImpl implements RecordService{

    Logger logger = LoggerFactory.getLogger(RecordServiceImpl.class);
    @Autowired
    private RecordMapper recordMapper;

    @Override
    public ArrayList<SoldRecord> getAllPersonalSoldRecord(String email) {
        return recordMapper.getAllPersonalSoldRecord(email);
    }

    @Override
    public ArrayList<SoldRecord> getAllSoldRecord() {
        return recordMapper.getAllSoldRecord();
    }

    @Override
    public void addSoldRecord(SoldRecord soldRecord) {
        recordMapper.addSoldRecord(soldRecord);
    }


}
