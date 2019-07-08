package com.alan.dashboard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

@Configuration
@ImportResource(locations={"classpath:beans.xml"})
public class MyConfig {
    @Autowired
    private RestTemplateBuilder builder;
    @Bean
    public RestTemplate getClient(){
        System.out.println("test getClient");
        System.out.println(builder);
        return this.builder.build();
    }
}
