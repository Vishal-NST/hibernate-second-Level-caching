package com.demo.hibernatesecondLevelcaching.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private final vaultConfig vaultConfig;

    @Autowired
    public DataSourceConfig(vaultConfig vaultConfig) {
        this.vaultConfig = vaultConfig;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .username(com.demo.hibernatesecondLevelcaching.config.vaultConfig.getUsername())
                .password(com.demo.hibernatesecondLevelcaching.config.vaultConfig.getPassword())
                .build();
    }
}

