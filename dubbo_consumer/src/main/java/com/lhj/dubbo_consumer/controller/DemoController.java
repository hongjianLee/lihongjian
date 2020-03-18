package com.lhj.dubbo_consumer.controller;

import com.lhj.service.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Reference(version = "${dubbo.consumer.version}")
    private DemoService demoService;

    @GetMapping("/demo/{name}")
    public void word(@PathVariable String name) {
        demoService.sayHello(name);
    }
}
