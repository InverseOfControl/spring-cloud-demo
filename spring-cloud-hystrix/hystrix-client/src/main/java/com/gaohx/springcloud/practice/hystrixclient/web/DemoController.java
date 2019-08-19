package com.gaohx.springcloud.practice.hystrixclient.web;

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
        String url = "http://hystrix-provider-server/demo";
        String result = restTemplate.getForObject(url, String.class, new Object[0]);
        return result;
    }
}
