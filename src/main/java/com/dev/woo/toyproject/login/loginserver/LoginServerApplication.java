package com.dev.woo.toyproject.login.loginserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
// import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableJpaAuditing
@SpringBootApplication // (exclude = {DataSourceAutoConfiguration.class})
public class LoginServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoginServerApplication.class, args);
	}
}
