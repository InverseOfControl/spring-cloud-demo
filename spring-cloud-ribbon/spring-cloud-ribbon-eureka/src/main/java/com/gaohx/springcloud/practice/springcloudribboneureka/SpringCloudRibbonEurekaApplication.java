package com.gaohx.springcloud.practice.springcloudribboneureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudRibbonEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRibbonEurekaApplication.class, args);
    }

}
