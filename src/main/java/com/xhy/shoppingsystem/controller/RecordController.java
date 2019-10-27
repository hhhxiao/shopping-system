package com.xhy.shoppingsystem.controller;


import com.xhy.shoppingsystem.pojo.SoldRecord;
import com.xhy.shoppingsystem.pojo.User;
import com.xhy.shoppingsystem.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class RecordController {

   // @Autowired
  //  private RecordService recordService;
    Logger logger = LoggerFactory.getLogger(RecordController.class);
}
