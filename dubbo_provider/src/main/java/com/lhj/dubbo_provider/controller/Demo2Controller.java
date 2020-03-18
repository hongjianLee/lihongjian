package com.lhj.dubbo_provider.controller;

import com.lhj.dubbo_api2.service.Demo2Service;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo2Controller {

    @Reference(version = "${dubbo.consumer.version}", timeout = 10000)
    private Demo2Service demo2Service;


    @GetMapping("demo2/{name}")
    public String getName(@PathVariable String name) {
        return demo2Service.getName(name);
    }
}
