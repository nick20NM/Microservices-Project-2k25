package com.alpha.www.Employee;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service REST API's", 
				description = "Employee Service REST API's Documentation", 
				version = "v1.0", 
				contact = @Contact(
						name = "NISHIT MASIH", 
						email = "masihnishit@gmail.com", 
						url = "https://www.linkedin.com/in/nishit-masih/"
						), 
				license = @License(
						name = "Apache 2.0", 
						url = "https://www.linkedin.com/in/nishit-masih/"
						)
				), 
		externalDocs = @ExternalDocumentation(
				description = "Employee-Service Doc", 
				url = "https://www.linkedin.com/in/nishit-masih/"
				)
		)
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
	
	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}
}
