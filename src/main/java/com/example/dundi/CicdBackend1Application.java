package com.example.dundi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.ErrorPageFilter;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

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

    // Fix for the Tomcat deployment error.
    // This disables the duplicate registration of the ErrorPageFilter.
    @Bean
    public FilterRegistrationBean<ErrorPageFilter> errorPageFilterRegistration(ErrorPageFilter filter) {
        FilterRegistrationBean<ErrorPageFilter> registration = new FilterRegistrationBean<>(filter);
        registration.setEnabled(false);
        return registration;
    }
}
