package com.lengedyun.springbootmybaitis.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author zjy
 * @title: GoodsEntity
 * @projectName springbootmybatis
 * @description: TODO
 * @date 2019/7/1 16:53
 */
@Data
@Entity(name="goods")
public class GoodsEntity {

    @Id
    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_type")
    private Integer goodsType;
}
