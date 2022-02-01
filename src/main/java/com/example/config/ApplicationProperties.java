package com.example.config;

import io.micronaut.context.annotation.ConfigurationProperties;
import jakarta.inject.Singleton;
import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties("app.data.mongodb.connection")
@Singleton
@Getter
@Setter
public class ApplicationProperties {
    private String host;
    private Integer port;
    private String database;
    private String username;
    private String password;
    private Integer timeout;
}
