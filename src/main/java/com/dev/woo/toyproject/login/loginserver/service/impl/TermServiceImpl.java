package com.dev.woo.toyproject.login.loginserver.service.impl;

import com.dev.woo.toyproject.login.loginserver.controller.dto.ActiveTermResponseDto;
import com.dev.woo.toyproject.login.loginserver.controller.dto.TermSaveRequestDto;
import com.dev.woo.toyproject.login.loginserver.domain.term.Term;
import com.dev.woo.toyproject.login.loginserver.domain.term.TermRepository;
import com.dev.woo.toyproject.login.loginserver.service.TermService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TermServiceImpl implements TermService {

    private final TermRepository termRepository;
    private final int ACTIVE = 1;
    @Override
    public List<ActiveTermResponseDto> findAllActiveTerm() {

        return termRepository.findAllByActiveOrderByOrderNumAsc((long) ACTIVE).stream()
                .map(ActiveTermResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public Long save(TermSaveRequestDto requestDto) {
        return termRepository.save(requestDto.toEntity()).getPk();
    }
}
