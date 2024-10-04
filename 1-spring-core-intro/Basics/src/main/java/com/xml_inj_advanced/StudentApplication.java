package com.xml_inj_advanced;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("xml_config_inj_adv.xml");
        Student student = context.getBean(Student.class);
        System.out.println(student);
    }
}
