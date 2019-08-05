package com.gaohx.springcloud.practice.springcloudribbonserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudRibbonServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRibbonServerApplication.class, args);
    }

}
