package com.tight.coupling;

public class DogOwner {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog.eat());
    }
}
