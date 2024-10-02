package com.annotation_config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawApplication {
    public static void main(String[] args) {
        /* For XML Config */
//        ApplicationContext context = new ClassPathXmlApplicationContext("xml_config_drawapp_2.xml");
//        Painter painter = (Painter)context.getBean("painter");
//        System.out.println(painter.paint());

        /* For Java Config */
//        ApplicationContext context = new AnnotationConfigApplicationContext(DrawAppJavaConfig.class);
//        Painter painter = context.getBean(Painter.class);
//        System.out.println(painter.paint());

        /* Annotation Config */
        ApplicationContext context = new AnnotationConfigApplicationContext(DrawAppAnnoConfig.class);
        Painter painter = context.getBean(Painter.class);
        System.out.println(painter.paint());
    }
}
