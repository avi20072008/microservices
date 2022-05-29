package com.dailycode.apigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {

    @GetMapping("/userServiceFallback")
    public String userServiceFallbackMethod(){
        System.out.println("************************************************");
        return "User Service is taking longer than expected. Please try again later.";
    }

    @GetMapping("/deptServiceFallback")
    public String deptServiceFallbackMethod(){
        System.out.println("************************************************");
        return "Department Service is taking longer than expected. Please try again later.";
    }
}
