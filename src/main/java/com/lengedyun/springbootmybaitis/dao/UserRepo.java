package com.lengedyun.springbootmybaitis.dao;

import com.lengedyun.springbootmybaitis.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepo extends CrudRepository<UserEntity,String>,
        PagingAndSortingRepository<UserEntity,String>,
        JpaSpecificationExecutor<UserEntity>,
        JpaRepository<UserEntity,String> {

    UserEntity findByAge(Integer age);

}
