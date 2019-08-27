package com.lengedyun.springbootjpa.controller;

import com.lengedyun.springbootjpa.annotation.LogRecord;
import com.lengedyun.springbootjpa.annotation.LoginCheck;
import com.lengedyun.springbootjpa.service.LogRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aspectController")
public class AspectController {

    @Autowired
    private LogRecordService logRecordService;

    @RequestMapping("/login1")
    @LoginCheck
    public String login1(String username) {
        return "success";
    }

    @RequestMapping("/login2")
    public String login2(String username,String password) {
        return "success";
    }

    @RequestMapping("/login3")
    public String login3(Integer money) {
        return "success";
    }

    /**
     * 普通方法加注解
     * @param username
     * @param age
     * @return
     */
    @RequestMapping("/commonMethod")
    @LogRecord(tableName = "t_user")
    public String commonMethod(String username,Integer age) {
        System.out.println("------running method------");
        return "commonMethod";
    }

    /**
     * 重写方法加注解
     * @param username
     * @param age
     * @return
     */
    @RequestMapping("/overrideMethod")
    public String overrideMethod(String username,Integer age) {

        return logRecordService.recordLog(username,age);
    }




}
