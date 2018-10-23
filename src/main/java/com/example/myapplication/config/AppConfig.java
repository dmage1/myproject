package com.example.myapplication.config;

import com.example.myapplication.domain.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Value("${app.name}")
    private String appName;

    @Value("${app.description}")
    private String appDescription;

    @Value("${app.version}")
    private String appVersion;

    @Bean
    @Profile("development")
    public Info devInfo() {
        return new Info("Development " + appName, appDescription, appVersion);
    }

    @Bean
    @Profile("production")
    public Info info() {
        return new Info(appName, appDescription, appVersion);
    }

}