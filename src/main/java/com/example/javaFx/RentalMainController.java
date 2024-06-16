package com.example.javaFx;

import customer.data.Customer;
import customer.data.RentalHistory;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import parsingCSV.WorkWithJSON;
import renting.FilterForRenting;
import vehicle.data.*;
import renting.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class RentalMainController {


    private FilterForRenting filterForRenting;

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
    private Button loadButton;


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
    private Label UsernameLabel1;

    @FXML
    private ListView<RentalInformation> reservedListView;

    @FXML
    private AnchorPane resultPane;

    @FXML
    private ListView<Vehicle> resultsList;

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
        Vehicle vehicle = resultsList.getSelectionModel().getSelectedItem();
        displayVehicleDetails(vehicle);

    }

    @FXML
    void brandsSelected(ActionEvent event) {
        boolean isSelected = brandsCheckBox.isSelected();
        alfaRomeoCheckBox.setSelected(isSelected);
        astonMartinCheckBox.setSelected(isSelected);
        audiCheckBox.setSelected(isSelected);
        bentleyCheckBox.setSelected(isSelected);
        bmwCheckBox.setSelected(isSelected);
        cadillacCheckBox.setSelected(isSelected);
        chevroletCheckBox.setSelected(isSelected);
        chryslerCheckBox.setSelected(isSelected);
        citroenCheckBox.setSelected(isSelected);
        dodgeCheckBox.setSelected(isSelected);
        ducatiCheckBox.setSelected(isSelected);
        ferrariCheckBox.setSelected(isSelected);
        fiatCheckBox.setSelected(isSelected);
        fordCheckBox.setSelected(isSelected);
        harleyDavidsonCheckBox.setSelected(isSelected);
        hondaCheckBox.setSelected(isSelected);
        hyundaiCheckBox.setSelected(isSelected);
        jaguarCheckBox.setSelected(isSelected);
        jeepCheckBox.setSelected(isSelected);
        kawasakiCheckBox.setSelected(isSelected);
        kiaCheckBox.setSelected(isSelected);
        lamborghiniCheckBox.setSelected(isSelected);
        landRoverCheckBox.setSelected(isSelected);
        maseratiCheckBox.setSelected(isSelected);
        mazdaCheckBox.setSelected(isSelected);
        mercedesCheckBox.setSelected(isSelected);
        nissanCheckBox.setSelected(isSelected);
        opelCheckBox.setSelected(isSelected);
        peugeotCheckBox.setSelected(isSelected);
        porscheCheckBox.setSelected(isSelected);
        renaultCheckBox.setSelected(isSelected);
        rollsRoyceCheckBox.setSelected(isSelected);
        subaruCheckBox.setSelected(isSelected);
        suzukiCheckBox.setSelected(isSelected);
        suzukiMotorcyclesCheckBox.setSelected(isSelected);
        teslaCheckBox.setSelected(isSelected);
        toyotaCheckBox.setSelected(isSelected);
        volkswagenCheckBox.setSelected(isSelected);
        volvoCheckBox.setSelected(isSelected);
        winnebagoCheckBox.setSelected(isSelected);
        yamahaCheckBox.setSelected(isSelected);
        teslaCheckBox.setSelected(isSelected);
    }



    @FXML
    void colorsSelected(ActionEvent event) {
        boolean isSelected = colorsCheckBox.isSelected();
        blackCheckBox.setSelected(isSelected);
        blueCheckBox.setSelected(isSelected);
        grayCheckBox.setSelected(isSelected);
        greenCheckBox.setSelected(isSelected);
        orangeCheckBox.setSelected(isSelected);
        purpleCheckBox.setSelected(isSelected);
        redCheckBox.setSelected(isSelected);
        silverCheckBox.setSelected(isSelected);
        whiteCheckBox.setSelected(isSelected);
        yellowCheckBox.setSelected(isSelected);
    }

    @FXML
    void filtersSelected(ActionEvent event) {
        boolean isSelected = filtersCheckBox.isSelected();
        automaticCheckBox.setSelected(isSelected);
        manualCheckBox.setSelected(isSelected);
        transmissionCheckBox.setSelected(isSelected);
        typesVehiclesCheckBox.setSelected(isSelected);
        fuelCheckBox.setSelected(isSelected);
        pricePerDayCheckBox.setSelected(isSelected);
        yearCheckBox.setSelected(isSelected);
        colorsCheckBox.setSelected(isSelected);
        brandsCheckBox.setSelected(isSelected);

    }

    @FXML
    void fuelSelected(ActionEvent event) {
        boolean isSelected = fuelCheckBox.isSelected();
        petrolCheckBox.setSelected(isSelected);
        dieselCheckBox.setSelected(isSelected);
        electricCheckBox.setSelected(isSelected);
        hybridCheckBox.setSelected(isSelected);

    }

    @FXML
    void pricePerDaySelected(ActionEvent event) {
        boolean isSelected = pricePerDayCheckBox.isSelected();
        price0CheckBox.setSelected(isSelected);
        price100CheckBox.setSelected(isSelected);
        price150CheckBox.setSelected(isSelected);
        price200CheckBox.setSelected(isSelected);
        price250CheckBox.setSelected(isSelected);
        price300CheckBox.setSelected(isSelected);
        price350CheckBox.setSelected(isSelected);
        price400CheckBox.setSelected(isSelected);

    }

    @FXML
    void searchButtonClicked(ActionEvent event) {
        if (filterForRenting == null) {
            filterForRenting = new FilterForRenting();
        }
        ArrayList<Vehicle> vehicles = filterForRenting.displayAllAvailableVehicles();
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>(vehicles);
        filteredVehicles = applyBrandFilters(filteredVehicles);

        filteredVehicles = applyColorFilters(filteredVehicles);

        filteredVehicles = applyTypeFilters(filteredVehicles);

        filteredVehicles = applyYearFilters(filteredVehicles);

        filteredVehicles = applyFuelFilters(filteredVehicles);

        filteredVehicles = applyTransmissionFilters(filteredVehicles);

        filteredVehicles = applyPricePerDayFilters(filteredVehicles);

        displayResults(filteredVehicles);
    }

    private ArrayList<Vehicle> applyBrandFilters(ArrayList<Vehicle> vehicles) {
        ArrayList<Brand> selectedBrands = getSelectedBrands();
        if (!selectedBrands.isEmpty()) {
            vehicles.removeIf(vehicle -> !selectedBrands.contains(vehicle.getBrand()));
        }
        return vehicles;
    }

    private ArrayList<Brand> getSelectedBrands() {
        ArrayList<Brand> selectedBrands = new ArrayList<>();
        if (audiCheckBox.isSelected()) {
            selectedBrands.add(Brand.AUDI);
        }
        if (bmwCheckBox.isSelected()) {
            selectedBrands.add(Brand.BMW);
        }
        if(mercedesCheckBox.isSelected()){
            selectedBrands.add(Brand.MERCEDES_BENZ);
        }
        if(volkswagenCheckBox.isSelected()){
            selectedBrands.add(Brand.VOLKSWAGEN);
        }
        if(porscheCheckBox.isSelected()){
            selectedBrands.add(Brand.PORSCHE);
        }
        if(opelCheckBox.isSelected()){
            selectedBrands.add(Brand.OPEL);
        }
        if(fordCheckBox.isSelected()){
            selectedBrands.add(Brand.FORD);
        }
        if(chevroletCheckBox.isSelected()){
            selectedBrands.add(Brand.CHEVROLET);
        }
        if(toyotaCheckBox.isSelected()){
            selectedBrands.add(Brand.TOYOTA);
        }
        if(hondaCheckBox.isSelected()){
            selectedBrands.add(Brand.HONDA);
        }
        if(nissanCheckBox.isSelected()){
            selectedBrands.add(Brand.NISSAN);
        }
        if(hyundaiCheckBox.isSelected()){
            selectedBrands.add(Brand.HYUNDAI);
        }
        if(kiaCheckBox.isSelected()){
            selectedBrands.add(Brand.KIA);
        }
        if(peugeotCheckBox.isSelected()){
            selectedBrands.add(Brand.PEUGEOT);
        }
        if(renaultCheckBox.isSelected()){
            selectedBrands.add(Brand.RENAULT);
        }
        if(citroenCheckBox.isSelected()){
            selectedBrands.add(Brand.CITROEN);
        }
        if(fiatCheckBox.isSelected()){
            selectedBrands.add(Brand.FIAT);
        }
        if(alfaRomeoCheckBox.isSelected()){
            selectedBrands.add(Brand.ALFA_ROMEO);
        }
        if(ferrariCheckBox.isSelected()){
            selectedBrands.add(Brand.FERRARI);
        }
        if(lamborghiniCheckBox.isSelected()){
            selectedBrands.add(Brand.LAMBORGHINI);
        }
        if(maseratiCheckBox.isSelected()){
            selectedBrands.add(Brand.MASERATI);
        }
        if(astonMartinCheckBox.isSelected()){
            selectedBrands.add(Brand.ASTON_MARTIN);
        }
        if(bentleyCheckBox.isSelected()){
            selectedBrands.add(Brand.BENTLEY);
        }
        if(rollsRoyceCheckBox.isSelected()){
            selectedBrands.add(Brand.ROLLS_ROYCE);
        }
        if(jaguarCheckBox.isSelected()){
            selectedBrands.add(Brand.JAGUAR);
        }
        if(landRoverCheckBox.isSelected()){
            selectedBrands.add(Brand.LAND_ROVER);
        }
        if(teslaCheckBox.isSelected()){
            selectedBrands.add(Brand.TESLA);
        }
        if(volvoCheckBox.isSelected()){
            selectedBrands.add(Brand.VOLVO);
        }
        if(subaruCheckBox.isSelected()){
            selectedBrands.add(Brand.SUBARU);
        }
        if(mazdaCheckBox.isSelected()){
            selectedBrands.add(Brand.MAZDA);
        }
        if(suzukiCheckBox.isSelected()){
            selectedBrands.add(Brand.SUZUKI);
        }
        if(dodgeCheckBox.isSelected()){
            selectedBrands.add(Brand.DODGE);
        }
        if(jeepCheckBox.isSelected()){
            selectedBrands.add(Brand.JEEP);
        }
        if(cadillacCheckBox.isSelected()){
            selectedBrands.add(Brand.CADILLAC);
        }
        if(harleyDavidsonCheckBox.isSelected()){
            selectedBrands.add(Brand.HARLEY_DAVIDSON);
        }
        if(ducatiCheckBox.isSelected()){
            selectedBrands.add(Brand.DUCATI);
        }
        if(yamahaCheckBox.isSelected()){
            selectedBrands.add(Brand.YAMAHA);
        }
        if(kawasakiCheckBox.isSelected()){
            selectedBrands.add(Brand.KAWASAKI);
        }
        if(suzukiMotorcyclesCheckBox.isSelected()){
            selectedBrands.add(Brand.SUZUKI_MOTORCYCLES);
        }
        if(winnebagoCheckBox.isSelected()){
            selectedBrands.add(Brand.WINNEBAGO);
        }
        if(chryslerCheckBox.isSelected()){
            selectedBrands.add(Brand.CHRYSLER);
        }
        return selectedBrands;
    }

    private ArrayList<Vehicle> applyColorFilters(ArrayList<Vehicle> vehicles) {
        ArrayList<Color> selectedColors = getSelectedColors();
        if (!selectedColors.isEmpty()) {
            vehicles.removeIf(vehicle -> !selectedColors.contains(vehicle.getColor()));
        }
        return vehicles;
    }

    private ArrayList<Color> getSelectedColors() {
        ArrayList<Color> selectedColors = new ArrayList<>();


        if (blackCheckBox.isSelected()) {
            selectedColors.add(Color.BLACK);
        }
        if (blueCheckBox.isSelected()) {
            selectedColors.add(Color.BLUE);
        }
        if (grayCheckBox.isSelected()) {
            selectedColors.add(Color.GRAY);
        }
        if (greenCheckBox.isSelected()) {
            selectedColors.add(Color.GREEN);
        }
        if (orangeCheckBox.isSelected()) {
            selectedColors.add(Color.ORANGE);
        }
        if (purpleCheckBox.isSelected()) {
            selectedColors.add(Color.PURPLE);
        }
        if (redCheckBox.isSelected()) {
            selectedColors.add(Color.RED);
        }
        if (whiteCheckBox.isSelected()) {
            selectedColors.add(Color.WHITE);
        }
        if (yellowCheckBox.isSelected()) {
            selectedColors.add(Color.YELLOW);
        }

        return selectedColors;
    }

    private ArrayList<Vehicle> applyTypeFilters(ArrayList<Vehicle> vehicles) {
        ArrayList<VehicleTypes> selectedTypes = getSelectedTypes();
        if (!selectedTypes.isEmpty()) {
            vehicles.removeIf(vehicle -> !selectedTypes.contains(vehicle.getVehicleTypes()));
        }
        return vehicles;
    }

    private ArrayList<VehicleTypes> getSelectedTypes() {
        ArrayList<VehicleTypes> selectedTypes = new ArrayList<>();
        if (camperCheckBox.isSelected()) {
            selectedTypes.add(VehicleTypes.CAMPER);
        }
        if (convertibleCheckBox.isSelected()) {
            selectedTypes.add(VehicleTypes.CONVERTIBLE);
        }
        if (coupeCheckBox.isSelected()) {
            selectedTypes.add(VehicleTypes.COUPE);
        }
        if (hatchbackCheckBox.isSelected()) {
            selectedTypes.add(VehicleTypes.HATCHBACK);
        }
        if (minivanCheckBox.isSelected()) {
            selectedTypes.add(VehicleTypes.MINIVAN);
        }
        if (motorcycleCheckBox.isSelected()) {
            selectedTypes.add(VehicleTypes.MOTORCYCLE);
        }
        if (pickupCheckBox.isSelected()) {
            selectedTypes.add(VehicleTypes.PICKUP);
        }
        if (sedanCheckBox.isSelected()) {
            selectedTypes.add(VehicleTypes.SEDAN);
        }
        if (suvCheckBox.isSelected()) {
            selectedTypes.add(VehicleTypes.SUV);
        }

        return selectedTypes;
    }

    private ArrayList<Vehicle> applyYearFilters(ArrayList<Vehicle> vehicles) {
        ArrayList<Year> selectedYears = getSelectedYears();
        if (!selectedYears.isEmpty()) {
            vehicles.removeIf(vehicle -> !selectedYears.contains(vehicle.getYear()));
        }
        return vehicles;
    }

    private ArrayList<Year> getSelectedYears() {
        ArrayList<Year> selectedYears = new ArrayList<>();
        if (year2019CheckBox.isSelected()) {
            selectedYears.add(Year.Y2019);
        }
        if (year2020CheckBox.isSelected()) {
            selectedYears.add(Year.Y2020);
        }
        if (year2021CheckBox.isSelected()) {
            selectedYears.add(Year.Y2021);
        }
        if (year2022CheckBox.isSelected()) {
            selectedYears.add(Year.Y2022);
        }
        if (year2023CheckBox.isSelected()) {
            selectedYears.add(Year.Y2023);
        }
        if (year2024CheckBox.isSelected()) {
            selectedYears.add(Year.Y2024);
        }
        return selectedYears;
    }
    private ArrayList<Vehicle> applyFuelFilters(ArrayList<Vehicle> vehicles) {
        ArrayList<FuelType> selectedFuels = getSelectedFuels();
        if (!selectedFuels.isEmpty()) {
            vehicles.removeIf(vehicle -> !selectedFuels.contains(vehicle.getFuelType()));
        }
        return vehicles;
    }
    private ArrayList<FuelType> getSelectedFuels() {
        ArrayList<FuelType> selectedFuels = new ArrayList<>();
        if (petrolCheckBox.isSelected()) {
            selectedFuels.add(FuelType.PETROL);
        }
        if (dieselCheckBox.isSelected()) {
            selectedFuels.add(FuelType.DIESEL);
        }
        if (electricCheckBox.isSelected()) {
            selectedFuels.add(FuelType.ELECTRIC);
        }
        if (hybridCheckBox.isSelected()) {
            selectedFuels.add(FuelType.HYBRID);
        }
        return selectedFuels;
    }
    private ArrayList<Vehicle> applyTransmissionFilters(ArrayList<Vehicle> vehicles) {
        ArrayList<GearBox> selectedTransmissions = getSelectedTransmissions();
        if (!selectedTransmissions.isEmpty()) {
            vehicles.removeIf(vehicle -> !selectedTransmissions.contains(vehicle.getGearBox()));
        }
        return vehicles;
    }
    private ArrayList<GearBox> getSelectedTransmissions() {
        ArrayList<GearBox> selectedTransmissions = new ArrayList<>();
        if (automaticCheckBox.isSelected()) {
            selectedTransmissions.add(GearBox.AUTOMATIC);
        }
        if (manualCheckBox.isSelected()) {
            selectedTransmissions.add(GearBox.MANUAL);
        }
        return selectedTransmissions;
    }
    private ArrayList<Vehicle> applyPricePerDayFilters(ArrayList<Vehicle> vehicles) {
        ArrayList<PricePerDay> selectedPrices = getSelectedPrices();
        if (!selectedPrices.isEmpty()) {
            vehicles.removeIf(vehicle -> !selectedPrices.contains(vehicle.getPricePerDay()));
        }
        return vehicles;
    }
    private ArrayList<PricePerDay> getSelectedPrices() {
        ArrayList<PricePerDay> selectedPrices = new ArrayList<>();
        if (price0CheckBox.isSelected()) {
            selectedPrices.add(PricePerDay.P50);
        }
        if (price100CheckBox.isSelected()) {
            selectedPrices.add(PricePerDay.P100);
        }
        if (price150CheckBox.isSelected()) {
            selectedPrices.add(PricePerDay.P150);
        }
        if (price200CheckBox.isSelected()) {
            selectedPrices.add(PricePerDay.P200);
        }
        if (price250CheckBox.isSelected()) {
            selectedPrices.add(PricePerDay.P250);
        }
        if (price300CheckBox.isSelected()) {
            selectedPrices.add(PricePerDay.P300);
        }
        if (price350CheckBox.isSelected()) {
            selectedPrices.add(PricePerDay.P350);
        }
        if (price400CheckBox.isSelected()) {
            selectedPrices.add(PricePerDay.P400);
        }
        return selectedPrices;
    }

    @FXML
    void transmissionSelected(ActionEvent event) {
        boolean isSelected = transmissionCheckBox.isSelected();
        automaticCheckBox.setSelected(isSelected);
        manualCheckBox.setSelected(isSelected);

    }

    @FXML
    void typesVehiclesSelected(ActionEvent event) {
        boolean isSelected = typesVehiclesCheckBox.isSelected();
        camperCheckBox.setSelected(isSelected);
        convertibleCheckBox.setSelected(isSelected);
        coupeCheckBox.setSelected(isSelected);
        hatchbackCheckBox.setSelected(isSelected);
        minivanCheckBox.setSelected(isSelected);
        motorcycleCheckBox.setSelected(isSelected);
        pickupCheckBox.setSelected(isSelected);
        sedanCheckBox.setSelected(isSelected);
        suvCheckBox.setSelected(isSelected);

    }

    public void setUsernameLabel(String usernameLabel) {
        this.usernameLabel.setText(usernameLabel);
    }

    @FXML
    void year2024Selected(ActionEvent event) {

    }

    @FXML
    void yearSelected(ActionEvent event) {
        boolean isSelected = yearCheckBox.isSelected();
        year2019CheckBox.setSelected(isSelected);
        year2020CheckBox.setSelected(isSelected);
        year2021CheckBox.setSelected(isSelected);
        year2022CheckBox.setSelected(isSelected);
        year2023CheckBox.setSelected(isSelected);
        year2024CheckBox.setSelected(isSelected);

    }


    private void displayResults(ArrayList<Vehicle> vehicles) {
        resultsList.getItems().clear();
        resultsList.getItems().addAll(vehicles);
    }

    private void displayVehicleDetails(Vehicle vehicle) {
        brandModelLabel.setText(title(vehicle));
        descLabel.setText(description(vehicle));
        priceLabel.setText("Price per day: " + vehicle.getPricePerDay());
    }

    public void rentButtonClicked(ActionEvent actionEvent) {
        RentalFunctions rentalFunctions = new RentalFunctions();
        WorkWithJSON workWithJSON = new WorkWithJSON();
        Vehicle selectedVehicle = resultsList.getSelectionModel().getSelectedItem();
        if (selectedVehicle == null) {
            FXMLLoader errorLoader = new FXMLLoader(getClass().getResource("rental-error.fxml"));
            try {
                errorLoader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }
            RentalErrorController errorController = errorLoader.getController();
            errorController.setErrorDescLabel("Please select a vehicle");
            Parent root = errorLoader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Error");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            return;
        }
        if (dateFromPicker.getValue() == null || dateToPicker.getValue() == null) {
            FXMLLoader errorLoader = new FXMLLoader(getClass().getResource("rental-error.fxml"));
            try {
                errorLoader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }
            RentalErrorController errorController = errorLoader.getController();
            errorController.setErrorDescLabel("Please select dates");
            Parent root = errorLoader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Error");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            return;
        }

        LocalDateTime dateFrom = dateFromPicker.getValue().atStartOfDay();
        LocalDateTime dateTo = dateToPicker.getValue().atStartOfDay();

        long duration = ChronoUnit.DAYS.between(dateFrom, dateTo);
        if (duration < 1) {
            FXMLLoader errorLoader = new FXMLLoader(getClass().getResource("rental-error.fxml"));
            try {
                errorLoader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }
            RentalErrorController errorController = errorLoader.getController();
            errorController.setErrorDescLabel("Please select valid dates");
            Parent root = errorLoader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Error");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            return;
        }

        if(dateTo.isBefore(LocalDateTime.now())){
            FXMLLoader errorLoader = new FXMLLoader(getClass().getResource("rental-error.fxml"));
            try {
                errorLoader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }
            RentalErrorController errorController = errorLoader.getController();
            errorController.setErrorDescLabel("Please select valid dates");
            Parent root = errorLoader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Error");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            return;
        }

        int durationInt = (int) duration;
        rentalFunctions.rentVehicle(selectedVehicle.getId(), usernameLabel.getText(), durationInt);
        resultsList.refresh();
    }

    public void dateFromSelected(ActionEvent actionEvent) {
    }

    public void dateToSelected(ActionEvent actionEvent) {
    }
    private String description(Vehicle vehicle) {
        String description =  "Type:" + vehicle.getVehicleTypes() + "\n" +"Color: " + vehicle.getColor() + "\n" +"Fuel: " + vehicle.getFuelType() + "\n"+ "Transmission"
                + vehicle.getGearBox() + "\n"+"Year: " + vehicle.getYear();
        return description;
    }
    private String title(Vehicle vehicle) {
        String title = vehicle.getBrand() + " "+  vehicle.getModel();
        return title;
    }
    public void initialize() {
        Timeline fiveMinuteTimeline = new Timeline(new KeyFrame(Duration.minutes(5), event -> {
            LocalDateTime now = LocalDateTime.now();
        }));
        fiveMinuteTimeline.setCycleCount(Timeline.INDEFINITE);
        fiveMinuteTimeline.play();
    }


    public void loadButton(ActionEvent actionEvent) {
        WorkWithJSON workWithJSON = new WorkWithJSON();
        Customer customer= workWithJSON.findCustomerById(usernameLabel.getText());
        ArrayList<RentalInformation> list= customer.getRentalHistories();
        if (list != null) {
            setReservedListView(list);
        }
        else {
            FXMLLoader errorLoader = new FXMLLoader(getClass().getResource("rental-error.fxml"));
            try {
                errorLoader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }
            RentalErrorController errorController = errorLoader.getController();
            errorController.setErrorDescLabel("No reservations found");
            Parent root = errorLoader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Error");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();

        }

    }

    public void reservationSelected(ListView.EditEvent<RentalInformation> rentalHistoryEditEvent) {
    }
    public void setReservedListView(ArrayList<RentalInformation> rentalHistories) {
        reservedListView.getItems().clear();
        reservedListView.getItems().addAll(rentalHistories);
    }
}
