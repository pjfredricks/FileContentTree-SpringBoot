package com.jfredricks.filecontenttree.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
@Profile("!integration")
public class SwaggerConfig {

    /**
     * Swagger documentation setup.
     * @return Docket
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jfredricks.filecontenttree.web"))
                .paths(resourceOnlyEndpoints())
                .build()
                .pathMapping("/");
    }

    /**
     *
     * @return Predicate
     */
    private Predicate<String> resourceOnlyEndpoints(){
        return (String input) -> input.contains("api");
    }

    /**
     *
     * @return ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("File Content Tree")
                .description("Sample Project")
                .version("1")
                .build();
    }
}
