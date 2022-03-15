package com.dev.woo.toyproject.login.loginserver.service;

import com.dev.woo.toyproject.login.loginserver.controller.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> findAllUser();
}
