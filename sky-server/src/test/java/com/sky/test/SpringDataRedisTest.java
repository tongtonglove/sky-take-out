package com.sky.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//@SpringBootTest
public class SpringDataRedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedisTemplate(){
        System.out.println(redisTemplate);
        ValueOperations valueOperations=redisTemplate.opsForValue();
        HashOperations hashOperations = redisTemplate.opsForHash();
        ListOperations listOperations = redisTemplate.opsForList();
        SetOperations setOperations = redisTemplate.opsForSet();
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
    }

    /**
     * 操作字符串类型的数据
     */
    @Test
    public void testString(){
        redisTemplate.opsForValue().set("city","北京");
        String city = (String) redisTemplate.opsForValue().get("city");
        System.out.println(city);
        //setex
        redisTemplate.opsForValue().set("code","1234",3, TimeUnit.MINUTES);//3分钟
        //setnx
        redisTemplate.opsForValue().setIfAbsent("lock",1);//成功
        redisTemplate.opsForValue().setIfAbsent("lock",2);//不成功
    }

    /**
     * 哈希
     */
    @Test
    public void testHash(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        //hset
        hashOperations.put("100","name","tom");
        hashOperations.put("100","age","20");

        //hget
        String name = (String) hashOperations.get("100", "name");
        System.out.println(name);

        //hkeys
        Set keys = hashOperations.keys("100");
        System.out.println(keys);

        //hvals
        List values = hashOperations.values("100");
        System.out.println(values);

        //hdel
        hashOperations.delete("100","age");
    }
}
