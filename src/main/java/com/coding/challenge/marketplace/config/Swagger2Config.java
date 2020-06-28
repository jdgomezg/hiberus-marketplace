package com.coding.challenge.marketplace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.coding.challenge.marketplace.controller"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "API of coding challenge",
                "API in charge of managing purchase orders",
                "API V 1.0.0",
                "Terms of service",
                new Contact("Juan David Gómez Gómez", "https://www.linkedin.com/in/juan-david-g%C3%B3mez-g%C3%B3mez-98412115a/",
                        "jugomez3@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}