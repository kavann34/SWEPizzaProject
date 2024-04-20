package com.projectpizza.projectpizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPageController {
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
    public CheckBox spriteCheckbox;
    public CheckBox fantaCheckbox;
    public CheckBox cokeCheckbox;
    public CheckBox waterCheckbox;
    public CheckBox teaCheckbox;
    public CheckBox lemonadeCheckbox;
    public RadioButton tenInchSizeRadio;
    public ToggleGroup pizzaSize;
    public RadioButton twelveInchSizeRadio;
    public RadioButton fourteenInchSizeRadio;
    public RadioButton sixteenInchSizeRadio;
    public RadioButton smallDrinkRadio;
    public ToggleGroup drinkSize;
    public RadioButton mediumDrinkRadio;
    public RadioButton largeDrinkRadio;
    public ToggleGroup crustType;
    public RadioButton thinCrustRadio;
    public RadioButton regularCrustRadio;
    public RadioButton deepDishRadio;

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
    regularCrustRadio.fire();
    }

    public void onLogoutButtonPress(ActionEvent event) {

    }

    public void onTenInchRadioSelect(ActionEvent event) {
        regularCrustRadio.fire();
    }

    public void onTwelveInchRadioSelect(ActionEvent event) {
        regularCrustRadio.fire();
    }

    public void onFourteenInchRadioSelect(ActionEvent event) {
        regularCrustRadio.fire();
    }

    public void onSixteenInchRadioPress(ActionEvent event) {
        regularCrustRadio.fire();
    }
}
