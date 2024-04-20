package com.projectpizza.projectpizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
        try(Scanner sc = new Scanner(accountDatabase)) {
            String line;
            String[] split;
            while(sc.hasNextLine()) {
                line = sc.nextLine();
                split = line.split(",");
                if((phoneInput.getText().toString().equals(split[0])) && (passwordInput.getText().toString().equals(split[1]))) {
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

            }
        } catch (FileNotFoundException e) {
        }

    }
}
