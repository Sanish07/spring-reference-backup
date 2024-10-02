package com.xml_config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("xml_config_1.xml");
        Writer writer = (Writer) context.getBean("writer");
        System.out.println(writer.write());
    }
}
