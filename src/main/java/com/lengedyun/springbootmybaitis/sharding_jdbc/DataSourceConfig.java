package com.lengedyun.springbootmybaitis.sharding_jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

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

}
