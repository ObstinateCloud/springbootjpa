package com.lengedyun.springbootjpa.controller;

import com.alibaba.fastjson.JSONObject;
import com.lengedyun.springbootjpa.entity.UserEntity;
import com.lengedyun.springbootjpa.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("userController")
public class UserController {

    @Autowired
    private UserServiceI userServiceI;

    @GetMapping("/goAddUser")
    public String goAddUser(ModelMap modelMap) {
        modelMap.addAttribute("user", new UserEntity());
        modelMap.addAttribute("action", "doAddUser");
        return "userForm";
    }

    @PostMapping("/doAddUser")
    public String doAddUser(@ModelAttribute UserEntity userEntity) {
        System.out.println(userEntity.toString());
        userServiceI.add(userEntity);
        return "redirect:/userController/getAll/";
    }

    @GetMapping("/goUpdateUser/{id}")
    public String goUpdateUser(@PathVariable String id , ModelMap modelMap) {
        modelMap.addAttribute("action","doUpdateUser");
        Optional<UserEntity> userEntities = userServiceI.getUserById(id);
        modelMap.addAttribute("user",userEntities.get());
        return "userForm";
    }

    @PostMapping("/doUpdateUser")
    public String doUpdateUser(UserEntity userEntity) {
        System.out.println(userEntity.toString());
        userServiceI.update(userEntity);
        return "redirect:/userController/getAll";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        System.out.println(id);
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userServiceI.delete(userEntity);
        return "redirect:/userController/getAll/";
    }

    @RequestMapping("/getAll")
    public String getAll(ModelMap map) {
        List<UserEntity> userEntities = userServiceI.getAll(null);
        System.out.println(userEntities);
        map.addAttribute("userList", userEntities);
        return "userList";
    }

    @RequestMapping("/getAllQuery")
    @ResponseBody
    public List<UserEntity> getAllQuery(ModelMap map,@ModelAttribute UserEntity userEntity) {
        List<UserEntity> userEntities = userServiceI.getAll(userEntity);
//        System.out.println(userEntities);
//        map.addAttribute("userList", userEntities);
        String jsonObject = JSONObject.toJSONStringWithDateFormat(userEntities,"yyyy-MM-dd HH:mm:ss");
        return userEntities;
    }

}
