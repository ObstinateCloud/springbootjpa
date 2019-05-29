package com.lengedyun.springbootmybaitis.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "t_user")
@Data
@ToString
public class UserEntity extends BaseEntity{


    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private int age;

    @Column
    private Date birth;

}
