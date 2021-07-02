package com.unbeaten.wiki.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 测试 前端控制器
 * </p>
 *
 * @author unbeaten
 * @since 2021-06-25
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    RedisTemplate redisTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/redis/set/{key}/{value}")
    public String set(@PathVariable String key,@PathVariable String value) {
        redisTemplate.opsForValue().set(key, value, 3600, TimeUnit.SECONDS);
        LOG.info("key: {}, value: {}", key, value);
        return "success";
    }

    @RequestMapping("/redis/get/{key}")
    public Object get(@PathVariable String key) {
        Object object = redisTemplate.opsForValue().get(key);
        LOG.info("key: {}, value: {}", key, object);
        return object;
    }
}

