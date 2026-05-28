package com.spring.auto.configuration.java.java9;

import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.auto.configuration.java.JavaEnvInfo;

@Configuration
@ConditionalOnJava(JavaVersion.NINE)
public class Java9AutoConfiguration {
    @Bean
    public JavaEnvInfo javaEnvInfo() {
        return new Java9EnvInfo();
    }
}
