package com.dev.woo.toyproject.login.loginserver.domain.term;

import com.dev.woo.toyproject.login.loginserver.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Term extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String content;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private Long active;

    @Column
    private Long orderNum;

    @Builder
    public Term(String title, String content, String writer, Long active, Long orderNum) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.active = active;
        this.orderNum = orderNum;
    }

    public boolean isActive() {
        return active == 1;
    }
}
