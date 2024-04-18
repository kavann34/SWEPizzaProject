package com.projectpizza.projectpizza;

import java.util.ArrayList;

public class Order {
    private int total;

    public String getTotal() {
        int dollars = total/100;
        int cents = dollars % total;
        return dollars + "." + cents;
    }

    public void updateTotal(int total) {
        for (MenuItem item : orderItems ) {
            total += item.price;
            if (!item.toppings.isEmpty()) {
            for (Topping topping : item.toppings) {
                total += 50;
            }
            }
        }
    }

    public ArrayList<MenuItem> orderItems = new ArrayList<>();
    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder();
        for (MenuItem item : orderItems) {
            orderDetails.append(item);
        }
        return orderDetails.toString();
    }

    public Order() {
    }

}
