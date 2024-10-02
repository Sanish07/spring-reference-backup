package com.java_config;

import com.xml_config.Writer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookApplicationJava {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Writer writer = context.getBean(Writer.class);
        System.out.println(writer.write());
    }
}
