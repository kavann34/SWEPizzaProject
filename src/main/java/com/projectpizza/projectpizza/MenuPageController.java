package com.projectpizza.projectpizza;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

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

    public static ArrayList<String> order = new ArrayList<>();
    public RadioButton teaRadio;
    public RadioButton lemonadeRadio;
    public RadioButton waterRadio;
    public RadioButton cokeRadio;
    public RadioButton fantaRadio;
    public ToggleGroup drinkSelection;
    public RadioButton spriteRadio;

    public void initialize() {

        tenInchSizeRadio.setUserData(10);
        twelveInchSizeRadio.setUserData(12);
        fourteenInchSizeRadio.setUserData(14);
        sixteenInchSizeRadio.setUserData(16);

    }

    public void goToOrderSummaryPage(ActionEvent event) {
        try {
            Parent orderSummarySceneRoot = FXMLLoader.load(getClass().getResource("order-summary-page.fxml"));
            Scene orderSummaryScene = new Scene(orderSummarySceneRoot);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(orderSummaryScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void onDrinkAddToOrderPress(ActionEvent event) {
        if (Session.getCurrentOrder() == null) {
            Session.setCurrentOrder(new Order(Session.getPhoneNumber()));
        }
            int price;
            String size;
            if (smallDrinkRadio.isSelected() || mediumDrinkRadio.isSelected() || largeDrinkRadio.isSelected()) {
                if (smallDrinkRadio.isSelected()) {
                    price = 200;
                    size = "Small";
                } else if (mediumDrinkRadio.isSelected()) {
                    price = 300;
                    size = "Medium";
                } else {
                    price = 400;
                    size = "Large";
                }
                if (spriteRadio.isSelected()) {
                    Session.getCurrentOrder().orderItems.add(new MenuItem("Drink", price, size, "Sprite"));
                }
                if (fantaRadio.isSelected()) {
                    Session.getCurrentOrder().orderItems.add(new MenuItem("Drink", price, size, "Fanta"));
                }
                if (cokeRadio.isSelected()) {
                    Session.getCurrentOrder().orderItems.add(new MenuItem("Drink", price, size, "Coke"));
                }
                if (waterRadio.isSelected()) {
                    Session.getCurrentOrder().orderItems.add(new MenuItem("Drink", price, size, "Water"));
                }
                if (teaRadio.isSelected()) {
                    Session.getCurrentOrder().orderItems.add(new MenuItem("Drink", price, size, "Tea"));
                }
                if (lemonadeRadio.isSelected()) {
                    Session.getCurrentOrder().orderItems.add(new MenuItem("Drink", price, size, "Lemonade"));
                }
                resetDrinkSelections();
                OrderHandler.writeOrderToDatabase(Session.getCurrentOrder());
            }
        }

    public void resetPizzaSelections() {
        tenInchSizeRadio.setSelected(false);
        twelveInchSizeRadio.setSelected(false);
        fourteenInchSizeRadio.setSelected(false);
        sixteenInchSizeRadio.setSelected(false);
        thinCrustRadio.setSelected(false);
        regularCrustRadio.setSelected(false);
        deepDishRadio.setSelected(false);
        extraCheeseCheckbox.setSelected(false);
        pepperoniCheckbox.setSelected(false);
        sausageCheckbox.setSelected(false);
        mushroomsCheckbox.setSelected(false);
        baconCheckbox.setSelected(false);
        peppersCheckbox.setSelected(false);
        pineappleCheckbox.setSelected(false);
        spinachCheckbox.setSelected(false);
        extraSauceCheckbox.setSelected(false);
        onionsCheckbox.setSelected(false);
        tomatoCheckbox.setSelected(false);
        olivesCheckbox.setSelected(false);
    }

    public void onLogoutButtonPress(ActionEvent event) {
        Session.setPhoneNumber("");
        try {
            Parent loginPageSceneRoot = FXMLLoader.load(getClass().getResource("login-page.fxml"));
            Scene loginPageScene = new Scene(loginPageSceneRoot);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(loginPageScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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



    public void resetDrinkSelections() {
        smallDrinkRadio.setSelected(false);
        mediumDrinkRadio.setSelected(false);
        largeDrinkRadio.setSelected(false);

        spriteRadio.setSelected(false);
        fantaRadio.setSelected(false);
        cokeRadio.setSelected(false);
        waterRadio.setSelected(false);
        teaRadio.setSelected(false);
        lemonadeRadio.setSelected(false);
    }

    public void writeDrinkToFile(String drinkOrder) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("orderDatabase.txt", true))) {
            writer.write("Drink: " + drinkOrder);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onPizzaAddToOrderPress(ActionEvent event) {
            if (Session.getCurrentOrder() == null) {
                Session.setCurrentOrder(new Order(Session.getPhoneNumber()));
        }
        if (tenInchSizeRadio.isSelected() || twelveInchSizeRadio.isSelected() || fourteenInchSizeRadio.isSelected() || sixteenInchSizeRadio.isSelected()) {
            Toggle size = pizzaSize.getSelectedToggle();
            Toggle crust = crustType.getSelectedToggle();
            MenuItem newPizza = new MenuItem("Pizza", Integer.parseInt(size.getUserData().toString())*100, size.getUserData() + "\"", ((RadioButton) crust).getText());
            if (extraCheeseCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Extra Cheese"));
                newPizza.setPrice(newPizza.getPrice()+ 50);
            }
            if (pepperoniCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Pepperoni"));
                newPizza.setPrice(newPizza.getPrice()+ 50);
            }
            if (sausageCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Sausage"));
                newPizza.setPrice(newPizza.getPrice()+ 50);
            }
            if (peppersCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Peppers"));
                newPizza.setPrice(newPizza.getPrice()+ 50);
            }
            if (mushroomsCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Mushroom"));
                newPizza.setPrice(newPizza.getPrice()+ 50);
            }
            if (baconCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Bacon"));
                newPizza.setPrice(newPizza.getPrice()+ 50);
            }
            if (pineappleCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Pineapple"));
                newPizza.setPrice(newPizza.getPrice()+ 50);
            }
            if (spinachCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Spinach"));
                newPizza.setPrice(newPizza.getPrice()+ 50);
            }
            if (extraSauceCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Extra Sauce"));
                newPizza.setPrice(newPizza.getPrice()+ 50);
            }
            if (onionsCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Onion"));
                newPizza.setPrice(newPizza.getPrice()+ 50);
            }
            if (olivesCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Olive"));
                newPizza.setPrice(newPizza.getPrice()+ 50);
            }
            if (tomatoCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Tomato"));
                newPizza.setPrice(newPizza.getPrice()+ 50);
            }
            Session.getCurrentOrder().orderItems.add(newPizza);
            resetPizzaSelections();
            OrderHandler.writeOrderToDatabase(Session.getCurrentOrder());
        }
    }
}

