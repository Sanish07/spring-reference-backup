package com.loose.coupling;

import com.loose.coupling.Foods.Bread;
import com.loose.coupling.Foods.Food;

public class DogOwner {

    public static void main(String[] args) {
        Food food = new Bread(); //Food - interface, Bread - Implementation
        Dog dog = new Dog(food); //However object instantiation is still in hands of dev.
        // and code is breaking encapsulation
        System.out.println(dog.eat());
    }

}
