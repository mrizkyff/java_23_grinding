package com.mrizkyff.java_23.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HelloScheduled {
    @Scheduled(fixedRate = 1000)
    private void helloScheduled() {
        System.out.println("Hello World!" + System.currentTimeMillis());
    }
}
