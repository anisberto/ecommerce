package br.com.supera.ecommerce.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@ConfigurationProperties("supera.swagger")
public class SwaggerConfig extends WebMvcConfigurationSupport {

    private String swaggerPath;

    private String nome;

    @Bean
    public Docket allApi() {
        List<Parameter> aParameters = new ArrayList<Parameter>();
        Set<String> protocols = new HashSet<>();
        protocols.add("http");
        protocols.add("https");
        return new Docket(DocumentationType.SWAGGER_2).host(swaggerPath)
                .groupName("All")
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .build()
                .protocols(protocols)
                .ignoredParameterTypes(ApiIgnore.class)
                .enableUrlTemplating(true).globalOperationParameters(aParameters);
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(nome)
                .description("Projeto criado para um ecommerce")
                .termsOfServiceUrl("http://localhost:8080")
                .license("MIT")
                .version("1.0")
                .build();
    }
    public String getSwaggerPath() {
        return swaggerPath;
    }
    public void setSwaggerPath(String swaggerPath) {
        this.swaggerPath = swaggerPath;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}