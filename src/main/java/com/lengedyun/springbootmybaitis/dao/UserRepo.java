package com.lengedyun.springbootmybaitis.dao;

import com.lengedyun.springbootmybaitis.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity,Integer>{

}
