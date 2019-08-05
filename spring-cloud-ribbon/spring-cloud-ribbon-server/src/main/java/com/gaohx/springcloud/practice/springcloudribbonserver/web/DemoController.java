package com.gaohx.springcloud.practice.springcloudribbonserver.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("/demo")
    public String demo() {
        return "hello world " + serverPort;
    }

}
