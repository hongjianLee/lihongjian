package com.lhj.dubbo_consumer.serviceImpl;

import com.lhj.dubbo_api2.service.Demo2Service;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "${dubbo.provider.version}", timeout = 100000)
public class Demo2ServiceImpl implements Demo2Service {

    @Override
    public String getName(String name) {
        return name;
    }
}
