package com.am9.spring_security_lab.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

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
        // Form log in
        if ("POST".equalsIgnoreCase(request.getMethod())
                && "/login".equals(request.getServletPath())) {
            return request.getParameter("username");
        }

        // Basic Auth
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader != null && authHeader.startsWith("Basic ")){
            String base64Credential = authHeader.substring(6);
            String decoded = new String(Base64.getDecoder().decode(base64Credential));
            return decoded.split(":")[0];
        }
        return null;
    }
}
