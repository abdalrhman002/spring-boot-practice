package com.am9.Oauth_lab.controller;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecureController {

    @GetMapping("/secure")
    public String secure(Authentication authentication){
        if (authentication instanceof UsernamePasswordAuthenticationToken)
            System.out.println("Username & password authentication token");
        else if (authentication instanceof OAuth2AuthenticationToken)
            System.out.println("OAuth2 authentication token");
        return "secure.html";
    }
}
