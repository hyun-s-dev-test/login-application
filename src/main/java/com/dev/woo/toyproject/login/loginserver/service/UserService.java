package com.dev.woo.toyproject.login.loginserver.service;

import com.dev.woo.toyproject.login.loginserver.controller.dto.UserLoginRequestDto;
import com.dev.woo.toyproject.login.loginserver.controller.dto.UserLoginResponseDto;
import com.dev.woo.toyproject.login.loginserver.controller.dto.UserResponseDto;
import com.dev.woo.toyproject.login.loginserver.controller.dto.UserSaveRequestDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> findAllUser();

    Long save(UserSaveRequestDto requestDto);

    UserLoginResponseDto login(UserLoginRequestDto requestDto);
}
