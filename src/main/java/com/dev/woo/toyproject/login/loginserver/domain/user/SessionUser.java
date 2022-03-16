package com.dev.woo.toyproject.login.loginserver.domain.user;

import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String id;
    private String password;
    private String token;
    private String socialType;
    private String gender;
    private LocalDate birth;
    private String phone;


    public SessionUser(User user) {
        this.name = user.getName();
        this.id = user.getId();
        this.password = user.getPassword();
        this.gender = user.getGender();
        this.socialType = user.getSocialType();
        this.token = user.getToken();
        this.birth = user.getBirth();
        this.phone = user.getPhone();
    }
}