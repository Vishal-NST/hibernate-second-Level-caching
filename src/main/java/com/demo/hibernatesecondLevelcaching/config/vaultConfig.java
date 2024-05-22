package com.demo.hibernatesecondLevelcaching.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "db-credentials")
public class vaultConfig {

    private String username;
    private String password;

    @PostConstruct
    public void postConstruct() {
        System.out.println("Username from Vault: " + username);
        System.out.println("Password from Vault: " + password);
    }
}