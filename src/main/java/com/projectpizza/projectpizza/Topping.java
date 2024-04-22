package com.projectpizza.projectpizza;

/**
 * This class holds toppings, used to be stored in menu items if they are "Pizza".
 */
public class Topping {
    protected String name;

    public Topping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
