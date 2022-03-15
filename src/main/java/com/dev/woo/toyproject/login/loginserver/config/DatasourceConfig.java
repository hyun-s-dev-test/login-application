package com.dev.woo.toyproject.login.loginserver.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
    private final Environment environment;

    public DatasourceConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

        dataSourceBuilder.url(environment.getProperty("MYSQL_URL"));
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.username(environment.getProperty("MYSQL_USERNAME"));
        dataSourceBuilder.password(environment.getProperty("MYSQL_PASSWORD"));

        return dataSourceBuilder.build();
    }
}
