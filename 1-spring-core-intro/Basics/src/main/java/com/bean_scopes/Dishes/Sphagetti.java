package com.bean_scopes.Dishes;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("sphagetti")
@Lazy
public class Sphagetti implements Dish{

    public Sphagetti(){
        System.out.println("Spaghetti bean initialized.");
    }

    @Override
    public String getDishName() {
        return "Sphagetti";
    }
}
