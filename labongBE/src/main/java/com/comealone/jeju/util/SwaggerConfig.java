package com.comealone.jeju.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.*;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//http://localhost:9999/swagger-ui/index.html

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("LABONG")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.comealone.jeju.presentation.controller"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SSAFY API")
				.description("<h2>SSAFY VUE Book WorkShop API Reference for Developers</h2>")
				.termsOfServiceUrl("https://edu.ssafy.com")
				.license("SSAFY License")
				.licenseUrl("https://www.ssafy.com/ksp/jsp/swp/etc/swpPrivacy.jsp").version("1.0").build();
	}

}
