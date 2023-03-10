package br.com.drogaria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.drogaria"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());

    }
    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Medicamentos API REST",
                "API REST de cadastro de medicamentos",
                "1.0",
                "Terms of service",
                new Contact("Stefany Silveira",",","stefany@hotmail.com"),
                "Apache License Version 1.0",
                "http://www.apache.org/licensen.html", new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }


}