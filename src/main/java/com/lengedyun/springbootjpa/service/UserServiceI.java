package com.lengedyun.springbootjpa.service;

import com.lengedyun.springbootjpa.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserServiceI {

    public void add(UserEntity userEntity);

    public void update(UserEntity userEntity);

    public void delete(UserEntity userEntity);

    public List<UserEntity> getAll(UserEntity userEntity);

    public Optional<UserEntity> getUserById(String id);

    public UserEntity findByUserName(String userName);

    public UserEntity findByAge(Integer age);
}
