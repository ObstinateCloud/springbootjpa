package com.lengedyun.springbootmybaitis.service.impl;

import com.lengedyun.springbootmybaitis.dao.UserRepo;
import com.lengedyun.springbootmybaitis.entity.UserEntity;
import com.lengedyun.springbootmybaitis.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceI {

   @Autowired
   private UserRepo userRepo;


    @Override
    public void add(UserEntity userEntity) {
        userRepo.save(userEntity);
    }

    @Override
    public void update(UserEntity userEntity) {
        userRepo.save(userEntity);
    }

    @Override
    public void delete(UserEntity userEntity) {
        userRepo.delete(userEntity);
    }

    @Override
    public List<UserEntity> getAll() {
        return (List<UserEntity>) userRepo.findAll();
    }
}
