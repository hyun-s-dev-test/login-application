package com.dev.woo.toyproject.login.loginserver.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Hello Controller", tags = "Hello")
@RestController
public class HelloController {

    @Operation(summary = "헬로우를 출력하는 페이지 API", description = "헬로우를 출력하는 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 400, message = "BAD REQUEST!"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR!"),
    })
    @GetMapping("/")
    public String hello() {
        return "Dev Branch CI&CD Test\n" +
                "Hello world! MYSQL connect finished! Swagger Address : http://3.37.242.72/swagger-ui/index.html";
    }
}
