package com.mikestudio.Spring_first.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    public void addCORSMapping  (CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:2929")
                .allowedMethods("GET","POST","PUT","DELETE");
    }
}
