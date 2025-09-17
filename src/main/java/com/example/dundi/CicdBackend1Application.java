package com.example.dundi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CicdBackend1Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CicdBackend1Application.class, args);
    }

    // Required for WAR deployment in external Tomcat
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CicdBackend1Application.class);
    }
}
