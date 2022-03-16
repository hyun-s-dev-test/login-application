package com.dev.woo.toyproject.login.loginserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;
// import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableJpaAuditing
@SpringBootApplication // (exclude = {DataSourceAutoConfiguration.class})
public class LoginServerApplication {


	@PostConstruct
	public void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
	}

	public static void main(String[] args) {
		SpringApplication.run(LoginServerApplication.class, args);
	}
}
