package com.lhj.dubbo_provider.serviceImpl;

import com.lhj.service.DemoService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "${dubbo.provider.version}", timeout = 10000)
public class DemoServiceImpl implements DemoService {

    @Override
    public void sayHello(String word) {
        System.out.println("hello " + word);
    }
}
