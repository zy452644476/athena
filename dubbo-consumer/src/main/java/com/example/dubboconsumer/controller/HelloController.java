package com.example.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.athena.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yaser.zhang on 2019/8/18.
 */
@RestController
public class HelloController {

    @Reference
    public HelloService helloService;

    @GetMapping(path = "/hello")
    public String hello(String name){
        return helloService.hello(name);
    }

}
