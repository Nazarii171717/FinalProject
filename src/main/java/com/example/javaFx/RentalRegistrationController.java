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

public class RentalRegistrationController {

    @FXML
    private TextField addressField;

    @FXML
    private TextField ageField;

    @FXML
    private Label ageLabel;

    @FXML
    private Button continueButton;

    @FXML
    private TextField emailField;

    @FXML
    private Label introLabel;

    @FXML
    private TextField nameField;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField newLoginField;

    @FXML
    private TextField newPasswordField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField surnameField;

    @FXML
    private Label surnameLabel;

    @FXML
    void continueButtonClicked(ActionEvent event) {
        String login = newLoginField.getText();
        String password = newPasswordField.getText();
        String name = nameField.getText();
        String surname = surnameField.getText();
        String age = ageField.getText();
        String address = addressField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();



        if (!validateAge(age)) {
            displayError("Age is invalid");
        } else if (!validateData(name, surname, address, email, phoneNumber, login, password)) {
            displayError("One or more fields are empty");
        } else {
            //TODO: If data is correct, proceed with further processing
        }


    }
    private boolean validateAge(String age) {
        if (!age.matches("[0-9]+")) {
            return false;
        } else if (Integer.parseInt(age) < 18 || Integer.parseInt(age) > 75) {
            return false;
        } else {
            return true;
        }
    }
    private boolean validateData(String name, String surname, String address, String email, String phoneNumber, String login, String password) {
        if (name.isEmpty() || surname.isEmpty() || address.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || login.isEmpty() || password.isEmpty()) {
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

