package com.example.javaFx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.SneakyThrows;


import java.io.IOException;

public class RentalApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RentalApplication.class.getResource("rental-login.fxml"));
        Parent root = fxmlLoader.load();
        stage.setTitle("Rental Application");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

}
