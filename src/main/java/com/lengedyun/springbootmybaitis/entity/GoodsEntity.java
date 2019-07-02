package com.lengedyun.springbootmybaitis.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zjy
 * @title: GoodsEntity
 * @projectName springbootmybatis
 * @description: TODO
 * @date 2019/7/1 16:53
 */
@Data
@Entity
@Table(name = "goods")
public class GoodsEntity {

    @Id
    private Integer goodsId;

    private String goodsName;

    private Integer goodsType;
}
