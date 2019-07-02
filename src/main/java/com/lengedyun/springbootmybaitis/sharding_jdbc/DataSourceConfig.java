package com.lengedyun.springbootmybaitis.sharding_jdbc;

import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.keygen.DefaultKeyGenerator;
import com.dangdang.ddframe.rdb.sharding.keygen.KeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zjy
 * @title: DataSourceConfig
 * @projectName springbootmybatis
 * @description: 配置策略
 * @date 2019/7/1 17:07
 */
@Configuration
public class DataSourceConfig {

    @Autowired
    private Database0Config database0Config;

    @Autowired
    private Database1Config database1Config;

    @Autowired
    private DatabaseShardingAlgorithm databaseShardingAlgorithm;

    @Autowired
    private TableShardingAlgorithm tableShardingAlgorithm;

    @Bean
    public DataSource getDataSource()throws Exception{

        return buildDataSource();
    }

    private DataSource buildDataSource() throws SQLException{
        //分库设置
        Map<String,DataSource> dataSourceMap = new HashMap<>();
        //添加分库信息
        dataSourceMap.put(database0Config.getDatabaseName(),database0Config.createDataSource());
        dataSourceMap.put(database1Config.getDatabaseName(),database1Config.createDataSource());
        //设置默认数据库
        DataSourceRule dataSourceRule = new DataSourceRule(dataSourceMap,database0Config.getDatabaseName());
        //分表设置
        TableRule goodsTableRule = TableRule.builder("goods")
                .actualTables(Arrays.asList("goods0","goods1"))
                .dataSourceRule(dataSourceRule)
                .build();
        //分库分表策略
        ShardingRule shardingRule = ShardingRule.builder()
                .dataSourceRule(dataSourceRule)
                .tableRules(Arrays.asList(goodsTableRule))
                .databaseShardingStrategy(new DatabaseShardingStrategy("goods_id", databaseShardingAlgorithm))
                .tableShardingStrategy(new TableShardingStrategy("goods_type", tableShardingAlgorithm))
                .build();
        DataSource dataSource = ShardingDataSourceFactory.createDataSource(shardingRule);
        return dataSource;
    }

    @Bean
    public KeyGenerator keyGenerator(){
        return new DefaultKeyGenerator();
    }
}
