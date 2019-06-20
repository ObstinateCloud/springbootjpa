package com.lengedyun.springbootmybaitis.controller;

import com.lengedyun.springbootmybaitis.annotation.LoginCheck;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aspectController")
public class AspectController {

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


}
