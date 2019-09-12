package com.netcompany.java.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration of Swagger.
 */
@Configuration
@EnableSwagger2
open class SwaggerConfig {
    @Bean
    open fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.netcompany"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(
                ApiInfoBuilder().contact(
                    Contact("Netcompany",
                        "https://www.netcompany.com",
                        "netcompany.no.hr@netcompany.com"
                    ))
                    .description("API for keeping track of your things")
                    .title("ThingAPI")
                    .version("1.0")
                    .build())
    }
}
