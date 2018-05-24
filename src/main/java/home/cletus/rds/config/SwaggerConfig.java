package home.cletus.rds.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swaggerDoc() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("home.cletus.rds.controller"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Try Spring Boot",
                "Auto-gen Swagger2 Doc",
                "1.0",
                "Terms of Service",
                new Contact("Cletus", "https://www.google.com", "clet.lee@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/license.html",
                new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }
}
