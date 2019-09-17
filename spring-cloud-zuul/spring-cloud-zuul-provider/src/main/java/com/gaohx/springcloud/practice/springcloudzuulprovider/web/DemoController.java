package com.gaohx.springcloud.practice.springcloudzuulprovider.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public ResponseEntity demo() {
        return new ResponseEntity("hello world", HttpStatus.OK);
    }

}
