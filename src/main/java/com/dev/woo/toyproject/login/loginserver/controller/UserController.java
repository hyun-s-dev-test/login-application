package com.dev.woo.toyproject.login.loginserver.controller;

import com.dev.woo.toyproject.login.loginserver.controller.dto.UserResponseDto;
import com.dev.woo.toyproject.login.loginserver.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "User Controller", tags = "User")
@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "모든 유저 조회", notes = "모든 유저의 정보를 가져옵니다.(비밀번호, 토큰 제외)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 400, message = "BAD REQUEST!"),
            @ApiResponse(code = 404, message = "NOT FOUND!"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR!"),
    })
    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDto>> getAllUserInfo() {
        return ResponseEntity.ok(userService.findAllUser());
        //return new ResponseEntity<List<UserResponseDto>>(userService.findAllUser(), HttpStatus.OK);
    }
}
