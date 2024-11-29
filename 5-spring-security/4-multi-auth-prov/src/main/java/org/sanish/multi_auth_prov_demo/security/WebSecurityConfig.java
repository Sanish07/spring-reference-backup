package org.sanish.multi_auth_prov_demo.security;

import org.sanish.multi_auth_prov_demo.security.filters.ApiKeyFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class WebSecurityConfig {

    @Value("${app-security.api-secret-key}")
    private String key;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(httpBasic ->{}) //httpBasic will use default filter provided by Spring security
                .addFilterBefore(new ApiKeyFilter(key), BasicAuthenticationFilter.class) //Adding api key filter before basic auth, order in this case won't matter much
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        return http.build();
    }
}
/*
addFilterBefore: Your filter will execute before the specified filter.class.
addFilterAfter: Your filter will execute after the specified filter.class.
addFilterAt: Your filter will take the exact position of the specified filter, essentially replacing it.
*/
