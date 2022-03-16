package com.dev.woo.toyproject.login.loginserver.controller.dto;

import com.dev.woo.toyproject.login.loginserver.domain.user.Role;
import com.dev.woo.toyproject.login.loginserver.domain.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@ApiModel(value = "UserSaveRequestDto", description = "유저 회원가입 정보")
public class UserSaveRequestDto {

    @ApiModelProperty(notes = "이름", value = "name", example ="남영우", required = true)
    private String name;

    @ApiModelProperty(notes = "아이디", value = "id", example = "0woodev", required = true)
    private String id;

    @ApiModelProperty(notes = "비밀번호", value = "password", example = "0woodev")
    private String password;

    @ApiModelProperty(notes = "성별", value = "gender", example = "남자는 M, 여자는 F")
    private String gender;

    @ApiModelProperty(notes = "소셜로그인 타입(일반로그인 : none)", value = "social type", example="none")
    private String socialType;

    @ApiModelProperty(notes = "토큰", value = "token", example = "qq0zvjq390qwfj")
    private String token;

    @ApiModelProperty(notes = "휴대폰번호", value = "phone", example = "01012345678")
    private String phone;

    @ApiModelProperty(notes = "생년월일", value = "birth", example = "1997-07-28")
    private LocalDate birth;

    @Builder
    public UserSaveRequestDto(String name, String id, String password, String gender, String socialType, String token, String phone, LocalDate birth) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.gender = gender;
        this.socialType = socialType;
        this.token = token;
        this.phone = phone;
        this.birth = birth;
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .id(id)
                .password(password)
                .gender(gender)
                .socialType(socialType)
                .token(token)
                .role(Role.USER)
                .phone(phone)
                .birth(birth)
                .build();
    }
}
