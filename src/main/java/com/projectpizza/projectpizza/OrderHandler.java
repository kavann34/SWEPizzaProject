package com.projectpizza.projectpizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OrderHandler {
    private static final File orderDatabase = new File("orderDatabase.txt");

    /**
     * Takes in an order and writes all the information to the database text file  with markers for
     * where orders, toppings, and order ends.
     * @param order
     * @return
     */
    public static boolean writeOrderToDatabase(Order order) {
        if (orderDatabase != null) {
            try (FileWriter writer = new FileWriter(orderDatabase, true)) {
                writer.append("StartOrder\n");
                writer.append(Session.getPhoneNumber() + "\n");
                for (MenuItem item : order.orderItems) {
                    StringBuilder itemEntry = new StringBuilder();
                    itemEntry.append(item.getSize() + "\", " + item.getName() + ", " + item.getType() + ", " + item.getPrice());

                    if (!item.toppings.isEmpty() && item.getName().equalsIgnoreCase("Pizza")) {
                        itemEntry.append("\nToppings:");
                        for (Topping topping : item.toppings) {
                            itemEntry.append(topping.getName() + ",");
                        }
                        itemEntry.deleteCharAt(itemEntry.length() - 1);
                    }
                    writer.append(itemEntry.toString() + "\n");
                }
                writer.append("EndOrder\n");
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    /**
     * To be called when the user logs in, goes down the orderDatabase text file
     * updating the current order with the latest version that it finds matching the phone
     * number of the current user Session's phone number. It instantiates everything again so that
     * it can be read into the order summary page again when the user logs back in.
     */
    public static void readOrderDatabase() {
        try (Scanner sc = new Scanner(orderDatabase)) {
            Order currentOrder = null;
            Order latestValidOrder = null;
            boolean orderFound = false;
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.equals("StartOrder")) {
                    currentOrder = new Order(Session.getPhoneNumber());
                    orderFound = false;
                }
                else if (line.equals("EndOrder")) {
                    if (orderFound && currentOrder != null) {
                        currentOrder.updateTotal();
                        latestValidOrder = currentOrder;
                    }
                    orderFound = false;
                    currentOrder = null;
                }
                else if (currentOrder != null && line.equals(Session.getPhoneNumber())) {
                    orderFound = true;
                }
                else if (orderFound && currentOrder != null && !line.isEmpty()) {
                    if (line.startsWith("Toppings:")) {
                        String toppingsLine = line.substring("Toppings:".length());
                        String[] toppings = toppingsLine.split(",");
                        MenuItem lastItem = currentOrder.orderItems.get(currentOrder.orderItems.size() - 1);
                        for (String topping : toppings) {
                            lastItem.toppings.add(new Topping(topping.trim()));
                        }
                    } else {
                        String[] menuItemAttributes = line.split(", ");
                        if (menuItemAttributes.length >= 4) {
                            String size = menuItemAttributes[0].replace("\"", "");
                            String name = menuItemAttributes[1];
                            String type = menuItemAttributes[2];
                            int price = Integer.parseInt(menuItemAttributes[3]);
                            MenuItem item = new MenuItem(name, price, size, type);
                            currentOrder.orderItems.add(item);
                        }
                    }
                }
            }
            if (latestValidOrder != null) {
                Session.setCurrentOrder(latestValidOrder);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
