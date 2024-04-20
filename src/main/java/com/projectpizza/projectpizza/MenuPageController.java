package com.projectpizza.projectpizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPageController {
    public Button addToOrderButton;
    public Button tenInchSizeButton;
    public Button thinCrustButton;
    public Button regularCrustButton;
    public Button deepDishCrustButton;
    public Button sixteenInchSizeButton;
    public Button twelveInchSizeButton;
    public Button fourteenInchSizeButton;
    public CheckBox extraCheeseCheckbox;
    public CheckBox pepperoniCheckbox;
    public CheckBox sausageCheckbox;
    public CheckBox mushroomsCheckbox;
    public CheckBox baconCheckbox;
    public CheckBox peppersCheckbox;
    public CheckBox pineappleCheckbox;
    public CheckBox spinachCheckbox;
    public CheckBox extraSauceCheckbox;
    public CheckBox onionsCheckbox;
    public CheckBox tomatoCheckbox;
    public CheckBox olivesCheckbox;
    public Button smallSizeDrinkButton;
    public Button mediumSizeDrinkButton;
    public Button largeSizeDrinkButton;
    public CheckBox spriteCheckbox;
    public CheckBox fantaCheckbox;
    public CheckBox cokeCheckbox;
    public CheckBox waterCheckbox;
    public CheckBox teaCheckbox;
    public CheckBox lemonadeCheckbox;

    public void goToMainPage(ActionEvent event) {
    }

    public void goToLoginPage(ActionEvent event) {
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


    public void goToOrderSummaryPage(ActionEvent event) {
        try{
            Parent orderSummarySceneRoot = FXMLLoader.load(getClass().getResource("order-summary-page.fxml"));
            Scene orderSummaryScene = new Scene(orderSummarySceneRoot);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(orderSummaryScene);
            stage.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void onAddToOrderPress(ActionEvent event) {
    }

    public void onLogoutButtonPress(ActionEvent event) {
    }
}
