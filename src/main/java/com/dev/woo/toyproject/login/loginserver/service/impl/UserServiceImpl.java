package com.dev.woo.toyproject.login.loginserver.service.impl;

import com.dev.woo.toyproject.login.loginserver.controller.dto.UserLoginRequestDto;
import com.dev.woo.toyproject.login.loginserver.controller.dto.UserLoginResponseDto;
import com.dev.woo.toyproject.login.loginserver.controller.dto.UserResponseDto;
import com.dev.woo.toyproject.login.loginserver.controller.dto.UserSaveRequestDto;
import com.dev.woo.toyproject.login.loginserver.domain.user.SessionUser;
import com.dev.woo.toyproject.login.loginserver.domain.user.User;
import com.dev.woo.toyproject.login.loginserver.domain.user.UserRepository;
import com.dev.woo.toyproject.login.loginserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Override
    public List<UserResponseDto> findAllUser() {
        return userRepository.findAll().stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public Long save(UserSaveRequestDto requestDto) {
        boolean isExistId = userRepository.existsById(requestDto.getId());
        return !isExistId ? userRepository.save(requestDto.toEntity()).getPk() : -1;
    }

    @Override
    public UserLoginResponseDto login(UserLoginRequestDto requestDto) {
        boolean isExistUser = userRepository.existsByIdAndPassword(requestDto.getId(), requestDto.getPassword());

        if (!isExistUser) throw new IllegalArgumentException("해당 id를 가진 유저는 없습니다. (조회한 id : " + requestDto.getId() + ")");

        User user = userRepository.findById(requestDto.getId());
        httpSession.setAttribute("user", new SessionUser(user));
        return new UserLoginResponseDto(user);
    }
}
