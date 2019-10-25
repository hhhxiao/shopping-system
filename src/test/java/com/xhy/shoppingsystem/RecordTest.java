package com.xhy.shoppingsystem;

import com.xhy.shoppingsystem.mapper.RecordMapper;
import com.xhy.shoppingsystem.pojo.SoldRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RecordTest {
    @Autowired
    private RecordMapper recordMapper;

    @Test
    public void getAllPersonalSoldRecord(){
        ArrayList<SoldRecord> allSoldRecord = recordMapper.getAllPersonalSoldRecord("hg@123");
        for (SoldRecord soldRecord : allSoldRecord) {
            System.out.println(soldRecord);
        }
    }

    @Test
    public void getAllSoldRecord(){
        ArrayList<SoldRecord> allSoldRecord = recordMapper.getAllSoldRecord();
        for (SoldRecord soldRecord : allSoldRecord) {
            System.out.println(soldRecord);
        }
    }

    @Test
    public void addSoldRecord(){
        SoldRecord soldRecord=new SoldRecord();
        soldRecord.setItemId(1);
        soldRecord.setSoldNum(2);
        soldRecord.setSoldTime(new Date());
        soldRecord.setUserEmail("xhy@789");
        recordMapper.addSoldRecord(soldRecord);
    }
}
