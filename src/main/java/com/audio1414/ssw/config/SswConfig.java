package com.audio1414.ssw.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
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
@Import(BeanValidatorPluginsConfiguration.class)
@PropertySource("classpath:application.properties")
public class SswConfig {
	@Autowired
	private Environment env;
	
	@Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.audio1414"))
                .paths(PathSelectors.ant("/v1/**"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
    	String version = env.getProperty("ssw.api.version");
    	String contactUrl = env.getProperty("ssw.api.contact.url"); 
    	String contactEmail = env.getProperty("ssw.api.contact.email");
    	String contactName = env.getProperty("ssw.api.contact.name");
    	String license = env.getProperty("ssw.api.license");
    	String licenseUrl = env.getProperty("ssw.api.license.url");
    	
        return new ApiInfo(
                "Squeezebox software player",
                "Squeezebox software player for web.",
                version,
                "",
                new Contact(contactName, contactUrl, contactEmail),
                license,
                licenseUrl,
                Collections.emptyList()
        );
    }
}
