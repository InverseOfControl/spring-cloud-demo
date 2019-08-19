package com.gaohx.springcloud.practice.hystrixprovider.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class DemoController {

    private final Random random = new Random();

    @GetMapping("/demo")
    @HystrixCommand(
            fallbackMethod = "demoFallback")
    public String demo() {
        long l = random.nextInt(100);
        if (l > 50) {
            throw new RuntimeException("l > 50");
        }
        return "hello world!";
    }

    public String demoFallback() {
        return "demoFallback";
    }

}
