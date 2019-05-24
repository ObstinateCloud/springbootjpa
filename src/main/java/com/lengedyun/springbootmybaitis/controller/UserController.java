package com.lengedyun.springbootmybaitis.controller;

import com.lengedyun.springbootmybaitis.entity.UserEntity;
import com.lengedyun.springbootmybaitis.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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

    @GetMapping("/delete")
    public void delete(UserEntity userEntity){
        System.out.println(userEntity.toString());
        userServiceI.delete(userEntity);
    }

    @GetMapping("/getAll")
    public List<UserEntity> getAll(){

        return userServiceI.getAll();
    }

}
