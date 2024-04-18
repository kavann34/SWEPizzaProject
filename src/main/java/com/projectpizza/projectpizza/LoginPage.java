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
        //a method will be called here to  read in the saved orders in orderDatabase.txt

    }
}