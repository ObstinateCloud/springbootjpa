package com.lengedyun.springbootmybaitis.controller;

import com.lengedyun.springbootmybaitis.entity.UserEntity;
import com.lengedyun.springbootmybaitis.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("userController")
public class UserController {

    @Autowired
    private UserServiceI userServiceI;

    @GetMapping("/add")
    public void add(UserEntity userEntity){
        System.out.println("add");
        userServiceI.add(userEntity);

    }

    @GetMapping("/update")
    public void update(UserEntity userEntity){
        System.out.println(userEntity.toString());
        userServiceI.update(userEntity);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println(id);
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userServiceI.delete(userEntity);
        return "redirect:/userController/getAll/";
    }

    @RequestMapping("/getAll")
    public String getAll(ModelMap map){
        map.addAttribute("userList",  userServiceI.getAll());
        return "userList";
    }

}
