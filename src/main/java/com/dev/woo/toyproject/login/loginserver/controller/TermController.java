package com.dev.woo.toyproject.login.loginserver.controller;

import com.dev.woo.toyproject.login.loginserver.controller.dto.ActiveTermResponseDto;
import com.dev.woo.toyproject.login.loginserver.controller.dto.TermSaveRequestDto;
import com.dev.woo.toyproject.login.loginserver.domain.term.Term;
import com.dev.woo.toyproject.login.loginserver.service.TermService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Term Controller", tags = "Term")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/term")
public class TermController {
    private final TermService termService;

    @Operation(summary = "약관 조회", description = "현재 사용중인 약관을 조회합니다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 400, message = "BAD REQUEST!"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR!"),
    })
    @GetMapping("/active/all")
    public ResponseEntity<List<ActiveTermResponseDto>> findAllActiveTerm() {
        return ResponseEntity.ok(termService.findAllActiveTerm());
    }

    @Operation(summary = "약관 생성", description = "약관을 생성합니다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK!"),
            @ApiResponse(code = 400, message = "BAD REQUEST!"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR!"),
    })
    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody TermSaveRequestDto requestDto) {
        return ResponseEntity.ok(termService.save(requestDto));
    }
}
