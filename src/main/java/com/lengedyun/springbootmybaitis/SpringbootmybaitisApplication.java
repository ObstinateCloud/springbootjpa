package com.lengedyun.springbootmybaitis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootmybaitisApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        System.out.println("main method");
        SpringApplication.run(SpringbootmybaitisApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringbootmybaitisApplication.class);
    }
}
