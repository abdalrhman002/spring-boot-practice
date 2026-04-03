package com.mujahid.spring_security_jwt_oauth2_demo.controller;


import com.mujahid.spring_security_jwt_oauth2_demo.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class UserController {


    // for experimental purpose no judge (:
    List<User> users = new ArrayList<>(
            List.of(new User(1,"aaa", "123"),
                    new User(2,"bbb", "123"))
    );


    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }


    @GetMapping("/users")
    public List<User> getUsers(){
        return users;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User userToAdd) {
        users.add(userToAdd);
        return userToAdd;
    }
}
