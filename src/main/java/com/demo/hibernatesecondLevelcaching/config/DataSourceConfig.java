package com.demo.hibernatesecondLevelcaching.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    private vaultConfig vaultConfig;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost:5432/postgres")
                .username(vaultConfig.getUsername())
                .password(vaultConfig.getPassword())
                .driverClassName("org.postgresql.Driver")
                .build();
    }
}