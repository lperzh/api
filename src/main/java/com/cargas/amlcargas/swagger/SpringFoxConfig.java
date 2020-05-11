package com.cargas.amlcargas.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@PropertySource("classpath:swagger.properties")
public class SpringFoxConfig {

	@Bean
	public Docket appiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cargas.amlcargas"))
				.paths(PathSelectors.ant("/v1/**"))
				.build()
				.apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"AML - CARGAS",
				"Servicio de Carga de Archivos AML",
				"v1",
				"https://www.meltsan.us/",
				new Contact("Meltsan Solutions", "https://www.meltsan.us","luis.perez@meltsan.com"),
				"Licencia",
				"https://www.meltsan.us/",
				Collections.emptyList()
				);
	}
	
}
