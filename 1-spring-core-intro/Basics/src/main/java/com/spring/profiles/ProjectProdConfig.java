package com.spring.profiles;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.spring.profiles")
@PropertySource("classpath:profiles/application-prod.properties")
@Profile("prod")
public class ProjectProdConfig {
}
