package com.am9.spring_security_lab.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class TempEmailFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {


        String email = extractEmail(request);

        if (email != null && email.contains("temp")){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write(
                    "{\"error\": \"Access denied: email not allowed\"}"
            );
            return;
        }

        filterChain.doFilter(request, response);

    }

    private String extractEmail(HttpServletRequest request) {
        // To do
        return "";
    }
}
