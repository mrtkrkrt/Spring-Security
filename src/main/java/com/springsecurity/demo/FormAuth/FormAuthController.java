package com.springsecurity.demo.FormAuth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormAuthController {

    @GetMapping("hello-world")
    public String helloWorld() {
        return "Hello World";
    }
}
