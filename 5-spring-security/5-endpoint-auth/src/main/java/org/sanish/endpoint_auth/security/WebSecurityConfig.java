package org.sanish.endpoint_auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(httpSecurityHttpBasicConfigurer -> {})
                .authorizeHttpRequests((auth) -> auth    //Endpoint level authorization
                        .requestMatchers("/demo").hasAuthority("write")
                        .anyRequest().access(new WebExpressionAuthorizationManager("isAuthenticated() and hasAuthority('read')")))
        ;
        return http.build();
    }

    /* Endpoint authorization is all about:
    1. Matcher methods : anyRequest(), **NEW** requestMatchers() -> [previously - mvcMatchers(), antMatchers(), regexMatchers()]
    2. Authorization rules : authenticated(), permitAll(), denyAll(), hasAuthority(), hasRole()
                             access()
     */

    //auth.anyRequest().authenticated() - all routes (anyRequest()) are accessible to authenticated user.
    //auth.anyRequest().permitAll() - all routes are accessible to authenticated/non-authenticated users, but not with the wrong user/password
    //auth.anyRequest().hasAuthority("read") - all routes are accessible to user with 'read' authority
    //auth.anyRequest().hasAnyAuthority("read", "write") - all routes are accessible to user with 'read' or 'write' authority
    /* .access(new WebExpressionAuthorizationManager("isAuthenticated() and hasAuthority('read')"))
     - Access all routes to a user which is authen. and has read permission (uses SpEl inside the object) */
    //.requestMatchers("/demo").hasAuthority("write") - demo route is accessible to users with write authority

    @Bean
    public UserDetailsService userDetailsService() {
        var uds = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("sanish")
                .password(passwordEncoder().encode("12345"))
                .authorities("read")
                //For roles, authorities("ROLE_ADMIN") OR roles("ADMIN"), both the ways work and equivalent to each other
                //As best practice, use roles() one.
                .build();

        var user2 = User.withUsername("Leo")
                .password(passwordEncoder().encode("10"))
                .authorities("write")
                .build();

        uds.createUser(user1);
        uds.createUser(user2);

        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
