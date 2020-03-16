package com.lhj.dubbo_consumer.Controller;

import com.lhj.service.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class DemoController {

    @Reference(version = "${dubbo.consumer.version}")
    private DemoService demoService;

    @Value("${demo.version}")
    private String demoVersion;


    @GetMapping("index/{name}")
    public void sayHello(@PathVariable String name) {
        System.out.println(demoVersion);
        demoService.sayHello(name);
    }
}
