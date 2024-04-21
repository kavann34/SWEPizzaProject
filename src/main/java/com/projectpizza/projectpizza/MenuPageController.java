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
    public static Order newOrder = new Order(Session.getPhoneNumber());
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

    public void onPizzaAddToOrderPress(ActionEvent event) {
        if (tenInchSizeRadio.isSelected() || twelveInchSizeRadio.isSelected() || fourteenInchSizeRadio.isSelected() || sixteenInchSizeRadio.isSelected()) {
            Toggle size = pizzaSize.getSelectedToggle();
            Toggle crust = crustType.getSelectedToggle();
            MenuItem newPizza = new MenuItem("Pizza", Integer.parseInt(size.getUserData().toString()), size.getUserData() + "\"", ((RadioButton) crust).getText());
            if (extraCheeseCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Extra Cheese"));
            }
            if (pepperoniCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Pepperoni"));
            }
            if (sausageCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Sausage"));
            }
            if (peppersCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Peppers"));
            }
            if (mushroomsCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Mushroom"));
            }
            if (baconCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Bacon"));
            }
            if (pineappleCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Pineapple"));
            }
            if (spinachCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Spinach"));
            }
            if (extraSauceCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Extra Sauce"));
            }
            if (onionsCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Onion"));
            }
            if (olivesCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Olive"));
            }
            if (tomatoCheckbox.isSelected()) {
                newPizza.toppings.add(new Topping("Tomato"));
            }
            newOrder.orderItems.add(newPizza);
        resetSelections();
        OrderHandler.writeOrderToDatabase(newOrder);
        }
    }
    public void onDrinkAddToOrderPress(ActionEvent event) {
        int price;
        String size;
        if (smallDrinkRadio.isSelected() || mediumDrinkRadio.isSelected() || largeDrinkRadio.isSelected()) {
            if(smallDrinkRadio.isSelected()) {
                price = 200;
                size = "Small";
            } else if (mediumDrinkRadio.isSelected()) {
                price = 300;
                size = "Medium";
            }else {
                price = 400;
                size = "Large";
            }
            if (spriteRadio.isSelected()) {
                newOrder.orderItems.add(new MenuItem("Drink",price,size, "Sprite"));
            }
            if (fantaRadio.isSelected()) {
                newOrder.orderItems.add(new MenuItem("Drink",price,size, "Fanta"));
            }
            if (cokeRadio.isSelected()) {
                newOrder.orderItems.add(new MenuItem("Drink",price,size, "Coke"));
            }
            if (waterRadio.isSelected()) {
                newOrder.orderItems.add(new MenuItem("Drink",price,size, "Water"));
            }
            if (teaRadio.isSelected()) {
                newOrder.orderItems.add(new MenuItem("Drink",price,size, "Tea"));
            }
            if (lemonadeRadio.isSelected()) {
                newOrder.orderItems.add(new MenuItem("Drink",price,size, "Lemonade"));
            }
        resetDrinkSelections();
        OrderHandler.writeOrderToDatabase(newOrder);
        }

        // Possibly a method to write to a file or database (not shown here)
        // OrderHandler.writeOrderToDatabase(newOrder);

        // StringBuilder drinkOrder = new StringBuilder();
        //
        // if (smallDrinkRadio.isSelected()) {
        //     drinkOrder.append("Small ");
        // } else if (mediumDrinkRadio.isSelected()) {
        //     drinkOrder.append("Medium ");
        // } else if (largeDrinkRadio.isSelected()) {
        //     drinkOrder.append("Large ");
        // }
        //
        // if (spriteCheckbox.isSelected()) {
        //     drinkOrder.append("Sprite, ");
        // }
        // if (fantaCheckbox.isSelected()) {
        //     drinkOrder.append("Fanta, ");
        // }
        // if (cokeCheckbox.isSelected()) {
        //     drinkOrder.append("Coke, ");
        // }
        // if (waterCheckbox.isSelected()) {
        //     drinkOrder.append("Water, ");
        // }
        // if (teaCheckbox.isSelected()) {
        //     drinkOrder.append("Tea, ");
        // }
        // if (lemonadeCheckbox.isSelected()) {
        //     drinkOrder.append("Lemonade, ");
        // }
        //
        // if (drinkOrder.length() > 0) {
        //     drinkOrder.setLength(drinkOrder.length() - 2);
        // }
        //
        // writeDrinkToFile(drinkOrder.toString());
        // resetDrinkSelections();
    }
    //public void writePizzaToFile(String size, String toppings) {
    //    try (BufferedWriter writer = new BufferedWriter(new FileWriter("orderDatabase.txt", true))) {
    //        writer.write("Size: " + size + ", Toppings: " + toppings);
    //        writer.newLine();
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //}

    // public static void setOrderItems(String size, String toppings) {
    //     order.add(size);
    //     String[] split;
    //     split = toppings.split(", ");
    //     for (String item : split) {
    //         order.add(item);
    //     }
    //     order.add("\n");
    // }

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
}
