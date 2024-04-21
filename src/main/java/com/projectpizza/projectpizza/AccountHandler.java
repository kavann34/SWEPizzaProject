package com.projectpizza.projectpizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AccountHandler {
    private static final File accountDatabase = new File("accountDatabase.txt");

    public AccountHandler() {
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
     * @return true if operation is successful.
     */
    public static boolean addAccountToDatabase(String phone, String password, String firstName, String lastName, String addressStreet, String addressCity, String addressState, String addressZip) {
        if (accountDatabase != null) {
            try (FileWriter writer = new FileWriter(accountDatabase, true)) {
                writer.append(phone + ","
                        + password + ","
                        + firstName + ","
                        + lastName + ","
                        + addressStreet + ","
                        + addressCity + ","
                        + addressState + ","
                        + addressZip + "\n");
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
     * Also records current user in the Session class.
     * @param phone
     * @param password
     * @return "Success" if login was successful, else "Invalid Password", "Account Does Not Exist", or "Error".
     */
    public static String login(String phone, String password) {
        if(phone.equals("") || password.equals("")) {
            return "Please fill in both the username and password fields.";
        }
        try (Scanner scanner = new Scanner(accountDatabase)) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data[0].equals(phone)) {
                    if (data[1].equals(password)) {
                        Session.setPhoneNumber(data[0]);
                        return "Success";
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

    /**
     * Scans the accountDatabase file line by line recording the information, if it reaches a line with
     * the matching phone number, it replaces the line with the new info in the parameters, then
     * it continues scanning lines and recording until it reaches the end. Overwrites the database
     * with the updated version if it found the match, else it does nothing.
     * @param phone
     * @param password
     * @param firstName
     * @param lastName
     * @param addressStreet
     * @param addressCity
     * @param addressState
     * @param addressZip
     * @return true if update was successful.
     */
    public static boolean updateAccount(String phone, String password, String accountType, String firstName, String lastName, String addressStreet, String addressCity, String addressState, int addressZip, String email){
        StringBuilder updatedDatabase = new StringBuilder();
        boolean updatedResult = false;

        try (Scanner scanner = new Scanner(accountDatabase)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                if (data[0].equals(phone)) {
                    line = phone + "," + password + "," + lastName + "," + addressStreet + "," + addressCity + "," + addressState + "," + addressZip + "," + firstName + "," + email;
                    updatedResult = true;
                }

                updatedDatabase.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        if (updatedResult) {
            try (FileWriter writer = new FileWriter(accountDatabase, false)) {
                writer.write(updatedDatabase.toString());
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        return updatedResult;
    }

}