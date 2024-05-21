package com.demo.hibernatesecondLevelcaching.config;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Data
@Configuration
@ConfigurationProperties(prefix = "vault")
public class vaultConfig {

    private static String username;

    private static String password;

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}
