package com.spring.application;

import com.spring.application.service.ServiceA;
import com.spring.extra.service.ServiceB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@SpringBootApplication(scanBasePackageClasses = {SpringBootConsoleApplication.class, ServiceB.class})
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private ServiceA serviceA;
    @Autowired
    private ServiceB serviceB;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
    }
}
