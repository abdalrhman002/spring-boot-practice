package com.am9.spring_security_lab.config;

import com.am9.spring_security_lab.filter.CsrfCookieFilter;
import com.am9.spring_security_lab.filter.TempEmailFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Profile("!production")
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        CsrfTokenRequestAttributeHandler csrfHandler = new CsrfTokenRequestAttributeHandler();

        http.sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        );
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/register").permitAll()
                .anyRequest().authenticated());
        http.csrf(csrfConfig -> csrfConfig
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .csrfTokenRequestHandler(csrfHandler)
                .ignoringRequestMatchers("/register"));

        http.addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                        .addFilterBefore(new TempEmailFilter(), UsernamePasswordAuthenticationFilter.class);

        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

//    @Bean
//    public CompromisedPasswordChecker compromisedPasswordChecker(){
//        return new HaveIBeenPwnedRestApiPasswordChecker();
//    }


}
