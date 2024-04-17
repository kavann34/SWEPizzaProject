package com.projectpizza.projectpizza;

import java.util.ArrayList;

public class Price {

    //Total cost of order
    public double totalCost(ArrayList<String> test) { //Will format to work with the order arraylist
        double total = 0;
        for (String item : test) {
            switch(item) {
                case "12\"" -> total += 12;
                case "14\"" -> total += 14;
                case "16\"" -> total += 16;
                case "Regular crust" -> total += 1;
                case "Thin crust", "Pepperoni" -> total += 0.5; //Will add other toppings
                default -> total += 0;
            };
        }
        return total;
    }

    //Cost of singular item
    public double cost(String item) {
        switch(item) {
            case "12\"" -> {
                return 12;
            }
            case "14\"" -> {
                return 14;
            }
            case "16\"" -> {
                return 16;
            }
            case "Regular crust" -> {
                return 1;
            }
            case "Thin crust", "Pepperoni" -> { //Will add other toppings
                return 0.5;
            }
            default -> {
                return 0;
            }
        }
    }
}

