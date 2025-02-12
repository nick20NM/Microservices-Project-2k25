package com.alpha.www.organization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Organization Service REST API's", 
				description = "Organization Service REST API's Documentation", 
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
				description = "Organization-Service Doc", 
				url = "https://www.linkedin.com/in/nishit-masih/"
				)
		)
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
