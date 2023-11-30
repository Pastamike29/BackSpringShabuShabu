package com.mikestudio.Spring_first.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    public void addCorsMapping(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:2929")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);

    }

}
