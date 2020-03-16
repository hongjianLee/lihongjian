package com.lhj.dubbo_provider.controller;

import com.lhj.dubbo_provider.redis.JedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private JedisTemplate jedisTemplate;

    @GetMapping("redis")
    public String getRedis() {
        jedisTemplate.set("name", "lihongjian");

        return jedisTemplate.get("name", String.class);
    }
}
