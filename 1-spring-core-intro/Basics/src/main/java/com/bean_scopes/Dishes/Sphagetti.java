package com.bean_scopes.Dishes;

import org.springframework.stereotype.Component;

@Component
public class Sphagetti implements Dish{

    @Override
    public String getDishName() {
        return "Sphagetti";
    }
}
