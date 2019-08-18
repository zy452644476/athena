package com.example.dubboprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.athena.HelloService;

/**
 * Created by yaser.zhang on 2019/8/18.
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String str) {
        return "Hello " + str;
    }
}
