package com.lengedyun.springbootmybaitis.controller;

import com.dangdang.ddframe.rdb.sharding.keygen.KeyGenerator;
import com.lengedyun.springbootmybaitis.dao.GoodsRepo;
import com.lengedyun.springbootmybaitis.entity.GoodsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjy
 * @title: GoodsController
 * @projectName springbootmybatis
 * @description: 商品分库分表测试
 * @date 2019/7/1 16:43
 */
@RestController
@RequestMapping("goodsController")
public class GoodsController {

    @Autowired
    private KeyGenerator keyGenerator;

    @Autowired
    private GoodsRepo goodsRepo;

    @GetMapping("save")
    public String save(){
        for (int i = 0; i <=40; i++) {
            GoodsEntity goodsEntity = new GoodsEntity();
            goodsEntity.setGoodsId(i);
            goodsEntity.setGoodsName("商品"+i);
            goodsEntity.setGoodsType(i+1);
            goodsRepo.save(goodsEntity);
        }
        return "success";
    }

    @GetMapping("select")
    public String select(){
        return goodsRepo.findAll().toString();
    }

    @GetMapping("delete")
    public void delete(){
        goodsRepo.deleteAll();
    }

    @GetMapping("query1")
    public Object query1(){
        return goodsRepo.findAllByGoodsIdBetween(10, 30);
    }

    @GetMapping("query2")
    public Object query2(){
        List<Integer> goodsIds = new ArrayList<>();
        goodsIds.add(10);
        goodsIds.add(15);
        goodsIds.add(20);
        goodsIds.add(25);
        return goodsRepo.findAllByGoodsIdIn(goodsIds);
    }
}
