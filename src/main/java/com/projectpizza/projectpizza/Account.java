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


    /**
     * Takes in all the account parameters and appends it to the accountDatabase file in a new line.
     *
     * @param phone
     * @param password
     * @param firstName
     * @param lastName
     * @param addressStreet
     * @param addressCity
     * @param addressState
     * @param addressZip
     * @param email
     * @return true if operation is successful.
     */
    public static boolean addAccountToDatabase(String phone, String password, String accountType, String firstName, String lastName, String addressStreet, String addressCity, String addressState, int addressZip, String email) {
        if (accountDatabase != null) {
            try (FileWriter writer = new FileWriter(accountDatabase, true)) {
                writer.append(phone + ","
                        + password + ","
                        + accountType + ","
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


    /**
     * Takes in the phone and password login credentials and scans the accountDatabase text file for a match.
     *
     * @param phone
     * @param password
     * @return accountType if login was successful, else "Invalid Password", "Account Does Not Exist", or "Error".
     */
    public static String login(String phone, String password) {
        try (Scanner scanner = new Scanner(accountDatabase)) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data[0].equals(phone)) {
                    if (data[1].equals(password)) {
                        return data[2];
                    }
                    else return "Invalid Password";
                    }
            }
            return "Account Does Not Exist";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "Error";
    }
    public static boolean updateAccount(String phone, String password, String accountType, String firstName, String lastName, String addressStreet, String addressCity, String addressState, int addressZip, String email){
        return true;
    }
}