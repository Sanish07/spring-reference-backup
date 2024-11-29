package org.sanish.multi_auth_prov_demo.security.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.sanish.multi_auth_prov_demo.security.managers.CustomAuthenticationManager;
import org.sanish.multi_auth_prov_demo.security.pojos.ApiKeyAuthentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class ApiKeyFilter extends OncePerRequestFilter {

    private final String key;

    public ApiKeyFilter(String key) {
        this.key = key;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        CustomAuthenticationManager customAuthenticationManager = new CustomAuthenticationManager(key);

        var requestKey = request.getHeader("x-api-key");

        if(requestKey == null || requestKey.equals("null")) {
            filterChain.doFilter(request, response);
        }

        ApiKeyAuthentication apiKeyAuthentication = new ApiKeyAuthentication(requestKey);

        try {
            var auth = customAuthenticationManager.authenticate(apiKeyAuthentication);
            if(auth.isAuthenticated()){
                SecurityContextHolder.getContext().setAuthentication(auth);
                filterChain.doFilter(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } catch (AuthenticationException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

    }
}
