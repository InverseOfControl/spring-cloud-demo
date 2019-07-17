package com.gaohx.springcloud.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.xml.MarshallingView;

@SpringBootApplication
public class SpringCloudBootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudBootstrapApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public MarshallingView marshallingView() {
        return new MarshallingView();
    }

}
