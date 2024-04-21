package com.projectpizza.projectpizza;

import java.util.ArrayList;

public class MenuItem {
    protected ArrayList<Topping> toppings = new ArrayList<>();
    protected String name;
    protected int price;

    public MenuItem(String name, int price, String size, String type) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.type = type;
    }

    protected String size;
    protected String type;

    @Override
    public String toString() {
        StringBuilder item = new StringBuilder();
        if(getName().equals("Pizza")) {
            item.append(getSize() + " - " + getType() + " - " + getName() + "\t" + getPrice() + "\n");
            for (Topping topping : toppings) {
                item.append("\t+" + topping + "\n");
            }
        }
        else {
            item.append(getSize() + " - " + getType() + " - " + getName() + "\n");
        }
        return item.toString();
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
