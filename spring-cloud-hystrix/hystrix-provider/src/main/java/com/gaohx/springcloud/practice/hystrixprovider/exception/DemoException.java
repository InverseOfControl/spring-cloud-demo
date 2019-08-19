package com.gaohx.springcloud.practice.hystrixprovider.exception;

import com.gaohx.springcloud.practice.hystrixprovider.web.DemoController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = {DemoController.class})
public class DemoException {

    @ExceptionHandler(RuntimeException.class)
    public Object hand(Exception ex) {
        return ex.getMessage();
    }

}
