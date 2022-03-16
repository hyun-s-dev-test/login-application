package com.dev.woo.toyproject.login.loginserver.domain.user;

import com.dev.woo.toyproject.login.loginserver.controller.dto.UserUpdateRequestDto;
import com.dev.woo.toyproject.login.loginserver.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String id;

    @Column
    private String password;

    @Column
    private String gender;

    @Column
    private LocalDate birth;

    @Column
    private String socialType;

    @Column
    private String token;

    @Column
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String id, String password, String gender, String socialType, LocalDate birth, String token, Role role, String phone) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.gender = gender;
        this.socialType = socialType;
        this.token = token;
        this.birth = birth;
        this.role = role;
        this.phone = phone;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

    public void update(UserUpdateRequestDto updateInfo) {
        this.name = updateInfo.getName();
        this.password = updateInfo.getPassword();
        this.gender = updateInfo.getGender();
        this.socialType = updateInfo.getSocialType();
        this.token = updateInfo.getToken();
        this.birth = updateInfo.getBirth();
        this.phone = updateInfo.getPhone();
    }
}