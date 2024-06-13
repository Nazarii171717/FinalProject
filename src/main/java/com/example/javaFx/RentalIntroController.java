package com.example.javaFx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class RentalIntroController {
    @FXML
    private Label introLabel;

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passwdTextField;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    @FXML
    private Label signUpLabel;

    @FXML
    void signInButtonClicked(ActionEvent event) {
        if (!validateData(loginTextField.getText(), passwdTextField.getText())) {
            displayError("Login or password cannot be empty");
        }
        else {
            //TODO: if data is correct, open main window
        }
    }

    @FXML
    void signUpButtonClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("rental-new-account.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RentalRegistrationController controller = loader.getController();
        Stage stage = new Stage();
        stage.setTitle("Registration");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
        Stage currentStage = (Stage) signUpButton.getScene().getWindow();
        currentStage.close();
    }

    private boolean validateData(String login, String password) {
        if (login.isEmpty() || password.isEmpty()) {
            return false;
        }
        return true;
    }
    private void displayError(String errorMessage) {
        try {
            FXMLLoader errorLoader = new FXMLLoader(getClass().getResource("rental-error.fxml"));
            Parent root = errorLoader.load();

            RentalErrorController controller = errorLoader.getController();
            controller.setErrorDescLabel(errorMessage);

            Stage stage = new Stage();
            stage.setTitle("Error");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
