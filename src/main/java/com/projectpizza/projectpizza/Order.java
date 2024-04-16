package com.projectpizza.projectpizza;

import java.util.ArrayList;

public class Order {
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

    public ArrayList<MenuItem> orderItems = new ArrayList<>();
}
