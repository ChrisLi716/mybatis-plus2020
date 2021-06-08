package com.chris.mybatisplus.controller;

//import com.chris.service.HelloWorldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/hello")
public class HelloWorldController {

//    @Resource
//    private HelloWorldService helloWorldService;
//
//    @GetMapping("/sayHello")
//    public String helloworld(@RequestParam("info") String info) {
//        return helloWorldService.sayHello(info);
//    }

}
