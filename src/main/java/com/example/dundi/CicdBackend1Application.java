package com.example.dundi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration; // Import this class
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.ErrorPageFilter;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class) // Add this line
public class CicdBackend1Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CicdBackend1Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CicdBackend1Application.class);
    }

    @Bean
    public FilterRegistrationBean<ErrorPageFilter> errorPageFilterRegistration() {
        FilterRegistrationBean<ErrorPageFilter> registration = new FilterRegistrationBean<>(new ErrorPageFilter());
        registration.setEnabled(false);
        return registration;
    }
}
