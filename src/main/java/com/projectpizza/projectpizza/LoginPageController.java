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

    public void onLoginButtonPress(ActionEvent event) {
        String logInResult = AccountHandler.login(phoneInput.getText().toString(), passwordInput.getText().toString());
        if(logInResult.equals("Success")) {
            goToMenu(event);
        } else {
            errorText.setText(logInResult);
        }

    }
}
