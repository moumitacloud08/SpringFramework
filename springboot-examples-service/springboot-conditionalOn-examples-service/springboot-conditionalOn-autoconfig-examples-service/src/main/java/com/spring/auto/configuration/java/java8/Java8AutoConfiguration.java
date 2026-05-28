package com.spring.auto.configuration.java.java8;

import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.auto.configuration.java.JavaEnvInfo;

@Configuration
@ConditionalOnJava(value = JavaVersion.NINE, range = ConditionalOnJava.Range.OLDER_THAN)
public class Java8AutoConfiguration {
    @Bean
    public JavaEnvInfo javaEnvInfo() {
        return new Java8EnvInfo();
    }
}
