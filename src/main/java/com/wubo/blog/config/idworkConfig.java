package com.wubo.blog.config;

import com.wubo.blog.util.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class idworkConfig {

    @Bean
    public IdWorker getIdWork(){
        IdWorker idWork = new IdWorker(0,0);
        return idWork;
    }
}
