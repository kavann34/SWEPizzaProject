package com.projectpizza.projectpizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LoginPageController {

    @FXML
    public TextField phoneInput;
    @FXML
    public PasswordField passwordInput;
    @FXML
    public TextArea errorText;

    private static final File accountDatabase = new File("accountDatabase.txt");

    @FXML
    protected void goToNewAccountPage(ActionEvent event) {
        try{
            Parent textEditorSceneRoot = FXMLLoader.load(getClass().getResource("new-account-page.fxml"));
            Scene textEditorScene = new Scene(textEditorSceneRoot);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(textEditorScene);
            stage.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void goToMenu(ActionEvent event) {
        try{
            Parent textEditorSceneRoot = FXMLLoader.load(getClass().getResource("menu-page.fxml"));
            Scene textEditorScene = new Scene(textEditorSceneRoot);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(textEditorScene);
            stage.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void logIn(ActionEvent event) {
        String logInResult = AccountHandler.login(phoneInput.getText().toString(), passwordInput.getText().toString());
        if(logInResult.equals("Success")) {
            goToMenu(event);
        } else {
            errorText.setText(logInResult);
        }

    }
}
