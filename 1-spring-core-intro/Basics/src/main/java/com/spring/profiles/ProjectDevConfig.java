package com.spring.profiles;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.spring.profiles")
@PropertySource("classpath:profiles/application-dev.properties")
@Profile("dev")
public class ProjectDevConfig {

}
