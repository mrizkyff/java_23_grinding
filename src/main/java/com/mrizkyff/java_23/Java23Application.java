package com.mrizkyff.java_23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Java23Application {

    public static void main(String[] args) {
        SpringApplication.run(Java23Application.class, args);
    }

}
