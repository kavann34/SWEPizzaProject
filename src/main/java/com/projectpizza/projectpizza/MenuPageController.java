package com.projectpizza.projectpizza;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
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

    public static ArrayList<String> order = new ArrayList<>();

    private void initialize() {
        pizzaSize = new ToggleGroup();
        tenInchSizeRadio.setToggleGroup(pizzaSize);
        twelveInchSizeRadio.setToggleGroup(pizzaSize);
        fourteenInchSizeRadio.setToggleGroup(pizzaSize);
        sixteenInchSizeRadio.setToggleGroup(pizzaSize);

        crustType = new ToggleGroup();
        regularCrustRadio.setToggleGroup(crustType);
        deepDishRadio.setToggleGroup(crustType);
        thinCrustRadio.setToggleGroup(crustType);

        drinkSize = new ToggleGroup();
        smallDrinkRadio.setToggleGroup(drinkSize);
        mediumDrinkRadio.setToggleGroup(drinkSize);
        largeDrinkRadio.setToggleGroup(drinkSize);
    public void initialize() {
        tenInchSizeRadio.setUserData("10\"");
        twelveInchSizeRadio.setUserData("12\"");
        fourteenInchSizeRadio.setUserData("14\"");
        sixteenInchSizeRadio.setUserData("16\"");
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

    public void onPizzaAddToOrderPress(ActionEvent event) { //WIP
        //if(tenInchSizeRadio.isPressed() || twelveInchSizeRadio.isPressed() || fourteenInchSizeRadio.isPressed() || sixteenInchSizeRadio.isPressed()) {
        //    Order newOrder = new Order(Session.getPhoneNumber());
        //    Toggle size = pizzaSize.getSelectedToggle();
        //    MenuItem newPizza = new MenuItem("Pizza", size.getUserData(),
        //}
        String size = "";
        if (tenInchSizeRadio.isSelected()) {
            size = "10 inch";
        } else if (twelveInchSizeRadio.isSelected()) {
            size = "12 inch";
        } else if (fourteenInchSizeRadio.isSelected()) {
            size = "14 inch";
        } else if (sixteenInchSizeRadio.isSelected()) {
            size = "16 inch";
        }

        String toppings = "";
        if (extraCheeseCheckbox.isSelected()) {
            toppings += "Extra Cheese, ";
        }
        if (pepperoniCheckbox.isSelected()) {
            toppings += "Pepperoni, ";
        }
        if (sausageCheckbox.isSelected()) {
            toppings += "Sausage, ";
        }
        if (peppersCheckbox.isSelected()) {
            toppings += "Peppers, ";
        }
        if (mushroomsCheckbox.isSelected()) {
            toppings += "Mushrooms, ";
        }
        if (baconCheckbox.isSelected()) {
            toppings += "Bacon, ";
        }
        if (pineappleCheckbox.isSelected()) {
            toppings += "Pineapple, ";
        }
        if (spinachCheckbox.isSelected()) {
            toppings += "Spinach, ";
        }
        if (extraSauceCheckbox.isSelected()) {
            toppings += "Extra Sauce, ";
        }
        if (extraCheeseCheckbox.isSelected()) {
            toppings += "Extra Cheese, ";
            if (onionsCheckbox.isSelected()) {
                toppings += "Onions, ";
            }
            if (tomatoCheckbox.isSelected()) {
                toppings += "Tomatoes, ";
            }
            if (olivesCheckbox.isSelected()) {
                toppings += "Olives, ";
            }

            if (!toppings.isEmpty()) {
                toppings = toppings.substring(0, toppings.length() - 2);
            }

            setOrderItems(size, toppings);
            resetSelections();
        }
    }

    public void writePizzaToFile(String size, String toppings) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("orderDatabase.txt", true))) {
            writer.write("Size: " + size + ", Toppings: " + toppings);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setOrderItems(String size, String toppings) {
        order.add(size);
        String[] split;
        split = toppings.split(", ");
        for(String item:split) {
            order.add(item);
        }
        order.add("\n");
    }

    public void resetSelections() {
        pizzaSize.selectToggle(null);
        crustType.selectToggle(null);
        drinkSize.selectToggle(null);
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

    public void onDrinkAddToOrderPress(ActionEvent event) {
        StringBuilder drinkOrder = new StringBuilder();

        if (smallDrinkRadio.isSelected()) {
            drinkOrder.append("Small ");
        } else if (mediumDrinkRadio.isSelected()) {
            drinkOrder.append("Medium ");
        } else if (largeDrinkRadio.isSelected()) {
            drinkOrder.append("Large ");
        }

        if (spriteCheckbox.isSelected()) {
            drinkOrder.append("Sprite, ");
        }
        if (fantaCheckbox.isSelected()) {
            drinkOrder.append("Fanta, ");
        }
        if (cokeCheckbox.isSelected()) {
            drinkOrder.append("Coke, ");
        }
        if (waterCheckbox.isSelected()) {
            drinkOrder.append("Water, ");
        }
        if (teaCheckbox.isSelected()) {
            drinkOrder.append("Tea, ");
        }
        if (lemonadeCheckbox.isSelected()) {
            drinkOrder.append("Lemonade, ");
        }

        if (drinkOrder.length() > 0) {
            drinkOrder.setLength(drinkOrder.length() - 2);
        }

        writeDrinkToFile(drinkOrder.toString());
        resetDrinkSelections();
    }

    public void resetDrinkSelections() {
        smallDrinkRadio.setSelected(false);
        mediumDrinkRadio.setSelected(false);
        largeDrinkRadio.setSelected(false);

        spriteCheckbox.setSelected(false);
        fantaCheckbox.setSelected(false);
        cokeCheckbox.setSelected(false);
        waterCheckbox.setSelected(false);
        teaCheckbox.setSelected(false);
        lemonadeCheckbox.setSelected(false);
    }

    public void writeDrinkToFile(String drinkOrder) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("orderDatabase.txt", true))) {
            writer.write("Drink: " + drinkOrder);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
