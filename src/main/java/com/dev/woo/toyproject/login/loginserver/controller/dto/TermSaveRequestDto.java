package com.dev.woo.toyproject.login.loginserver.controller.dto;

import com.dev.woo.toyproject.login.loginserver.domain.term.Term;
import com.dev.woo.toyproject.login.loginserver.domain.user.Role;
import com.dev.woo.toyproject.login.loginserver.domain.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@ApiModel(value = "TermSaveRequestDto", description = "약관생성 정보")
public class TermSaveRequestDto {

    @ApiModelProperty(notes = "제목", value = "name", example ="사용자 정보 공개동의", required = true)
    private String title;

    @ApiModelProperty(notes = "내용", value = "content", example ="블라블라", required = true)
    private String content;

    @ApiModelProperty(notes = "작성자", value = "writer", example ="남영우", required = true)
    private String writer;

    @ApiModelProperty(notes = "약관사용 여부", value = "active", example ="1 이면 사용중, 0 이면 사용x", required = true)
    private Long active;

    @ApiModelProperty(notes = "약관번호(사용하지 않는다면, -1)", value = "orderNum", example ="1", required = true)
    private Long orderNum;

    @Builder
    public TermSaveRequestDto(String title, String content, String writer, Long active, Long orderNum) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.active = active;
        this.orderNum = orderNum;
    }

    public Term toEntity() {
        return Term.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .active(active)
                .orderNum(orderNum)
                .build();
    }
}
