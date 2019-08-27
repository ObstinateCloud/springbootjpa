package com.lengedyun.springbootjpa.sharding_jdbc;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;
import com.google.common.collect.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * @author zjy
 * @title: DatabaseShardingAlgorithm
 * @projectName springbootmybatis
 * @description: 分库算法 单分片键数据源分片算法
 * goods_id<=20 database0
 * goods_id>20 database1
 * @date 2019/7/2 9:13
 */
@Component
public class DatabaseShardingAlgorithm implements SingleKeyDatabaseShardingAlgorithm<Integer> {

    @Autowired
    private Database0Config database0Config;

    @Autowired
    private Database1Config database1Config;

    @Override
    public String doEqualSharding(Collection<String> collection, ShardingValue<Integer> shardingValue) {
        Integer value = shardingValue.getValue();
        if (value <= 20) {
            return database0Config.getDatabaseName();
        } else {
            return database1Config.getDatabaseName();
        }
    }

    @Override
    public Collection<String> doInSharding(Collection<String> collection, ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(collection.size());
        for (Integer value : shardingValue.getValues()) {
            if(value<= 20){
                result.add(database0Config.getDatabaseName());
            }else{
                result.add(database1Config.getDatabaseName());
            }
        }
        return result;
    }

    @Override
    public Collection<String> doBetweenSharding(Collection<String> collection, ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(collection.size());
        Range<Integer> valueRange = shardingValue.getValueRange();
        for (int i = valueRange.lowerEndpoint(); i <= valueRange.upperEndpoint(); i++) {
            if(i <= 20){
                result.add(database0Config.getDatabaseName());
            }else{
                result.add(database1Config.getDatabaseName());
            }
        }
        return result;
    }
}
