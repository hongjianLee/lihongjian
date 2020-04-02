package com.lhj.rocketmqc;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableDubbo
@SpringBootApplication
public class RocketmqcApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketmqcApplication.class, args);
    }

}
