package com.dev.woo.toyproject.login.LoginServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Main Branch CI&CD Test\n" +
                "Hello world!";
    }
}
