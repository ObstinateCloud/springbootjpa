package com.lengedyun.springbootmybaitis.dao;

import com.lengedyun.springbootmybaitis.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * @author zjy
 * @title: GoodsRepo
 * @projectName springbootmybatis
 * @description: TODO
 * @date 2019/7/1 16:58
 */
public interface GoodsRepo extends JpaRepository<GoodsEntity, Integer> {

    List<GoodsEntity> findAllByGoodsIdBetween(Integer goodsId1,Integer goodsId2);

    List<GoodsEntity> findAllByGoodsIdIn(List<Integer> goodsIds);
}
