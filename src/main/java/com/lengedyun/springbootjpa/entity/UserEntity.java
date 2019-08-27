package com.lengedyun.springbootjpa.entity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "t_user")
@Data
@ToString
public class UserEntity extends com.lengedyun.springbootjpa.entity.BaseEntity {


    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private int age;

    @Column
    private Date birth;

}
