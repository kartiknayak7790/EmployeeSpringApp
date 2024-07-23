package com.employee.management;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(info = @Info(
		title="Employee management rest api documentation",
		description = "Employee management Rest api documentation",
		version="1.0",
		contact = @Contact(
				name="Kartik",
				email="kartik.nayak@capgemini.com"
		),
		license = @License(
				name = "Apache v2.0",
				url="http://abc.com"
		)),
		externalDocs = @ExternalDocumentation(

		description = "External Docs for employee management",
				url = "http://abc.co,"
))
public class EmployeeMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMgmtApplication.class, args);
	}

}
