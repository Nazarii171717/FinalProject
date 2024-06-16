package com.example.javaFx;

import customer.data.Customer;
import customer.data.RentalHistory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import parsingCSV.WorkWithJSON;

import java.io.IOException;

public class RentalRegistrationController {

    @FXML
    private TextArea addressField;

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
    private PasswordField newPasswordField;

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
            displayError(new InvalidAgeException().getMessage("Invalid age"));
        }
        else if (!validateData(name, surname, address, email, phoneNumber, login, password)) {
            displayError(new EmptyTextFieldException().getMessage("All fields must be filled"));
        }
        else if (password.contains(" ")) {
            displayError(new InvalidPasswordFormatException().getMessage("Password cannot contain spaces"));
        }
        if(!validateEmail(email)){
            displayError("Invalid email");
        }
        else if (!validatePhoneNumber(phoneNumber)) {
            displayError("Invalid phone number");
        }

        else {
            WorkWithJSON workWithJSON = new WorkWithJSON();
            workWithJSON.addCustomer(name, surname,Integer.parseInt(age), phoneNumber, email, address, login, password, null);
            Stage currentStage = (Stage) continueButton.getScene().getWindow();
            currentStage.close();
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(RentalApplication.class.getResource("rental-login.fxml"));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Rental Application");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
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
    private boolean validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("[0-9]+")) {
            return false;
        } else if (phoneNumber.length() != 9) {
            return false;
        } else {
            return true;
        }
    }

    private boolean validateEmail(String email) {
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            return false;
        } else {
            return true;
        }
    }

}

