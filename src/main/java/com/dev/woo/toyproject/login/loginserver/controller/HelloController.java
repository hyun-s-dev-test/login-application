package com.dev.woo.toyproject.login.loginserver.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Hello Controller", tags = "Hello")
@RestController
public class HelloController {

    @ApiOperation(value = "모든 유저 조회", notes = "모든 유저의 정보를 가져옵니다.(비밀번호, 토큰 제외)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 400, message = "BAD REQUEST!"),
            @ApiResponse(code = 404, message = "NOT FOUND!"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR!"),
    })
    @GetMapping("/")
    public String hello() {
        return "Dev Branch CI&CD Test\n" +
                "Hello world!";
    }
}
