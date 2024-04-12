package com.projectpizza.projectpizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {

    public void goToLoginPage(ActionEvent event) {
        try{
            Parent textEditorSceneRoot = FXMLLoader.load(getClass().getResource("login-page.fxml"));
            Scene textEditorScene = new Scene(textEditorSceneRoot);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(textEditorScene);
            stage.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void goToMenuPage(ActionEvent event) {
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

    public void goToOrderSummaryPage(ActionEvent event) {
        try{
            Parent textEditorSceneRoot = FXMLLoader.load(getClass().getResource("order-summary-page.fxml"));
            Scene textEditorScene = new Scene(textEditorSceneRoot);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(textEditorScene);
            stage.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void goToOrderListPage(ActionEvent event) {
        try{
            Parent textEditorSceneRoot = FXMLLoader.load(getClass().getResource("order-list-page.fxml"));
            Scene textEditorScene = new Scene(textEditorSceneRoot);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(textEditorScene);
            stage.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
