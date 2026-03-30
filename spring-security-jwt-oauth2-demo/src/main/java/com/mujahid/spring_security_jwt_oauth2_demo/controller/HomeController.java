package com.mujahid.spring_security_jwt_oauth2_demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
public class HomeController {

    @GetMapping
    public String sayHi(HttpServletRequest request){
        return "Hi am9! " + request.getSession().getId();
    }

}
