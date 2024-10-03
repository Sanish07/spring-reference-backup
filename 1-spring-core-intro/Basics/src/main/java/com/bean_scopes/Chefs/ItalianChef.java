package com.bean_scopes.Chefs;

import com.bean_scopes.Dishes.Dish;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Lazy
public class ItalianChef implements Chef{

    private Dish dish;

    public ItalianChef(@Qualifier("pizza") Dish dish){
        System.out.println("Italian Chef Bean Initialized.");
        this.dish = dish;
    }

    @Override
    public String cookFood() {
        return dish.getDishName()+", prepared by Italian Chef.";
    }
}
