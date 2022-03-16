package com.dev.woo.toyproject.login.loginserver.controller.dto;

import com.dev.woo.toyproject.login.loginserver.domain.term.Term;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
@ApiModel(value = "ActiveTermResponseDto", description = "사용중인 약관 데이터")
public class ActiveTermResponseDto {

    @ApiModelProperty(notes = "제목", value = "title", example ="사용자 정보 공개동의", required = true)
    private String title;

    @ApiModelProperty(notes = "내용", value = "content", example ="블라블라", required = true)
    private String content;

    @ApiModelProperty(notes = "작성자", value = "writer", example ="남영우", required = true)
    private String writer;

    @ApiModelProperty(notes = "약관 번호", value = "orderNum", example ="1", required = true)
    private Long orderNum;

    public ActiveTermResponseDto(Term term) {
        this.title = term.getTitle();
        this.content = term.getContent();
        this.writer = term.getWriter();
        this.orderNum = term.getOrderNum();
    }
}
