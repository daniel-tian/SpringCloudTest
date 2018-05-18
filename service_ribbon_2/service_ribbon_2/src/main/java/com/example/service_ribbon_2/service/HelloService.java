package com.example.service_ribbon_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;
    
    @HystrixCommand(fallbackMethod = "ahError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-AHH/ahh?name="+name,String.class);
    }
    
    public String ahError(String name) {
        return "hi,"+name+",sorry,error!";
    }
    
    @HystrixCommand(fallbackMethod = "testError")
    public String testService(String name) {
        return restTemplate.getForObject("http://SERVICE-AHH/test?name="+name,String.class);
    }
    
    public String testError(String name) {
        return name+",test Error!";
    }
    
    @HystrixCommand(fallbackMethod = "allError")
    public String allService(String name) {
        return restTemplate.getForObject("http://SERVICE-AHH/**",String.class);
    }
    
    public String allError(String name) {
        return name+",all test Error!";
    }
}
