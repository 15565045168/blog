package com.wubo.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class swaggerConfig {
    @Bean
    public Docket getDocket(){
        Docket docket=new Docket(DocumentationType.SWAGGER_2);//指定文档风格

        //如何获取一个接口对象：1.new 接口，但是需要在构造器中实现接口方法，
        //2.new 子类或者实现类
        //3.工厂模式
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("博客后端接口说明") //标题
                .description("此文档详细说明了接口项目的规范。。。") //说明
                .version("1.0.0")//版本说明
                .contact(new Contact("武博","www.","15565045168@163.com"));//名称，网站，邮箱
        ApiInfo build = apiInfoBuilder.build();
        docket.apiInfo(build);//指定生成商城文档的标题信息，文档标题，版本，作者
        //以下为生成策略
        docket.select()
                .apis(RequestHandlerSelectors.basePackage("com.wubo.blog.controller"))//指定为那些控制器生成接口文档
                .paths(PathSelectors.any()) //为所有的接口tigong
                .build();
        return docket;
    }
}
