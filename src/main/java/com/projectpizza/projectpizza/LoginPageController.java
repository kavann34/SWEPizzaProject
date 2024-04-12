package com.projectpizza.projectpizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageController {

    @FXML
    protected void goToHomePage(ActionEvent event) {
        try{
            Parent textEditorSceneRoot = FXMLLoader.load(getClass().getResource("main-page.fxml"));
            Scene textEditorScene = new Scene(textEditorSceneRoot);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(textEditorScene);
            stage.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
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
}
