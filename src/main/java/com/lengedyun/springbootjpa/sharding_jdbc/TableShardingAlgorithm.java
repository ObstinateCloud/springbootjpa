package com.lengedyun.springbootjpa.sharding_jdbc;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
import com.google.common.collect.Range;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * @author zjy
 * @title: TableShardingAlgorithm
 * @projectName springbootmybatis
 * @description: 分表策略 单键分片策略
 * GoodsType为奇数使用goods_1表
 * GoodsType为偶数使用goods_0表
 * @date 2019/7/2 9:25
 */
@Component
public class TableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<Integer> {

    @Override
    public String doEqualSharding(Collection<String> tableNames, ShardingValue<Integer> shardingValue) {
        for (String tableName : tableNames) {
            System.out.println(tableName);
            System.out.println(shardingValue.getValue());
            if(tableName.endsWith(shardingValue.getValue() % 2 +"")){
                return tableName;
            }
        }
        return null;
    }

    @Override
    public Collection<String> doInSharding(Collection<String> collection, ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(collection.size());
        for (Integer value : shardingValue.getValues()) {
            for (String tableName:collection) {
               if(tableName.endsWith(value % 2 +"")){
                   result.add(tableName);
               }
            }
        }
        return result;
    }

    @Override
    public Collection<String> doBetweenSharding(Collection<String> collection, ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(collection.size());
        Range<Integer> valueRange = shardingValue.getValueRange();
        for (int i = valueRange.lowerEndpoint(); i <= valueRange.upperEndpoint(); i++) {
            for (String tableName : collection) {
                if(tableName.endsWith(i % 2 + "")){
                    result.add(tableName);
                }
            }
        }
        return result;
    }
}
