package com.dev.woo.toyproject.login.loginserver.service;

import com.dev.woo.toyproject.login.loginserver.controller.dto.ActiveTermResponseDto;
import com.dev.woo.toyproject.login.loginserver.controller.dto.TermSaveRequestDto;

import java.util.List;

public interface TermService {

    List<ActiveTermResponseDto> findAllActiveTerm();

    Long save(TermSaveRequestDto requestDto);
}
