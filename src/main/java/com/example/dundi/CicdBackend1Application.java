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

    // Corrected bean definition for WAR deployment fix
    @Bean
    public FilterRegistrationBean<ErrorPageFilter> errorPageFilterRegistration() {
        // Create a new instance of the filter instead of expecting it to be autowired
        FilterRegistrationBean<ErrorPageFilter> registration = new FilterRegistrationBean<>(new ErrorPageFilter());
        registration.setEnabled(false);
        return registration;
    }
}
