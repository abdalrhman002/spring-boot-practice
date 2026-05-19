package com.am9.Oauth_lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug = true)
public class OauthLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthLabApplication.class, args);
	}

}
