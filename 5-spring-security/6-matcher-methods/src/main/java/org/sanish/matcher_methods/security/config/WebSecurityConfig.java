package org.sanish.matcher_methods.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(httpSecurityHttpBasicConfigurer -> {})
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/start","/end").hasAuthority("write") //For /start and /end route a user need to have 'write' authority
                        .requestMatchers(HttpMethod.POST,"/hello").hasAuthority("write") //Hello POST is only permitted for users with 'write'
                        .requestMatchers("/hello").authenticated() //For hello route user needs only to be authenticated
                        .requestMatchers("/public/**").permitAll() //Allow /public prefix routes(with all methods - GET, POST, etc) available without authentication
                )
                .csrf(AbstractHttpConfigurer::disable);//Not to do at any cost in real world apps
                 // We are disabling csrf to test POST route authorization

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var uds = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("sanish")
                .password(passwordEncoder().encode("12345"))
                .authorities("read")
                .build();

        var user2 = User.withUsername("leo")
                .password(passwordEncoder().encode("1010"))
                .authorities("read","write")
                .build();

        uds.createUser(user1);
        uds.createUser(user2);

        return uds;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
