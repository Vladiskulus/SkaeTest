package com.iambulance.skai.test;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;
import springfox.documentation.builders.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.*;

@Configuration
@EnableWebMvc
public class ApplicationConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.iambulance.skai.test"))
                .paths(PathSelectors.any())
                .build();
    }
}
