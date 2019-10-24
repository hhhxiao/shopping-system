package com.xhy.shoppingsystem.mapper;


import com.xhy.shoppingsystem.pojo.SoldRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface RecordMapper {
    ArrayList<SoldRecord> getAllSoldRecord(String email);//获取所有交易
}
