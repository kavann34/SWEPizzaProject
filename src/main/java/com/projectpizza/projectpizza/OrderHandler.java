package com.projectpizza.projectpizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OrderHandler {
    private static final File orderDatabase = new File("orderDatabase.txt");
    public static boolean createOrder(){
        //this could be a method that takes in parameters from the MenuPageController that reads the selected options
        //and instantiates everything, not sure yet until I can see how the menu page is handled
        return true;
    }
    public static boolean writeOrderToDatabase(Order order){
        if (orderDatabase != null) {
            try (FileWriter writer = new FileWriter(orderDatabase, true)) {
                writer.append("" + order);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
    public static String readOrderDatabase(){
        try(Scanner sc = new Scanner(orderDatabase)) {
            String line;
            String[] split;
            while(sc.hasNextLine()) {
                line = sc.nextLine();
                split = line.split(",");

            }
        } catch (FileNotFoundException e) {
        }
        return null;
    }
}
