package com.bean_scopes.Chefs;

import com.bean_scopes.Dishes.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class MexicanChef implements Chef{

    private Dish dish;

    @Autowired
    public MexicanChef(@Qualifier("sphagetti") Dish dish){
        System.out.println("Mexican Chef Bean Initialized.");
        this.dish = dish;
    }

    @Override
    public String cookFood() {
        return dish.getDishName()+", prepared by Mexican Chef.";
    }
}
