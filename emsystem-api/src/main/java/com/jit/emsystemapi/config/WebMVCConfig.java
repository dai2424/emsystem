package com.jit.emsystemapi.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMVCConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        //跨域配置
        registry.addMapping("/**").allowedOrigins("http://localhost:8080").allowedMethods("POST","GET","DELETE");
    }
}
