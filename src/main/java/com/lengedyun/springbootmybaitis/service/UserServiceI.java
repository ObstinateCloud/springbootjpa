package com.lengedyun.springbootmybaitis.service;

import com.lengedyun.springbootmybaitis.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServiceI {

    public void add(UserEntity userEntity);

    public void update(UserEntity userEntity);

    public void delete(UserEntity userEntity);

    public List<UserEntity> getAll();
}
