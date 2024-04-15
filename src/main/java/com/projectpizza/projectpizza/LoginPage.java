package com.projectpizza.projectpizza;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPage extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("login-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Project Pizza");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
        //Account newaccount = new Account("Colin", "Pittman", "test", "address", "city", "state", 12345, "678-555-1234", "test@email.com");
        //newaccount.addAccountToDatabase("Colin", "Pittman", "test", "address", "city", "state", 12345, "678-555-1234", "test@email.com");

    }
}