package com.jdreyes.northwindjsf.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:sqlserver://192.168.10.136:1433;database=Northwind;trustServerCertificate=true");
        builder.username("sa");
        builder.password("sqlserver");
        return builder.build();
    }

}
