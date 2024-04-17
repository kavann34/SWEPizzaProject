package com.projectpizza.projectpizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderSummaryPageController {
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

    //Pushes array to order summary in list view
    @FXML
    private ListView<String> myListView;

    String[] test = {"one", "two", "three", "two", "three", "two", "three"}; //Will be changed to read order's values once menu is complete

    @FXML
    public void initialize() {
        myListView.setFocusTraversable(false);
        myListView.getItems().addAll(test);
    }

}
