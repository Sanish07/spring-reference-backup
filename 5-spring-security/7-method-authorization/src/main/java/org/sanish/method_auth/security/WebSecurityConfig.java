package org.sanish.method_auth.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(httpSecurityHttpBasicConfigurer -> {})
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/hello").hasAuthority("write") //This route now has both endpoint and method autho
                        .anyRequest().permitAll() //Lets allow all requests to be accessible by anyone to check method autho
                );
        //Note 1 : Method authorization takes precedence over endpoint authorization
        //Note 2 : We can have both endpoint authorization and method authorization for a route

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsService = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("sanish")
                .password(passwordEncoder().encode("12345"))
                .authorities("read", "write")
                .build();

        var user2 = User.withUsername("nicholas")
                .password(passwordEncoder().encode("12345"))
                .authorities("read")
                .build();

        var user3 = User.withUsername("robert")
                .password(passwordEncoder().encode("12345"))
                .build();

        userDetailsService.createUser(user1);
        userDetailsService.createUser(user2);
        userDetailsService.createUser(user3);

        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
