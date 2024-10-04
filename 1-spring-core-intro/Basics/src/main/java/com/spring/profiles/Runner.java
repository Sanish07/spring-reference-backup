package com.spring.profiles;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "prod"); //Setting profile programmatically
        // - Switch this value corresponding to different spring profiles
        //OR Edit the configuration -> Environment variables -> Set a new environment variable
        //spring.profiles.active=prod and then run the application with newly set env variable

        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectDevConfig.class, ProjectQaConfig.class, ProjectProdConfig.class);
        ProjectPhase projectPhase = context.getBean(ProjectPhase.class);
        System.out.println(projectPhase);
    }
}
