package com.xhy.shoppingsystem.mapper;


import com.xhy.shoppingsystem.pojo.Item;
import com.xhy.shoppingsystem.pojo.SoldRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface RecordMapper {
    ArrayList<SoldRecord> getAllPersonalSoldRecord(String email);//用户个人获取所有交易
    ArrayList<SoldRecord> getAllSoldRecord();//管理员获取所有交易记录
    void addSoldRecord(SoldRecord soldRecord);//购买商品，增加商品记录
}
