package com.projectpizza.projectpizza;

/**
 * This class is used for tracking the current user's ID, which is the phone number,
 * and their current and latest order.
 */
public class Session {
    private static String phoneNumber;
    private static Order currentOrder;

    public static Order getCurrentOrder() {
        return currentOrder;
    }

    public static void setCurrentOrder(Order currentOrder) {
        Session.currentOrder = currentOrder;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static void setPhoneNumber(String phoneNumber) {
        Session.phoneNumber = phoneNumber;
    }
}
