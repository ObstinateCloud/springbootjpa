package com.lengedyun.springbootjpa.entity;

import lombok.Data;
import lombok.ToString;

/**
 * 没有这两个注解的可以添加lombok依赖
 * 或者自己生成get,set，以及toString方法
 */

@Data
@ToString
public class Son {

    //简单参数类型
    private String sName;

    private Integer sAge;
}
