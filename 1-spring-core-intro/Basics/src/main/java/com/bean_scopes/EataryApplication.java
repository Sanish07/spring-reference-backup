package com.bean_scopes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EataryApplication {
    public static void main(String[] args) {
        //You will see only those beans which have been annotated with @Lazy
        //would print init statement in console, which have been called/referenced.
        ApplicationContext context = new AnnotationConfigApplicationContext(EataryAppConfig.class);
        Customer customer = context.getBean(Customer.class);
        System.out.println(customer.getFood());

        Customer customer1 = context.getBean(Customer.class);
        Customer customer2 = context.getBean(Customer.class);

        System.out.println(customer1+" "+customer1.getChefObj()); //Test scope combination by changing
        System.out.println(customer2+" "+customer2.getChefObj()); //scopes of Customer and ItalianChef classes.
        //Customer - Depending Class, ItalianChef - Dependency Class
        //4 Cases for this scenario.

    }
}
