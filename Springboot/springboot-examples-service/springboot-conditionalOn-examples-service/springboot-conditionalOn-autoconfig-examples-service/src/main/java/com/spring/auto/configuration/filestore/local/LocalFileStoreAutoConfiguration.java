package com.spring.auto.configuration.filestore.local;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.auto.configuration.filestore.FileStore;

@Configuration
@ConditionalOnProperty(name = "file.store", havingValue = "local")
public class LocalFileStoreAutoConfiguration {
    @Bean
    public FileStore fileStore() {
        return new LocalFileStore();
    }
}
