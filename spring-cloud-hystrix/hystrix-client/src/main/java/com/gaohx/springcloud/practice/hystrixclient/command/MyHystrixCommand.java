package com.gaohx.springcloud.practice.hystrixclient.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class MyHystrixCommand extends HystrixCommand<Object> {

    private RestTemplate rt;

    public MyHystrixCommand(HystrixCommandGroupKey group, RestTemplate restTemplate) {
        super(group);
        rt = restTemplate;
    }

    @Override
    protected Object run() throws Exception {
        String url = "http://hystrix-provider-server/demo";
        return rt.getForObject(url, String.class, new Object[0]);
    }

    @Override
    protected Object getFallback() {
        return Collections.EMPTY_LIST;
    }
}
