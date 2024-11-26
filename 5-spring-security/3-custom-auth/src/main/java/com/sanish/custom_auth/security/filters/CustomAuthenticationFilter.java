package com.sanish.custom_auth.security.filters;


import com.sanish.custom_auth.security.authentication.CustomAuthentication;
import com.sanish.custom_auth.security.manager.CustomAuthenticationManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {
    //We are extending OncePerRequestFilter class instead of implementing Filter interface
    //having doFilter method because we want to ensure our Auth filter is called only once
    //for 1 request

    private final CustomAuthenticationManager customAuthenticationManager;

    @Autowired
    public CustomAuthenticationFilter(CustomAuthenticationManager customAuthenticationManager) {
        this.customAuthenticationManager = customAuthenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        //1. Create an authentication object
        //2. Pass the auth object to Auth manager
        //3. Get back auth from manager
        //4. if object is authenticated then send request to next filter in chain

        String key = String.valueOf(request.getHeader("key")); //Get 'key' header from the http request
        CustomAuthentication auth = new CustomAuthentication(false,key); //1

        var manager_response = customAuthenticationManager.authenticate(auth); // 2 and 3

        if(manager_response.isAuthenticated()) { //4
            SecurityContextHolder.getContext().setAuthentication(manager_response);
            //1- After header key matches with internal key, we update the security context as user auth passed.
            //2- This line help us in setting authentication and identify which type
            //user actually authenticated and further can be processed by authorization filter

            filterChain.doFilter(request, response);
            //When authentication worked, we send request to next filter in filter chain
        }
        //We can later add else part which throws UserAuthenticationFailedException or something like that
    }
}
