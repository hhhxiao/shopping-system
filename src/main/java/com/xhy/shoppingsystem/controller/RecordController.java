package com.xhy.shoppingsystem.controller;


import com.sun.java.swing.plaf.motif.MotifEditorPaneUI;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.prism.impl.Disposer;
import com.xhy.shoppingsystem.pojo.SoldRecord;
import com.xhy.shoppingsystem.pojo.User;
import com.xhy.shoppingsystem.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class RecordController {

    // @Autowired
    //  private RecordService recordService;
    Logger logger = LoggerFactory.getLogger(RecordController.class);
    @Autowired
    private RecordService recordService;


    @ResponseBody
    @GetMapping(value = "/get-record", produces = MediaType.APPLICATION_JSON_VALUE)
    ArrayList<SoldRecord> getRecordByEmail(HttpSession session) {
        User user = (User) session.getAttribute("user");
        System.out.println("/get=record:---" + user);
        if (user == null) return null;
        else if (user.getUserType() == 0) {
            ArrayList<SoldRecord> records = recordService.getAllSoldRecord();
            System.out.println(records);
            return recordService.getAllSoldRecord();
        } else {
            return recordService.getAllPersonalSoldRecord(user.getUserEmail());
        }
    }
}
