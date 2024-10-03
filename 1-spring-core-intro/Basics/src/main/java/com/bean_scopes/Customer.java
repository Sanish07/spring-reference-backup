package com.bean_scopes;

import com.bean_scopes.Chefs.Chef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Customer {
    private Chef chef;

    @Autowired
    public Customer(@Qualifier("italianChef") Chef chef){
        this.chef = chef;
    }

    public String getFood(){
        return chef.cookFood();
    }

    public Chef getChefObj(){
        return chef;
    }
}
