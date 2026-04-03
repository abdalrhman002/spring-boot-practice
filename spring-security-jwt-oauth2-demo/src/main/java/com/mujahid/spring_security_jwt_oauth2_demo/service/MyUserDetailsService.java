package com.mujahid.spring_security_jwt_oauth2_demo.service;

import com.mujahid.spring_security_jwt_oauth2_demo.entity.User;
import com.mujahid.spring_security_jwt_oauth2_demo.entity.UserPrincipal;
import com.mujahid.spring_security_jwt_oauth2_demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserRepo repo;

    @Autowired
    public MyUserDetailsService(UserRepo repo){
        this.repo = repo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return new UserPrincipal(user);
    }
}
