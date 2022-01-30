package com.n11.loanapplication.gen.config;

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
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.n11"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Credit Application - n11 TalentHub Java Bootcamp Graduation Project ")
                .description("\"This application takes customers' loan application requests and \n" +
                                   "returns the loan result to the customer according to the relevant criteria. \"")
                .contact(new Contact("Ülkü Arıkanoğlu", "https://www.linkedin.com/in/arikanogluulku/", "arikanogluulku@gmail.com "))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }

}
