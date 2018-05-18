package com.example.eureka_client_3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClient3Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient3Application.class, args);
	}
	
    @Value("${server.port}")
    String port;
    
    @RequestMapping("/ahh")
    public String home(@RequestParam String name) {
        return "ahh "+name+",i am from port:" +port;
    }
    
    @RequestMapping("/test")
    public String test(@RequestParam String name) {
        return "test from port" +port + " name is " + name;
    }
    
    @RequestMapping("/test2")
    public String test2(@RequestParam String name) {
        return "test2 from port" +port + " name is " + name;
    }
}