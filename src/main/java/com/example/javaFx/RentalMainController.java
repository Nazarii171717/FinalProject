package com.example.javaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RentalMainController {

    @FXML
    private MenuItem accountMenuItem;

    @FXML
    private Label idUserLabel;

    @FXML
    private CheckBox checkBoxAutomatic;

    @FXML
    private CheckBox checkBoxBlack;

    @FXML
    private CheckBox checkBoxBlue;

    @FXML
    private CheckBox checkBoxCamper;

    @FXML
    private CheckBox checkBoxConvertible;

    @FXML
    private CheckBox checkBoxCoupe;

    @FXML
    private CheckBox checkBoxCruiser;

    @FXML
    private CheckBox checkBoxDiesel;

    @FXML
    private CheckBox checkBoxElectric;

    @FXML
    private CheckBox checkBoxElectricM;

    @FXML
    private CheckBox checkBoxGreen;

    @FXML
    private CheckBox checkBoxGrey;

    @FXML
    private CheckBox checkBoxHatchback;

    @FXML
    private CheckBox checkBoxMBlack;

    @FXML
    private CheckBox checkBoxMBlue;

    @FXML
    private CheckBox checkBoxMGreen;

    @FXML
    private CheckBox checkBoxMGrey;

    @FXML
    private CheckBox checkBoxMOrange;

    @FXML
    private CheckBox checkBoxMRed;

    @FXML
    private CheckBox checkBoxMSilver;

    @FXML
    private CheckBox checkBoxMWhite;

    @FXML
    private CheckBox checkBoxMYellow;

    @FXML
    private CheckBox checkBoxManual;

    @FXML
    private CheckBox checkBoxMinivan;

    @FXML
    private CheckBox checkBoxOrange;

    @FXML
    private CheckBox checkBoxPetrol;

    @FXML
    private CheckBox checkBoxPickup;

    @FXML
    private CheckBox checkBoxRed;

    @FXML
    private CheckBox checkBoxRetro;

    @FXML
    private CheckBox checkBoxSUV;

    @FXML
    private CheckBox checkBoxScooter;

    @FXML
    private CheckBox checkBoxSedan;

    @FXML
    private CheckBox checkBoxSilver;

    @FXML
    private CheckBox checkBoxSport;

    @FXML
    private CheckBox checkBoxStreet;

    @FXML
    private CheckBox checkBoxTouring;

    @FXML
    private CheckBox checkBoxWhite;

    @FXML
    private CheckBox checkBoxYellow;

    @FXML
    private Label colorsLabel;

    @FXML
    private Label engineLabel;

    @FXML
    private TextField fromYearField;

    @FXML
    private TextField fromYearMTextField;

    @FXML
    private Menu helpMenu;

    @FXML
    private MenuItem historyMenuItem;

    @FXML
    private MenuItem invoiceMenuItem;

    @FXML
    private Label labelBrand;

    @FXML
    private Label labelMColors;

    @FXML
    private Label labelMotoYear;

    @FXML
    private Label labelMotorBrand;

    @FXML
    private Label labelMotorType;

    @FXML
    private Label labelTypes;

    @FXML
    private Label labelYear;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Button searchButtonMotorcycle;

    @FXML
    private Button searchCarButton;

    @FXML
    private CheckBox streetBoxChopper;

    @FXML
    private Tab tabCar;

    @FXML
    private Tab tabMotorcycle;

    @FXML
    private TabPane tabPane;

    @FXML
    private TextField textFieldBrands;

    @FXML
    private TextField textFieldBrandsM;

    @FXML
    private TextField toYearField;

    @FXML
    private TextField toYearMTextField;

    @FXML
    private Label transmissionLabel;

    @FXML
    private Menu userMenu;

    @FXML
    void accountClicked(ActionEvent event) {


    }

    @FXML
    void historyClicked(ActionEvent event) {

    }

    @FXML
    void invoiceClicked(ActionEvent event) {

    }

    @FXML
    void searchCarButtonClicked(ActionEvent event) {
       //TODO: implement switch to rental-list.fxml after clicking searchCarButton and applying filters
        FXMLLoader loader = new FXMLLoader(getClass().getResource("rental-list.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RentalVehicleListViewController controller = loader.getController();
        Stage stage = new Stage();
        stage.setTitle("Results");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    void searchMotocycleButtonClicked(ActionEvent event) {
        //TODO: implement switch to rental-list.fxml after clicking searchCarButton and applying filters
        FXMLLoader loader = new FXMLLoader(getClass().getResource("rental-list.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RentalVehicleListViewController controller = loader.getController();
        Stage stage = new Stage();
        stage.setTitle("Results");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
        //TODO: Set the list of vehicles depending on their types and availability
    }

    public void setIdUserLabel(String idUser) {
        idUserLabel.setText(idUser);
    }
}
