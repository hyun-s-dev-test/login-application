package com.dev.woo.toyproject.login.loginserver.controller;

import com.dev.woo.toyproject.login.loginserver.controller.dto.UserResponseDto;
import com.dev.woo.toyproject.login.loginserver.controller.dto.UserSaveRequestDto;
import com.dev.woo.toyproject.login.loginserver.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR!"),
    })
    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDto>> getAllUserInfo() {
        return ResponseEntity.ok(userService.findAllUser());
    }

    @Operation(summary = "유저 추가", description = "입력한 데이터로 새로운 유저를 생성합니다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 400, message = "BAD REQUEST!"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR!"),
    })
    @PostMapping()
    public ResponseEntity save(@RequestBody UserSaveRequestDto requestDto) {
        Long savedUserPk = userService.save(requestDto);

        if (savedUserPk == -1) return ResponseEntity.badRequest().build();
        else return ResponseEntity.ok(savedUserPk);
    }
}
