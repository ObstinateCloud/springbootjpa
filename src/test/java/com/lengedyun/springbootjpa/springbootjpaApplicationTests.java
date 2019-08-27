package com.lengedyun.springbootjpa;

import com.lengedyun.springbootjpa.service.LogRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT 解决测试类中无法启动websocket的问题 在测试中真实启tomcat
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class springbootjpaApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private LogRecordService logRecordService;

    @Test
    public void contextLoads() {

        redisTemplate.opsForValue().set("name","zhangjy");
        Object object = redisTemplate.opsForValue().get("name");
        System.out.println(object);
    }

    @Test
    public void aopTest() {
        logRecordService.recordLog("zjy",23);
    }

}
