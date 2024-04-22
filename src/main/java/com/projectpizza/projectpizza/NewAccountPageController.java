package com.projectpizza.projectpizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
public class NewAccountPageController {


    public PasswordField passwordInput;
    public PasswordField passwordConfirmationInput;
    public TextField phoneInput;
    public TextField addressStreetInput;
    public TextField firstNameInput;
    public TextField lastNameInput;
    public TextField addressCityInput;
    public TextField addressStateInput;
    public TextField addressZipInput;
    public Text passwordErrorText;

    /**
     * Reads all the entered information and writes the info to the accountDatabase text file.
     * Then goes back to the login page if no errors were given.
     * @param event
     */
    public void onSubmitButtonPress(ActionEvent event) {
        if(phoneInput.getText().isEmpty() ||
                lastNameInput.getText().isEmpty() ||
                passwordInput.getText().isEmpty() ||
                passwordConfirmationInput.getText().isEmpty() ||
                firstNameInput.getText().isEmpty() ||
                addressStreetInput.getText().isEmpty() ||
                addressCityInput.getText().isEmpty() ||
                addressStateInput.getText().isEmpty() ||
                addressZipInput.getText().isEmpty()) {
            passwordErrorText.setText("Please fill in all user information fields.");
            return;
        }
        if (!passwordInput.getText().equals(passwordConfirmationInput.getText())) {
            passwordErrorText.setText("Passwords do not match or are invalid.");
            return;
        }
        AccountHandler.addAccountToDatabase(phoneInput.getText().replaceAll("\\D+",""),
                passwordInput.getText(),
                firstNameInput.getText(),
                lastNameInput.getText(),
                addressStreetInput.getText(),
                addressCityInput.getText(),
                addressStateInput.getText(),
                addressZipInput.getText());
        Session.setPhoneNumber(phoneInput.getText().replaceAll("\\D+",""));

        try{
            Parent loginPageSceneRoot = FXMLLoader.load(getClass().getResource("login-page.fxml"));
            Scene loginPageScene = new Scene(loginPageSceneRoot);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(loginPageScene);
            stage.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns to the login page.
     * @param event
     */
    public void onBackButtonPress(ActionEvent event) {
        try{
            Parent loginPageSceneRoot = FXMLLoader.load(getClass().getResource("login-page.fxml"));
            Scene loginPageScene = new Scene(loginPageSceneRoot);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(loginPageScene);
            stage.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This just lets you hit the return key instead of having to click the login button when typing your account info in.
     * @param event
     */
    public void onPhoneReturnPress(ActionEvent event) {onSubmitButtonPress(event);
    }

    /**
     * This just lets you hit the return key instead of having to click the login button when typing your account info in.
     * @param event
     */
    public void onFirstNameReturnPress(ActionEvent event) {onSubmitButtonPress(event);
    }

    /**
     * This just lets you hit the return key instead of having to click the login button when typing your account info in.
     * @param event
     */
    public void onLastNameReturnPress(ActionEvent event) {onSubmitButtonPress(event);
    }

    /**
     * This just lets you hit the return key instead of having to click the login button when typing your account info in.
     * @param event
     */
    public void onPasswordConfirmationReturnPress(ActionEvent event) {onSubmitButtonPress(event);
    }

    /**
     * This just lets you hit the return key instead of having to click the login button when typing your account info in.
     * @param event
     */
    public void onPasswordReturnPress(ActionEvent event) {onSubmitButtonPress(event);
    }

    /**
     * This just lets you hit the return key instead of having to click the login button when typing your account info in.
     * @param event
     */
    public void onStreetReturnPress(ActionEvent event) {onSubmitButtonPress(event);
    }

    /**
     * This just lets you hit the return key instead of having to click the login button when typing your account info in.
     * @param event
     */
    public void onCityReturnPress(ActionEvent event) {onSubmitButtonPress(event);
    }

    /**
     * This just lets you hit the return key instead of having to click the login button when typing your account info in.
     * @param event
     */
    public void onStateReturnPress(ActionEvent event) {onSubmitButtonPress(event);
    }

    /**
     * This just lets you hit the return key instead of having to click the login button when typing your account info in.
     * @param event
     */
    public void onZipReturnPress(ActionEvent event) {onSubmitButtonPress(event);
    }
}
