package com.spring_properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CatchBugsApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CatchBugsAppConfig.class);
        BugCatcher bugCatcher = context.getBean(BugCatcher.class);
        System.out.println(bugCatcher.catchBug());
    }
}
