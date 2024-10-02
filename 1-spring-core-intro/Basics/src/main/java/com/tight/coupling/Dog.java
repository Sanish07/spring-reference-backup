package com.tight.coupling;

public class Dog {
    private Pedigree pedigree;

    public Dog(){
        this.pedigree = new Pedigree(); //Instantiating object of another
        // class inside one. - Tight Coupling
    }

    public String eat(){
        return pedigree.eat();
    }
}
