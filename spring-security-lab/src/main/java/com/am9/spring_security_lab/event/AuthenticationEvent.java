package com.am9.spring_security_lab.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthenticationEvent {

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent event){
        log.info("Authentication success for user : {}",
                event.getAuthentication().getName());
    }

    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent event){
        log.error("Authentication failed for user : {} cause : {}",
                event.getAuthentication().getName(),
                event.getException().getMessage());
    }
}
