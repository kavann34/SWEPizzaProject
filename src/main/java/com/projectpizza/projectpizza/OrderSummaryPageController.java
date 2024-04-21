package com.projectpizza.projectpizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

import static com.projectpizza.projectpizza.OrderHandler.readOrderDatabase;

public class OrderSummaryPageController {
    public void onLogoutButtonPress(ActionEvent event) {
        Session.setPhoneNumber("");
        try{
            Parent loginPageSceneRoot = FXMLLoader.load(getClass().getResource("login-page.fxml"));
            Scene loginPageScene = new Scene(loginPageSceneRoot, 800, 600);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(loginPageScene);
            stage.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }



    public void onMenuButtonPress(ActionEvent event) {
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

    //Pushes array to order summary in list view
    @FXML
    private TextArea orderTextArea;

    String[] test = {readOrderDatabase()}; //*done,Will be changed to read order's values once menu is complete

    @FXML
    public void initialize() {
        StringBuilder sb = new StringBuilder();
        for(String item: test) {
            sb.append(item + ", ");
        }
        sb.delete(sb.length()-2, sb.length());
        String s = sb.toString();
        orderTextArea.appendText(s);
        orderTextArea.setEditable(false);
        orderTextArea.setWrapText(true);
    }

}
