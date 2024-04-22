package com.projectpizza.projectpizza;

import java.util.ArrayList;

public class MenuItem {
    protected ArrayList<Topping> toppings = new ArrayList<>();
    protected String name;
    protected int price;
    protected String size;
    protected String type;

    public int getPrice() {
        return price;
    }

    public MenuItem(String name, int price, String size, String type) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder item = new StringBuilder();
        if(getName().equals("Pizza")) {
            item.append(getSize() + " - " + getType() + " - " + getName() + "\t..." + "$" + getPriceForToString() + "\n");
            for (Topping topping : toppings) {
                item.append("\t+" + topping + "\t\t..." + "+$0.50" + "\n");
            }
        }
        else {
            item.append(getSize() + " - " + getType() + " - " + getName() + "\t\t...$" + getPriceForToString() + "\n");
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

    public String getPriceForToString() {
        int dollars = price/100;
        int cents = price % 100;
        return dollars + "." + cents;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
