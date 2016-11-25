package com.github.yingzhuo.spring.examples.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ImportResource("classpath:/swagger.xml")
@Profile("swagger")
public class ApplicationConfigSwagger {

    @Bean
    public Docket swaggerDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.yingzhuo.spring.examples.swagger.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("习之铃铛v3.0.0")
//                .description("习之铃铛v3.0.0")
//                .contact(new Contact("应卓", "https://github.com/yingzhuo", "yingzhor@gmail.com"))
                .version("3.0.0")
                .build();
    }

}
