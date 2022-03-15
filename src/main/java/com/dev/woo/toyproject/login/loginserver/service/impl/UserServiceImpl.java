package com.dev.woo.toyproject.login.loginserver.service.impl;

import com.dev.woo.toyproject.login.loginserver.controller.dto.UserResponseDto;
import com.dev.woo.toyproject.login.loginserver.domain.user.UserRepository;
import com.dev.woo.toyproject.login.loginserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserResponseDto> findAllUser() {
        return userRepository.findAll().stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }
}
