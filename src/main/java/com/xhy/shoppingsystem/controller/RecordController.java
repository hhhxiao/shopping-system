package com.xhy.shoppingsystem.controller;


import com.xhy.shoppingsystem.pojo.SoldRecord;
import com.xhy.shoppingsystem.pojo.User;
import com.xhy.shoppingsystem.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class RecordController {

    @Autowired
    private RecordService recordService;
    Logger logger = LoggerFactory.getLogger(RecordController.class);

    /**
     * 查询交易记录（登录条件下）
     * @param request 请求
     */
    @GetMapping("/record")
    public String record(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        ArrayList<SoldRecord> allSoldRecord = recordService.getAllSoldRecord(user.getUserEmail());
        session.setAttribute("allSoldRecord",allSoldRecord);
        return "redirect:/item";
    }
}
