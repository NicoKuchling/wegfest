package com.nicokuchling.wegfest.wegfest_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.nicokuchling.wegfest")
public class WegfestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WegfestApplication.class, args);
    }

}
