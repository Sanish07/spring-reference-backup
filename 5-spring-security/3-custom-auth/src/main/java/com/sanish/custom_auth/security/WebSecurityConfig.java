package com.sanish.custom_auth.security;

import com.sanish.custom_auth.security.filters.CustomAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//We will be creating key based authentication mechanism for custom auth type
@Configuration
public class WebSecurityConfig {

    private final CustomAuthenticationFilter customAuthenticationFilter;

    @Autowired
    public WebSecurityConfig(CustomAuthenticationFilter customAuthenticationFilter){
        this.customAuthenticationFilter = customAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .addFilterAt(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(auth ->
                        auth.anyRequest().authenticated()) // **
                .build();
    }
    // ** - Note 1 -  .authorizeRequests().anyRequest().authenticated was deprecated after Spring security 6.1
    // ** - Note 2 - This line is telling us that, for every request made our app requires authentication done
}
