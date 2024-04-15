package com.projectpizza.projectpizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Account {
    private static final File accountDatabase = new File("accountDatabase.txt");

    public Account() {
    }


    public static boolean addAccountToDatabase(String firstName, String lastName, String password, String addressStreet, String addressCity, String addressState, int addressZip, String phone, String email) {
        if (accountDatabase != null) {
            try (FileWriter writer = new FileWriter(accountDatabase, true)) {
                writer.append(phone + ","
                        + password + ","
                        + lastName + ","
                        + addressStreet + ","
                        + addressCity + ","
                        + addressState + ","
                        + addressZip + ","
                        + firstName + ","
                        + email + "\n");
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
    public static boolean login(String phone, String password) {
        try (Scanner scanner = new Scanner(accountDatabase)) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data[0].equals(phone) && data[1].equals(password)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}