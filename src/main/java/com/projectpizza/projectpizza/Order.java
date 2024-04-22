package com.projectpizza.projectpizza;

import java.util.ArrayList;

public  class Order {
    private int total;
    private String phone;
    public ArrayList<MenuItem> orderItems = new ArrayList<>();

    public String getTotal() {
        int dollars = total/100;
        int cents = total % 100;
        return dollars + "." + cents;
    }

    public void updateTotal() {
        this.total = 0;
        for (MenuItem item : orderItems ) {
            total += item.price + item.toppings.size()*50;
        }
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder();
        for (MenuItem item : orderItems) {
            orderDetails.append(item);
        }
        updateTotal();
        orderDetails.append("\t\t\t\t\t\t...Total $" + getTotal());
        return orderDetails.toString();

    }

    public Order(String phone) {
        this.phone = phone;
    }

}
