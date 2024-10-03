package com.bean_scopes.Dishes;

import org.springframework.stereotype.Component;

@Component
public class Pizza implements Dish{

    @Override
    public String getDishName() {
        return "Pizza";
    }
}
