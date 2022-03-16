package com.dev.woo.toyproject.login.loginserver.service.impl;

import com.dev.woo.toyproject.login.loginserver.controller.dto.*;
import com.dev.woo.toyproject.login.loginserver.domain.user.SessionUser;
import com.dev.woo.toyproject.login.loginserver.domain.user.User;
import com.dev.woo.toyproject.login.loginserver.domain.user.UserRepository;
import com.dev.woo.toyproject.login.loginserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public UserResponseDto update(String id, UserUpdateRequestDto updateRequestDto) {
        User user = userRepository.findById(id);

        if (user == null) throw new IllegalArgumentException(("해당하는 유저가 없습니다. 쿠키에 저장된 값에 문제가 있으니 다시 시도해주세요."));

        user.update(updateRequestDto);

        return new UserResponseDto(user);
    }

    @Override
    public UserResponseDto findById(String id) {
        return new UserResponseDto(userRepository.findById(id));
    }
}
