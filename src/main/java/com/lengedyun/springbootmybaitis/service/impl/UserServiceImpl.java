package com.lengedyun.springbootmybaitis.service.impl;

import com.lengedyun.springbootmybaitis.dao.UserRepo;
import com.lengedyun.springbootmybaitis.entity.UserEntity;
import com.lengedyun.springbootmybaitis.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

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
    public List<UserEntity> getAll(UserEntity userEntity) {
        if(userEntity!=null){
            ExampleMatcher matcher = ExampleMatcher.matching();
            if(!StringUtils.isEmpty(userEntity.getUserName())){
                matcher.withMatcher("userName",ExampleMatcher.GenericPropertyMatchers.startsWith());
            }
            if(!StringUtils.isEmpty(userEntity.getAge())){
                matcher.withMatcher("age",ExampleMatcher.GenericPropertyMatchers.contains());
            }

            Example<UserEntity> example = Example.of(userEntity,matcher);
            return userRepo.findAll(example);
        }
        return userRepo.findAll();
    }

    @Override
    public Optional<UserEntity> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public UserEntity findByUserName(String userName) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("userName", ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<UserEntity> entityExample = Example.of(userEntity,matcher);
        return userRepo.findOne(entityExample).get();
    }

    @Override
    public UserEntity findByAge(Integer age) {
        return userRepo.findByAge(age);
    }


}
