package org.sanish.multi_auth_prov_demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(httpBasic ->{}) //httpBasic will use default filter provided by Spring security
                .authorizeHttpRequests(auth ->
                        auth.anyRequest().authenticated());

        return http.build();
    }
}
