package com.am9.spring_security_lab.filter;

import com.am9.spring_security_lab.constant.AppConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

public class JwtTokenGenerationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null){
            Environment env = getEnvironment();
            if (env != null){
                String key = env.getProperty(AppConstants.JWT_SECRET_KEY,
                        AppConstants.DEFAULT_JWT_SECRET_KEY);
                Long expTime = AppConstants.DEFAULT_JWT_EXP_TIME;
                SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
                Date now = new Date();
                String jwt = Jwts.builder().issuer("SecLab")
                        .subject("JWT Token")
                        .claim("username", authentication.getName())
                        .claim("authorities", authentication.getAuthorities()
                                .stream().map(GrantedAuthority::getAuthority)
                                .collect(Collectors.joining(",")))
                        .issuedAt(now)
                        .expiration(new Date(now.getTime() + expTime))
                        .signWith(secretKey)
                        .compact();
                response.setHeader(AppConstants.JWT_HEADER, jwt);
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {

        // Form login
        boolean isFormLogin = request.getServletPath().equals("/login")
                && "POST".equalsIgnoreCase(request.getMethod());

        // Basic Auth
        String authHeader = request.getHeader("Authorization");
        boolean isBasicAuth = authHeader != null
                && authHeader.startsWith("Basic ");

        return !isFormLogin && !isBasicAuth;
    }
}
