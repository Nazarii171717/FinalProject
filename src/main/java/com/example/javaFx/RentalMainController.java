package com.example.javaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RentalMainController {

    @FXML
    private Tab accountTab;

    @FXML
    private CheckBox alfaRomeoCheckBox;

    @FXML
    private CheckBox astonMartinCheckBox;

    @FXML
    private CheckBox audiCheckBox;

    @FXML
    private CheckBox automaticCheckBox;

    @FXML
    private CheckBox bentleyCheckBox;

    @FXML
    private CheckBox blackCheckBox;

    @FXML
    private CheckBox blueCheckBox;

    @FXML
    private CheckBox bmwCheckBox;

    @FXML
    private Label brandModelLabel;

    @FXML
    private TitledPane brands;

    @FXML
    private CheckBox brandsCheckBox;

    @FXML
    private CheckBox cadillacCheckBox;

    @FXML
    private CheckBox camperCheckBox;

    @FXML
    private Label carSearchInfoLabel;

    @FXML
    private CheckBox chevroletCheckBox;

    @FXML
    private CheckBox chryslerCheckBox;

    @FXML
    private CheckBox citroenCheckBox;

    @FXML
    private TitledPane colors;

    @FXML
    private CheckBox colorsCheckBox;

    @FXML
    private CheckBox convertibleCheckBox;

    @FXML
    private CheckBox coupeCheckBox;

    @FXML
    private DatePicker dateFromPicker;

    @FXML
    private DatePicker dateToPicker;

    @FXML
    private Label descLabel;

    @FXML
    private CheckBox dieselCheckBox;

    @FXML
    private CheckBox dodgeCheckBox;

    @FXML
    private CheckBox ducatiCheckBox;

    @FXML
    private CheckBox electricCheckBox;

    @FXML
    private CheckBox ferrariCheckBox;

    @FXML
    private CheckBox fiatCheckBox;

    @FXML
    private AnchorPane filterPane;

    @FXML
    private TitledPane filters;

    @FXML
    private CheckBox filtersCheckBox;

    @FXML
    private CheckBox fordCheckBox;

    @FXML
    private TitledPane fuel;

    @FXML
    private CheckBox fuelCheckBox;

    @FXML
    private CheckBox grayCheckBox;

    @FXML
    private CheckBox greenCheckBox;

    @FXML
    private CheckBox harleyDavidsonCheckBox;

    @FXML
    private CheckBox hatchbackCheckBox;

    @FXML
    private Tab historyTab;

    @FXML
    private CheckBox hondaCheckBox;

    @FXML
    private CheckBox hybridCheckBox;

    @FXML
    private CheckBox hyundaiCheckBox;

    @FXML
    private CheckBox jaguarCheckBox;

    @FXML
    private CheckBox jeepCheckBox;

    @FXML
    private CheckBox kawasakiCheckBox;

    @FXML
    private CheckBox kiaCheckBox;

    @FXML
    private CheckBox lamborghiniCheckBox;

    @FXML
    private CheckBox landRoverCheckBox;

    @FXML
    private CheckBox manualCheckBox;

    @FXML
    private CheckBox maseratiCheckBox;

    @FXML
    private CheckBox mazdaCheckBox;

    @FXML
    private CheckBox mercedesCheckBox;

    @FXML
    private CheckBox minivanCheckBox;

    @FXML
    private CheckBox motorcycleCheckBox;

    @FXML
    private CheckBox nissanCheckBox;

    @FXML
    private CheckBox opelCheckBox;

    @FXML
    private CheckBox orangeCheckBox;

    @FXML
    private CheckBox petrolCheckBox;

    @FXML
    private CheckBox peugeotCheckBox;

    @FXML
    private CheckBox pickupCheckBox;

    @FXML
    private CheckBox porscheCheckBox;

    @FXML
    private CheckBox price0CheckBox;

    @FXML
    private CheckBox price100CheckBox;

    @FXML
    private CheckBox price150CheckBox;

    @FXML
    private CheckBox price200CheckBox;

    @FXML
    private CheckBox price250CheckBox;

    @FXML
    private CheckBox price300CheckBox;

    @FXML
    private CheckBox price350CheckBox;

    @FXML
    private CheckBox price400CheckBox;

    @FXML
    private Label priceLabel;

    @FXML
    private TitledPane pricePerDay;

    @FXML
    private CheckBox pricePerDayCheckBox;

    @FXML
    private CheckBox purpleCheckBox;

    @FXML
    private CheckBox redCheckBox;

    @FXML
    private CheckBox renaultCheckBox;

    @FXML
    private Button rentButton;

    @FXML
    private Tab rentTab;

    @FXML
    private Label resultLabel;

    @FXML
    private AnchorPane resultPane;

    @FXML
    private ListView<?> resultsList;

    @FXML
    private CheckBox rollsRoyceCheckBox;

    @FXML
    private Button searchButton;

    @FXML
    private CheckBox sedanCheckBox;

    @FXML
    private CheckBox silverCheckBox;

    @FXML
    private CheckBox subaruCheckBox;

    @FXML
    private CheckBox suvCheckBox;

    @FXML
    private CheckBox suzukiCheckBox;

    @FXML
    private CheckBox suzukiMotorcyclesCheckBox;

    @FXML
    private CheckBox teslaCheckBox;

    @FXML
    private CheckBox toyotaCheckBox;

    @FXML
    private TitledPane transmission;

    @FXML
    private CheckBox transmissionCheckBox;

    @FXML
    private TitledPane typesVehicles;

    @FXML
    private CheckBox typesVehiclesCheckBox;

    @FXML
    private Label usernameLabel;

    @FXML
    private CheckBox volkswagenCheckBox;

    @FXML
    private CheckBox volvoCheckBox;

    @FXML
    private CheckBox whiteCheckBox;

    @FXML
    private CheckBox winnebagoCheckBox;

    @FXML
    private CheckBox yamahaCheckBox;

    @FXML
    private TitledPane year;

    @FXML
    private CheckBox year2019CheckBox;

    @FXML
    private CheckBox year2020CheckBox;

    @FXML
    private CheckBox year2021CheckBox;

    @FXML
    private CheckBox year2022CheckBox;

    @FXML
    private CheckBox year2023CheckBox;

    @FXML
    private CheckBox year2024CheckBox;

    @FXML
    private CheckBox yearCheckBox;

    @FXML
    private CheckBox yellowCheckBox;

    @FXML
    void ItemClicked(MouseEvent event) {

    }

    @FXML
    void alfaRomeoSelected(ActionEvent event) {

    }

    @FXML
    void astonMartinSelected(ActionEvent event) {

    }

    @FXML
    void audiSelected(ActionEvent event) {

    }

    @FXML
    void automaticSelected(ActionEvent event) {

    }

    @FXML
    void bentleySelected(ActionEvent event) {

    }

    @FXML
    void blackSelected(ActionEvent event) {

    }

    @FXML
    void blueSelected(ActionEvent event) {

    }

    @FXML
    void bmwSelected(ActionEvent event) {

    }

    @FXML
    void brandsSelected(ActionEvent event) {

    }

    @FXML
    void cadillacSelected(ActionEvent event) {

    }

    @FXML
    void camperSelected(ActionEvent event) {

    }

    @FXML
    void chevroletSelected(ActionEvent event) {

    }

    @FXML
    void chryslerSelected(ActionEvent event) {

    }

    @FXML
    void citroenSelected(ActionEvent event) {

    }

    @FXML
    void colorsSelected(ActionEvent event) {

    }

    @FXML
    void convertibleSelected(ActionEvent event) {

    }

    @FXML
    void coupeSelected(ActionEvent event) {

    }

    @FXML
    void dateFromSelected(ActionEvent event) {

    }

    @FXML
    void dateToSelected(ActionEvent event) {

    }

    @FXML
    void dieselSelected(ActionEvent event) {

    }

    @FXML
    void dodgeSelected(ActionEvent event) {

    }

    @FXML
    void ducatiSelected(ActionEvent event) {

    }

    @FXML
    void electricSelected(ActionEvent event) {

    }

    @FXML
    void ferrariSelected(ActionEvent event) {

    }

    @FXML
    void fiatSelected(ActionEvent event) {

    }

    @FXML
    void filtersSelected(ActionEvent event) {

    }

    @FXML
    void fordSelected(ActionEvent event) {

    }

    @FXML
    void fuelSelected(ActionEvent event) {

    }

    @FXML
    void graySelected(ActionEvent event) {

    }

    @FXML
    void greenSelected(ActionEvent event) {

    }

    @FXML
    void harleyDavidsonSelected(ActionEvent event) {

    }

    @FXML
    void hatchbackSelected(ActionEvent event) {

    }

    @FXML
    void hondaSelected(ActionEvent event) {

    }

    @FXML
    void hybridSelected(ActionEvent event) {

    }

    @FXML
    void hyundaiSelected(ActionEvent event) {

    }

    @FXML
    void jaguarSelected(ActionEvent event) {

    }

    @FXML
    void jeepSelected(ActionEvent event) {

    }

    @FXML
    void kawasakiSelected(ActionEvent event) {

    }

    @FXML
    void kiaSelected(ActionEvent event) {

    }

    @FXML
    void lamborghiniSelected(ActionEvent event) {

    }

    @FXML
    void landRoverSelected(ActionEvent event) {

    }

    @FXML
    void manualSelected(ActionEvent event) {

    }

    @FXML
    void maseratiSelected(ActionEvent event) {

    }

    @FXML
    void mazdaSelected(ActionEvent event) {

    }

    @FXML
    void mercedesSelected(ActionEvent event) {

    }

    @FXML
    void minivanSelected(ActionEvent event) {

    }

    @FXML
    void motorcycleSelected(ActionEvent event) {

    }

    @FXML
    void nissanSelected(ActionEvent event) {

    }

    @FXML
    void opelSelected(ActionEvent event) {

    }

    @FXML
    void orangeSelected(ActionEvent event) {

    }

    @FXML
    void petrolSelected(ActionEvent event) {

    }

    @FXML
    void peugeotSelected(ActionEvent event) {

    }

    @FXML
    void pickupSelected(ActionEvent event) {

    }

    @FXML
    void porscheSelected(ActionEvent event) {

    }

    @FXML
    void price0Selected(ActionEvent event) {

    }

    @FXML
    void price100Selected(ActionEvent event) {

    }

    @FXML
    void price150Selected(ActionEvent event) {

    }

    @FXML
    void price200Selected(ActionEvent event) {

    }

    @FXML
    void price250Selected(ActionEvent event) {

    }

    @FXML
    void price300Selected(ActionEvent event) {

    }

    @FXML
    void price350Selected(ActionEvent event) {

    }

    @FXML
    void price400Selected(ActionEvent event) {

    }

    @FXML
    void pricePerDaySelected(ActionEvent event) {

    }

    @FXML
    void purpleSelected(ActionEvent event) {

    }

    @FXML
    void redSelected(ActionEvent event) {

    }

    @FXML
    void renaultSelected(ActionEvent event) {

    }

    @FXML
    void rentButtonClicked(ActionEvent event) {

    }

    @FXML
    void rollsRoyceSelected(ActionEvent event) {

    }

    @FXML
    void searchButtonClicked(ActionEvent event) {

    }

    @FXML
    void sedanSelected(ActionEvent event) {

    }

    @FXML
    void silverSelected(ActionEvent event) {

    }

    @FXML
    void subaruSelected(ActionEvent event) {

    }

    @FXML
    void suvSelected(ActionEvent event) {

    }

    @FXML
    void suzukiMotorcyclesSelected(ActionEvent event) {

    }

    @FXML
    void suzukiSelected(ActionEvent event) {

    }

    @FXML
    void teslaSelected(ActionEvent event) {

    }

    @FXML
    void toyotaSelected(ActionEvent event) {

    }

    @FXML
    void transmissionSelected(ActionEvent event) {

    }

    @FXML
    void typesVehiclesSelected(ActionEvent event) {

    }

    @FXML
    void volkswagenSelected(ActionEvent event) {

    }

    @FXML
    void volvoSelected(ActionEvent event) {

    }

    @FXML
    void whiteSelected(ActionEvent event) {

    }

    @FXML
    void winnebagoSelected(ActionEvent event) {

    }

    @FXML
    void yamahaSelected(ActionEvent event) {

    }

    @FXML
    void year2019Selected(ActionEvent event) {

    }

    @FXML
    void year2020Selected(ActionEvent event) {

    }

    @FXML
    void year2021Selected(ActionEvent event) {

    }

    @FXML
    void year2022Selected(ActionEvent event) {

    }

    @FXML
    void year2023Selected(ActionEvent event) {

    }

    @FXML
    void year2024Selected(ActionEvent event) {

    }

    @FXML
    void yearSelected(ActionEvent event) {

    }

    @FXML
    void yellowSelected(ActionEvent event) {

    }

}
