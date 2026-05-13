package com.am9.spring_security_lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug = true)
public class SpringSecurityLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityLabApplication.class, args);
	}

}
