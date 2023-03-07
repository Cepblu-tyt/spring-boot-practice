package com.sda.study.springbootpractice.configurations;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration for CORS
 *
 * @author Sergei Oksanen
 * @Date 3/7/2023
 */

@Configuration
@EnableWebMvc
public class CorsConfiguration implements WebMvcConfigurer {
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET","POST", "PUT");
    }
}
