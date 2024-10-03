package com.bean_scopes.Dishes;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("pizza")
@Lazy
public class Pizza implements Dish{

    public Pizza(){
        System.out.println("Pizza bean initialized.");
    }

    @Override
    public String getDishName() {
        return "Pizza";
    }
}
