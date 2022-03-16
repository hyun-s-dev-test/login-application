package com.dev.woo.toyproject.login.loginserver.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@ApiModel(value = "UserLoginRequestDto", description = "유저로그인 요청 정보")
public class UserLoginRequestDto {

    @ApiModelProperty(notes = "아이디", value = "id", example = "0woodev", required = true)
    private String id;

    @ApiModelProperty(notes = "비밀번호", value = "password", example = "0woodev")
    private String password;

    @Builder
    public UserLoginRequestDto(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
