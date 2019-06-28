package com.lengedyun.springbootmybaitis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT 解决测试类中无法启动websocket的问题 在测试中真实启tomcat
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringbootmybaitisApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void contextLoads() {

        redisTemplate.opsForValue().set("name","zhangjy");
        Object object = redisTemplate.opsForValue().get("name");
        System.out.println(object);
    }

}
