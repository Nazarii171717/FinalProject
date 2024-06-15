package com.example.javaFx;
import customer.data.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import parsingCSV.WorkWithJSON;

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
            return;
        }

        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("rental-main.fxml"));
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            RentalMainController controller = loader.getController();
            controller.setUsernameLabel(loginTextField.getText());
            Stage stage = new Stage();
            stage.setTitle("Rental Application");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            Stage currentStage = (Stage) signInButton.getScene().getWindow();
            currentStage.close();
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
            displayError(new EmptyTextFieldException().getMessage("One or more fields are empty"));
            return false;
        }
        else {
            Customer customer = getCustomer(login);
            if(!customer.getId().matches(login) || !customer.getPassword().matches(password)){
                displayError(new NotMatchingDataException().getMessage("Invalid login or password!"));
                return false;
            }
            return true;
        }
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
    private Customer getCustomer(String login){
        WorkWithJSON workWithJSON = new WorkWithJSON();
        if(workWithJSON.findCustomerById(login)==null){
            displayError(new NotMatchingDataException().getMessage("Invalid login or password!")+" Customer not found!");
        }
        return workWithJSON.findCustomerById(login);
    }

}
