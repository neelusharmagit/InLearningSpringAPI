package com.learning.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class InLearningAPIApplication {
    public static void main(String[] args) {
        SpringApplication.run(InLearningAPIApplication.class, args);
    }
}
