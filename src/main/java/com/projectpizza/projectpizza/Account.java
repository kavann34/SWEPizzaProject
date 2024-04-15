package com.projectpizza.projectpizza;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Account {
    private static final File accountDatabase = new File("accountDatabase.txt");
    private static int nextID = 0;
    private int AccountID;
    private String firstName;
    private String lastName;
    private String accountType;
    private String password;
    private String addressStreet;
    private String addressCity;
    private String addressState;
    private int  addressZip;
    private String phone;
    private String email;

    public Account(String firstName, String lastName, String password, String addressStreet, String addressCity, String addressState, int addressZip, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
        this.addressState = addressState;
        this.addressZip = addressZip;
        this.phone = phone;
        this.email = email;
    }

    public boolean addAccountToDatabase(String firstName, String lastName, String password, String addressStreet, String addressCity, String addressState, int addressZip, String phone, String email){
        if(accountDatabase != null) {
            try(FileWriter writer = new FileWriter(accountDatabase, true)) {
                writer.append(firstName + ","
                                + lastName + ","
                                + password + ","
                                + addressStreet + ","
                                + addressCity + ","
                                + addressState + ","
                                + addressZip + ","
                                + phone + ","
                                + email + "\n");
                return true;
            }catch(IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        Account.nextID = nextID;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public int getAddressZip() {
        return addressZip;
    }

    public void setAddressZip(int addressZip) {
        this.addressZip = addressZip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
