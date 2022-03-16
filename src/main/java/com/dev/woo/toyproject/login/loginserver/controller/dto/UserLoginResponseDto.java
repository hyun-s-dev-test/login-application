package com.dev.woo.toyproject.login.loginserver.controller.dto;

import com.dev.woo.toyproject.login.loginserver.domain.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@ApiModel(value = "UserLoginResponseDto", description = "유저로그인 응답 정보")
public class UserLoginResponseDto {
    @ApiModelProperty(value = "name", notes = "이름", example = "남영우", required = false)
    private final String name;
    @ApiModelProperty(value = "id", notes = "아이디", example = "0woodev", required = false)
    private final String id;


    public UserLoginResponseDto(User user) {
        this.name = user.getName();
        this.id = user.getId();
    }

    @Builder
    public UserLoginResponseDto(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
