package com.projectpizza.projectpizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class LoginPageController {

    @FXML
    public TextField phoneInput;
    @FXML
    public PasswordField passwordInput;
    @FXML


    private static final File accountDatabase = new File("accountDatabase.txt");
    public Text errorText;

    /**
     * Switches to new account screen.
     * @param event
     */
    @FXML
    protected void goToNewAccountPage(ActionEvent event) {
        try{
            Parent newAccountPageRoot = FXMLLoader.load(getClass().getResource("new-account-page.fxml"));
            Scene newAccountPageScene = new Scene(newAccountPageRoot, 800, 600);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(newAccountPageScene);
            stage.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Switches to menu screen.
     * @param event
     */
    public void goToMenu(ActionEvent event) {
        try{
            Parent menuPageSceneRoot = FXMLLoader.load(getClass().getResource("menu-page.fxml"));
            Scene menuPageScene = new Scene(menuPageSceneRoot, 800, 600);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(menuPageScene);
            stage.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calls the login method on the AccountHandler and gets a result based on the input entered into the text and password fields.
     * Also trims symbols from the phone number and then either goes to the menu page or gives the users an error message.
     * @param event
     */
    public void onLoginButtonPress(ActionEvent event) {
        String logInResult = AccountHandler.login(phoneInput.getText().replaceAll("\\D+",""), passwordInput.getText());
        if(logInResult.equals("Success")) {
            OrderHandler.readOrderDatabase();
            goToMenu(event);
        } else {
            errorText.setText(logInResult);
        }

    }

    /**
     * This just lets you hit the return key instead of having to click the login button when typing your account info in.
     * @param event
     */
    public void onPhoneReturnPress(ActionEvent event) {
        onLoginButtonPress(event);
    }

    /**
     * This just lets you hit the return key instead of having to click the login button when typing your account info in.
     * @param event
     */
    public void onPasswordReturnPress(ActionEvent event) {
        onLoginButtonPress(event);
    }
}
