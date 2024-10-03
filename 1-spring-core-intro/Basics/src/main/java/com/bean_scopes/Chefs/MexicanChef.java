package com.bean_scopes.Chefs;

import com.bean_scopes.Dishes.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MexicanChef implements Chef{

    private Dish dish;

    @Autowired
    public MexicanChef(@Qualifier("sphagetti") Dish dish){
        this.dish = dish;
    }

    @Override
    public String cookFood() {
        return dish.getDishName()+", prepared by Mexican Chef.";
    }
}
