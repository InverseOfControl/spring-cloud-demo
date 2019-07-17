package com.gaohx.springcloud.practice.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

public class MyBootstrapConfiguration implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        Map<String, Object> map = new HashMap<>();
        map.put("aaa", 111);
        MapPropertySource mapPropertySource = new MapPropertySource("my-source", map);
        propertySources.addFirst(mapPropertySource);
    }
}
