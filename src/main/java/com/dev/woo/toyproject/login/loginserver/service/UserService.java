package com.dev.woo.toyproject.login.loginserver.service;

import com.dev.woo.toyproject.login.loginserver.controller.dto.*;

import java.util.List;

public interface UserService {
    List<UserResponseDto> findAllUser();

    Long save(UserSaveRequestDto requestDto);

    UserLoginResponseDto login(UserLoginRequestDto requestDto);

    UserResponseDto update(String id, UserUpdateRequestDto updateRequestDto);

    UserResponseDto findById(String id);
}
