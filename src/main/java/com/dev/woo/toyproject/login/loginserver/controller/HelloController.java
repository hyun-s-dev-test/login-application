package com.dev.woo.toyproject.login.LoginServer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Dev Branch CI&CD Test\n" +
                "Hello world! MYSQL connect finished!";
    }
}
