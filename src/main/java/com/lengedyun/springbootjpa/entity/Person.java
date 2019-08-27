package com.lengedyun.springbootjpa.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * 没有这两个注解的可以添加lombok依赖
 * 或者自己生成get,set，以及toString方法
 */
@Data
@ToString
public class Person {

    //简单参数类型
    private String pName;

    private Integer pAge;

    //对象类型
    private Son directSon;

    //简单类型列表嵌套
    private List<String> hobby;

    //对象类型列表嵌套
    private List<Son> sons;

    //map属性
    private Map<String,Object> friends;

}
