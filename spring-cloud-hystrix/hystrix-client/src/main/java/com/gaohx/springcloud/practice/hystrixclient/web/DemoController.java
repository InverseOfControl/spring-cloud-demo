package com.gaohx.springcloud.practice.hystrixclient.web;

import com.gaohx.springcloud.practice.hystrixclient.command.MyHystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/demo")
    public String demo() {
        // 客户端熔断
        String result;
        HystrixCommandGroupKey key = HystrixCommandGroupKey.Factory.asKey("");
        result = (String) new MyHystrixCommand(key, restTemplate).execute();

        // 服务的熔断
        String url = "http://hystrix-provider-server/demo";
        result = restTemplate.getForObject(url, String.class, new Object[0]);
        return result;
    }
}
