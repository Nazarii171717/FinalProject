package com.example.javaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import vehicle.data.Vehicle;

import java.util.ArrayList;
import java.util.Vector;

public class RentalVehicleListViewController {

    @FXML
    private ListView<ArrayList<Vehicle>> carListView;

    @FXML
    private Label priceLabel;

    @FXML
    private Button reserveButton;

    @FXML
    private Label resultsLabel;

    @FXML
    private Label vehicleDescLabel;

    @FXML
    private Label vehicleIntroLabel;

    @FXML
    void fromDateSelected(ActionEvent event) {

    }

    @FXML
    void reserveButtonClicked(ActionEvent event) {

    }

    @FXML
    void toDateSelected(ActionEvent event) {

    }


}
