package com.alan.dashboard.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new ResourceInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","/js/**","/css/**","/image/**");
//        registry.addInterceptor(new ResourceInterceptor()).addPathPatterns("/history","/data/**");
        registry.addInterceptor(new ResourceInterceptor()).addPathPatterns("/**").excludePathPatterns("/login", "/js/**", "/css/**", "/image/**");
    }

}
