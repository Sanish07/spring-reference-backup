package com.loose.coupling;

import com.loose.coupling.Foods.Food;

public class Dog{
    private Food food;

    public Dog(Food food){
        this.food = food; //No instantiation done
    }

    public String eat(){
        return food.eat();
    }
}
