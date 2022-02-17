package com.wubo.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan(basePackages = "com.wubo.blog.dao")
@EnableWebMvc
public class blogApplication {
    public static void main(String[] args) {
        SpringApplication.run(blogApplication.class,args);
    }
}
