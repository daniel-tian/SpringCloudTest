package com.example.service_ribbon_2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service_ribbon_2.service.HelloService;


@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;
    
    @RequestMapping(value = "/ahh")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }
    
    @RequestMapping(value = "/test")
    public String test(@RequestParam String name){
        return helloService.testService(name);
    }
    
    @RequestMapping(value = "/**")
    public String test2(@RequestParam String name){
        return helloService.allService(name);
    }
}
