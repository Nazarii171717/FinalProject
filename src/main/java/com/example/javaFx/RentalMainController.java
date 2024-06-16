package com.example.javaFx;

import customer.data.Customer;
import customer.data.CustomerDataFunctions;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import parsingCSV.WorkWithJSON;
import renting.FilterForRenting;
import renting.RentalFunctions;
import renting.RentalInformation;
import vehicle.data.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class RentalMainController {


    private FilterForRenting filterForRenting;

    @FXML
    private Tab accountTab;

    @FXML
    private Label invoiceTitleLabel;

    @FXML
    private Label invoiceDescLabel;

    @FXML
    private Label invoiceTotalLabel;

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

    @FXML private Label yourAccountLabel;
    @FXML private Label accountDescLabel;
    @FXML private Label settingsLabel;
    @FXML private Label passwdChangeLabel;
    @FXML private Label emailChangeLabel;
    @FXML private Label emailChangeLabel1;
    @FXML private Label addresssChangeLabel;
    @FXML private Label aboutLabel;
    @FXML private Label softLabel;
    @FXML private Label authLabel;
    @FXML private Label authIntroLabel;
    @FXML private TextField oldEmailField;
    @FXML private TextField newEmailField;
    @FXML private TextField oldPhoneNumber;
    @FXML private TextField newPhoneNumber;
    @FXML private TextArea newAddressArea;
    @FXML private Button changePasswordButton;
    @FXML private Button emailChangeButton;
    @FXML private Button changeNumberButton;
    @FXML private Button changeAddressButton;
    @FXML private PasswordField currentPasswordField;
    @FXML private PasswordField newPasswordField;
    @FXML private SplitPane splitPane1;
    @FXML private SplitPane splitPane2;
    @FXML private SplitPane splitPane3;

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
        resultsList.setCellFactory(new Callback<ListView<Vehicle>, ListCell<Vehicle>>() {
            @Override
            public ListCell<Vehicle> call(ListView<Vehicle> param) {
                return new ListCell<Vehicle>() {
                    @Override
                    protected void updateItem(Vehicle item, boolean empty) {
                        super.updateItem(item, empty);

                        if (empty || item == null) {
                            setText(null);
                        } else {
                            // Customize the text here
                            setText("Brand: " + item.getBrand() + ", Model: " + item.getModel() + ", Year: " + item.getYear());
                        }
                    }
                };
            }
        });
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
            displayError("Please select a vehicle");
        }
        if (dateFromPicker.getValue() == null || dateToPicker.getValue() == null) {
            displayError("Please select a valid date");
        }

        LocalDateTime dateFrom = dateFromPicker.getValue().atStartOfDay();
        LocalDateTime dateTo = dateToPicker.getValue().atStartOfDay();

        long duration = ChronoUnit.DAYS.between(dateFrom, dateTo);
        if (duration < 1) {
            displayError("Please select a valid date");
        }

        if(dateTo.isBefore(LocalDateTime.now())){
            displayError("Please select a valid date");
        }

        int durationInt = (int) duration;
        rentalFunctions.rentVehicle(selectedVehicle.getId(), usernameLabel.getText(), durationInt);
        resultsList.refresh();
    }

    private String description(Vehicle vehicle) {
        return "Brand: " + BrandConverter(vehicle.getBrand()) + "\n" +
                "Model: " + modelConverter(vehicle.getModel()) + "\n" +
                "Type: " + vehicleTypeConverter(vehicle.getVehicleTypes()) + "\n" +
                "Color: " + ColorConverter(vehicle.getColor()) + "\n" +
                "Fuel: " + FuelTypeConverter(vehicle.getFuelType()) + "\n" +
                "Transmission: " + GearBoxConverter(vehicle.getGearBox()) + "\n" +
                "Year: " + YearConverter(vehicle.getYear()) + "\n" +
                "Engine: " + vehicle.getEngine() + "\n" +
                "Max Speed: " + vehicle.getMaxSpeed() + "\n" +
                "Max Load: " + vehicle.getMaxLoad() + "\n" +
                "Fuel Tank Capacity: " + vehicle.getFuelTankCapacity() + "\n" +
                "Fuel Consumption: " + vehicle.getFuelConsumption() + "\n" +
                "Mileage: " + vehicle.getMileage() + "\n" +
                "Number of Seats: " + vehicle.getNumberOfSeats() + "\n";
    }
    private String title(Vehicle vehicle) {
        String title = modelConverter(vehicle.getModel());
        return title;
    }
    public void initialize() {
        KeyFrame keyFrame = new KeyFrame(Duration.minutes(1), event -> {
            updateRentalHistories();
        });

        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    @FXML
    public void updateRentalHistories() {
        WorkWithJSON workWithJSON = new WorkWithJSON();
        displayCustomerInfo();
        RentalFunctions rentalFunctions = new RentalFunctions();
        rentalFunctions.checkTheStatusOfAllVehicles();
        Customer customer = workWithJSON.findCustomerById(usernameLabel.getText());
        ArrayList<RentalInformation> list = customer.getRentalHistories();
        if (list != null) {
            reservedListView.getItems().clear();
            reservedListView.getItems().addAll(list);
            reservedListView.setCellFactory(new Callback<ListView<RentalInformation>, ListCell<RentalInformation>>() {
                @Override
                public ListCell<RentalInformation> call(ListView<RentalInformation> param) {
                    return new ListCell<RentalInformation>() {
                        @Override
                        protected void updateItem(RentalInformation item, boolean empty) {
                            super.updateItem(item, empty);

                            if (empty || item == null) {
                                setText(null);
                            } else {
                                // Customize the text here
                                setText("Vehicle ID: " + item.getVehicleId() + ", Customer ID: " + item.getCustomerId() + ", Duration: " + item.getDuration());
                            }
                        }
                    };
                }
            });
        }
    }



    public void loadButton(ActionEvent actionEvent) {
        updateRentalHistories();
    }

    public void reservationSelected(MouseEvent event) {
        RentalInformation selectedRental = reservedListView.getSelectionModel().getSelectedItem();
        if (selectedRental != null) {
            invoiceTitleLabel.setText("INVOICE");
            invoiceDescLabel.setText(formatAsInvoice(selectedRental));
            invoiceTotalLabel.setText("Total: " + calculateTotal(selectedRental) + "€");
        }

    }
    private int calculateTotal(RentalInformation rentalInformation) {
        WorkWithJSON workWithJSON = new WorkWithJSON();
        int days = rentalInformation.getDuration();
        PricePerDay pricePerDay = workWithJSON.findVehicleById(rentalInformation.getVehicleId()).getPricePerDay();
        int pricePerDayInt = priceConverter(pricePerDay);
        return days * pricePerDayInt;
    }

    private int priceConverter(PricePerDay pricePerDay) {
        switch (pricePerDay) {
            case P50:
                return 50;
            case P100:
                return 100;
            case P150:
                return 150;
            case P200:
                return 200;
            case P250:
                return 250;
            case P300:
                return 300;
            case P350:
                return 350;
            case P400:
                return 400;
            default:
                return 0;
        }
    }
    public String formatAsInvoice(RentalInformation rentalInformation) {
        WorkWithJSON workWithJSON = new WorkWithJSON();
        Customer customer = workWithJSON.findCustomerById(rentalInformation.getCustomerId());
        Vehicle vehicle = workWithJSON.findVehicleById(rentalInformation.getVehicleId());

        return "Rental Information:\n" +
                "-------------------\n" +
                "Vehicle ID: " + rentalInformation.getVehicleId() + "\n" +
                "Vehicle Model: " + vehicle.getModel() + "\n" +
                "Price Per Day: " + priceConverter(vehicle.getPricePerDay()) + "€"+ "\n" +
                "Customer ID: " + rentalInformation.getCustomerId() + "\n" +
                "Duration: " + rentalInformation.getDuration() + " days\n" +
                "Rental Date: " + rentalInformation.getRentalDate().toLocalDate().toString() + "\n" +
                "Return Date: " + rentalInformation.getReturnDate().toLocalDate().toString() + "\n" +
                "Renting Status: " + rentalInformation.getRentingStatus().toString() + "\n" +
                "-------------------\n" +
                "Customer Information:\n" +
                "-------------------\n" +
                "Name: " + customer.getName() + "\n" +
                "Surname: " + customer.getSurname() + "\n" +
                "Phone: " + customer.getPhone() + "\n" +
                "Email: " + customer.getEmail() + "\n" +
                "Address: " + customer.getAddress() + "\n";
    }

    private String modelConverter(Model model) {
        switch (model) {
            case AUDI_A1:
                return "Audi A1";
            case AUDI_A3:
                return "Audi A3";
            case AUDI_A4:
                return "Audi A4";
            case AUDI_A5:
                return "Audi A5";
            case AUDI_A6:
                return "Audi A6";
            case AUDI_A7:
                return "Audi A7";
            case AUDI_A8:
                return "Audi A8";
            case AUDI_Q2:
                return "Audi Q2";
            case AUDI_Q3:
                return "Audi Q3";
            case AUDI_Q5:
                return "Audi Q5";
            case AUDI_Q7:
                return "Audi Q7";
            case AUDI_Q8:
                return "Audi Q8";
            case AUDI_R8:
                return "Audi R8";
            case AUDI_TT:
                return "Audi TT";
            case BMW_1_SERIES:
                return "BMW 1 Series";
            case BMW_2_SERIES:
                return "BMW 2 Series";
            case BMW_3_SERIES:
                return "BMW 3 Series";
            case BMW_4_SERIES:
                return "BMW 4 Series";
            case BMW_5_SERIES:
                return "BMW 5 Series";
            case BMW_6_SERIES:
                return "BMW 6 Series";
            case BMW_7_SERIES:
                return "BMW 7 Series";
            case BMW_8_SERIES:
                return "BMW 8 Series";
            case BMW_X1:
                return "BMW X1";
            case BMW_X2:
                return "BMW X2";
            case BMW_X3:
                return "BMW X3";
            case BMW_X4:
                return "BMW X4";
            case BMW_X5:
                return "BMW X5";
            case BMW_X6:
                return "BMW X6";
            case BMW_X7:
                return "BMW X7";
            case BMW_Z4:
                return "BMW Z4";
            case BMW_I3:
                return "BMW i3";
            case BMW_I8:
                return "BMW i8";
            case MERCEDES_BENZ_A_CLASS:
                return "Mercedes-Benz A-Class";
            case MERCEDES_BENZ_B_CLASS:
                return "Mercedes-Benz B-Class";
            case MERCEDES_BENZ_C_CLASS:
                return "Mercedes-Benz C-Class";
            case MERCEDES_BENZ_E_CLASS:
                return "Mercedes-Benz E-Class";
            case MERCEDES_BENZ_S_CLASS:
                return "Mercedes-Benz S-Class";
            case MERCEDES_BENZ_G_CLASS:
                return "Mercedes-Benz G-Class";
            case MERCEDES_BENZ_GL_CLASS:
                return "Mercedes-Benz GL-Class";
            case MERCEDES_BENZ_GLE_CLASS:
                return "Mercedes-Benz GLE-Class";
            case MERCEDES_BENZ_GLK_CLASS:
                return "Mercedes-Benz GLK-Class";
            case MERCEDES_BENZ_GLS_CLASS:
                return "Mercedes-Benz GLS-Class";
            case MERCEDES_BENZ_M_CLASS:
                return "Mercedes-Benz M-Class";
            case MERCEDES_BENZ_R_CLASS:
                return "Mercedes-Benz R-Class";
            case MERCEDES_BENZ_V_CLASS:
                return "Mercedes-Benz V-Class";
            case MERCEDES_BENZ_AMG_GT:
                return "Mercedes-Benz AMG GT";
            case VOLKSWAGEN_GOLF:
                return "Volkswagen Golf";
            case VOLKSWAGEN_PASSAT:
                return "Volkswagen Passat";
            case VOLKSWAGEN_POLO:
                return "Volkswagen Polo";
            case VOLKSWAGEN_TIGUAN:
                return "Volkswagen Tiguan";
            case VOLKSWAGEN_ARTEON:
                return "Volkswagen Arteon";
            case VOLKSWAGEN_T_ROC:
                return "Volkswagen T-Roc";
            case VOLKSWAGEN_TOURAN:
                return "Volkswagen Touran";
            case VOLKSWAGEN_UP:
                return "Volkswagen Up";
            case VOLKSWAGEN_BEETLE:
                return "Volkswagen Beetle";
            case VOLKSWAGEN_JETTA:
                return "Volkswagen Jetta";
            case VOLKSWAGEN_SCIROCCO:
                return "Volkswagen Scirocco";
            case VOLKSWAGEN_SHARAN:
                return "Volkswagen Sharan";
            case VOLKSWAGEN_TOUAREG:
                return "Volkswagen Touareg";
            case PORSCHE_911:
                return "Porsche 911";
            case PORSCHE_718:
                return "Porsche 718";
            case PORSCHE_PANAMERA:
                return "Porsche Panamera";
            case PORSCHE_CAYENNE:
                return "Porsche Cayenne";
            case PORSCHE_MACAN:
                return "Porsche Macan";
            case PORSCHE_TAYCAN:
                return "Porsche Taycan";
            case PORSCHE_CARRERA_GT:
                return "Porsche Carrera GT";
            case PORSCHE_918_SPYDER:
                return "Porsche 918 Spyder";
            case PORSCHE_BOXSTER:
                return "Porsche Boxster";
            case PORSCHE_CAYMAN:
                return "Porsche Cayman";
            case PORSCHE_CAYENNE_COUPE:
                return "Porsche Cayenne Coupe";
            case PORSCHE_MACAN_GTS:
                return "Porsche Macan GTS";
            case OPEL_CORSA:
                return "Opel Corsa";
            case OPEL_ASTRA:
                return "Opel Astra";
            case OPEL_INSIGNIA:
                return "Opel Insignia";
            case OPEL_CROSSLAND_X:
                return "Opel Crossland X";
            case OPEL_GRANDLAND_X:
                return "Opel Grandland X";
            case OPEL_MOKKA_X:
                return "Opel Mokka X";
            case OPEL_ZAFIRA:
                return "Opel Zafira";
            case OPEL_ADAM:
                return "Opel Adam";
            case OPEL_COMBO:
                return "Opel Combo";
            case OPEL_VIVARO:
                return "Opel Vivaro";
            case OPEL_MOVANO:
                return "Opel Movano";
            case FORD_FIESTA:
                return "Ford Fiesta";
            case FORD_FOCUS:
                return "Ford Focus";
            case FORD_MONDEO:
                return "Ford Mondeo";
            case FORD_KUGA:
                return "Ford Kuga";
            case FORD_PUMA:
                return "Ford Puma";
            case FORD_ECO_SPORT:
                return "Ford EcoSport";
            case FORD_S_MAX:
                return "Ford S-Max";
            case FORD_GALAXY:
                return "Ford Galaxy";
            case FORD_RANGER:
                return "Ford Ranger";
            case FORD_MUSTANG:
                return "Ford Mustang";
            case FORD_GT:
                return "Ford GT";
            case FORD_EDGE:
                return "Ford Edge";
            case CHEVROLET_SPARK:
                return "Chevrolet Spark";
            case CHEVROLET_SONIC:
                return "Chevrolet Sonic";
            case CHEVROLET_MALIBU:
                return "Chevrolet Malibu";
            case CHEVROLET_IMPALA:
                return "Chevrolet Impala";
            case CHEVROLET_CAMARO:
                return "Chevrolet Camaro";
            case CHEVROLET_CORVETTE:
                return "Chevrolet Corvette";
            case TOYOTA_YARIS:
                return "Toyota Yaris";
            case TOYOTA_COROLLA:
                return "Toyota Corolla";
            case TOYOTA_CAMRY:
                return "Toyota Camry";
            case TOYOTA_PRIUS:
                return "Toyota Prius";
            case TOYOTA_AVALON:
                return "Toyota Avalon";
            case TOYOTA_SUPRA:
                return "Toyota Supra";
            case HONDA_FIT:
                return "Honda Fit";
            case HONDA_CIVIC:
                return "Honda Civic";
            case HONDA_ACCORD:
                return "Honda Accord";
            case HONDA_INSIGHT:
                return "Honda Insight";
            case HONDA_CLARITY:
                return "Honda Clarity";
            case HONDA_S2000:
                return "Honda S2000";
            case NISSAN_VERSA:
                return "Nissan Versa";
            case NISSAN_SENTRA:
                return "Nissan Sentra";
            case NISSAN_ALTIMA:
                return "Nissan Altima";
            case NISSAN_MAXIMA:
                return "Nissan Maxima";
            case NISSAN_370Z:
                return "Nissan 370Z";
            case NISSAN_GT_R:
                return "Nissan GT-R";
            case HYUNDAI_ACCENT:
                return "Hyundai Accent";
            case HYUNDAI_ELANTRA:
                return "Hyundai Elantra";
            case HYUNDAI_SONATA:
                return "Hyundai Sonata";
            case HYUNDAI_AZERA:
                return "Hyundai Azera";
            case HYUNDAI_GENESIS:
                return "Hyundai Genesis";
            case HYUNDAI_EQUUS:
                return "Hyundai Equus";
            case KIA_RIO:
                return "Kia Rio";
            case KIA_FORTE:
                return "Kia Forte";
            case KIA_OPTIMA:
                return "Kia Optima";
            case KIA_STINGER:
                return "Kia Stinger";
            case KIA_K900:
                return "Kia K900";
            case KIA_SOUL:
                return "Kia Soul";
            case PEUGEOT_208:
                return "Peugeot 208";
            case PEUGEOT_308:
                return "Peugeot 308";
            case PEUGEOT_508:
                return "Peugeot 508";
            case PEUGEOT_2008:
                return "Peugeot 2008";
            case PEUGEOT_3008:
                return "Peugeot 3008";
            case PEUGEOT_5008:
                return "Peugeot 5008";
            case RENAULT_CLIO:
                return "Renault Clio";
            case RENAULT_MEGANE:
                return "Renault Megane";
            case RENAULT_LAGUNA:
                return "Renault Laguna";
            case RENAULT_SCENIC:
                return "Renault Scenic";
            case RENAULT_KADJAR:
                return "Renault Kadjar";
            case RENAULT_KOLEOS:
                return "Renault Koleos";
            case CITROEN_C1:
                return "Citroen C1";
            case CITROEN_C3:
                return "Citroen C3";
            case CITROEN_C4:
                return "Citroen C4";
            case CITROEN_C5:
                return "Citroen C5";
            case CITROEN_DS3:
                return "Citroen DS3";
            case CITROEN_DS4:
                return "Citroen DS4";
            case FIAT_500:
                return "Fiat 500";
            case FIAT_PANDA:
                return "Fiat Panda";
            case FIAT_PUNTO:
                return "Fiat Punto";
            case ALFA_ROMEO_GIULIA:
                return "Alfa Romeo Giulia";
            case ALFA_ROMEO_STELVIO:
                return "Alfa Romeo Stelvio";
            case ALFA_ROMEO_GIULIETTA:
                return "Alfa Romeo Giulietta";
            case ALFA_ROMEO_4C:
                return "Alfa Romeo 4C";
            case FERRARI_488:
                return "Ferrari 488";
            case FERRARI_F8:
                return "Ferrari F8";
            case FERRARI_ROMA:
                return "Ferrari Roma";
            case FERRARI_SF90:
                return "Ferrari SF90";
            case LAMBORGHINI_AVENTADOR:
                return "Lamborghini Aventador";
            case LAMBORGHINI_HURACAN:
                return "Lamborghini Huracan";
            case LAMBORGHINI_GALLARDO:
                return "Lamborghini Gallardo";
            case LAMBORGHINI_URUS:
                return "Lamborghini Urus";
            case MASERATI_GHIBLI:
                return "Maserati Ghibli";
            case MASERATI_QUATTROPORTE:
                return "Maserati Quattroporte";
            case MASERATI_GRANTURISMO:
                return "Maserati GranTurismo";
            case MASERATI_LEVANTE:
                return "Maserati Levante";
            case ASTON_MARTIN_VANTAGE:
                return "Aston Martin Vantage";
            case ASTON_MARTIN_DB11:
                return "Aston Martin DB11";
            case ASTON_MARTIN_DBX:
                return "Aston Martin DBX";
            case ASTON_MARTIN_RAPIDE:
                return "Aston Martin Rapide";
            case BENTLEY_CONTINENTAL:
                return "Bentley Continental";
            case BENTLEY_FLYING_SPUR:
                return "Bentley Flying Spur";
            case BENTLEY_BENTAYGA:
                return "Bentley Bentayga";
            case BENTLEY_MULSANNE:
                return "Bentley Mulsanne";
            case ROLLS_ROYCE_PHANTOM:
                return "Rolls-Royce Phantom";
            case ROLLS_ROYCE_GHOST:
                return "Rolls-Royce Ghost";
            case ROLLS_ROYCE_WRAITH:
                return "Rolls-Royce Wraith";
            case ROLLS_ROYCE_CULLINAN:
                return "Rolls-Royce Cullinan";
            case JAGUAR_XE:
                return "Jaguar XE";
            case JAGUAR_XF:
                return "Jaguar XF";
            case JAGUAR_XJ:
                return "Jaguar XJ";
            case JAGUAR_F_TYPE:
                return "Jaguar F-Type";
            case LAND_ROVER_DEFENDER:
                return "Land Rover Defender";
            case LAND_ROVER_DISCOVERY:
                return "Land Rover Discovery";
            case LAND_ROVER_FREELANDER:
                return "Land Rover Freelander";
            case LAND_ROVER_RANGE_ROVER:
                return "Land Rover Range Rover";
            case TESLA_MODEL_S:
                return "Tesla Model S";
            case TESLA_MODEL_3:
                return "Tesla Model 3";
            case TESLA_MODEL_X:
                return "Tesla Model X";
            case TESLA_MODEL_Y:
                return "Tesla Model Y";
            case VOLVO_S60:
                return "Volvo S60";
            case VOLVO_S90:
                return "Volvo S90";
            case VOLVO_V60:
                return "Volvo V60";
            case VOLVO_V90:
                return "Volvo V90";
            case SUBARU_IMPREZA:
                return "Subaru Impreza";
            case SUBARU_LEGACY:
                return "Subaru Legacy";
            case SUBARU_FORESTER:
                return "Subaru Forester";
            case SUBARU_OUTBACK:
                return "Subaru Outback";
            case MAZDA2:
                return "Mazda2";
            case MAZDA3:
                return "Mazda3";
            case MAZDA6:
                return "Mazda6";
            case MAZDA_CX_3:
                return "Mazda CX-3";
            case SUZUKI_SWIFT:
                return "Suzuki Swift";
            case SUZUKI_SX4:
                return "Suzuki SX4";
            case SUZUKI_VITARA:
                return "Suzuki Vitara";
            case SUZUKI_JIMNY:
                return "Suzuki Jimny";
            case DODGE_CHALLENGER:
                return "Dodge Challenger";
            case DODGE_CHARGER:
                return "Dodge Charger";
            case DODGE_DURANGO:
                return "Dodge Durango";
            case DODGE_GRAND_CARAVAN:
                return "Dodge Grand Caravan";
            case JEEP_WRANGLER:
                return "Jeep Wrangler";
            case JEEP_GRAND_CHEROKEE:
                return "Jeep Grand Cherokee";
            case JEEP_CHEROKEE:
                return "Jeep Cherokee";
            case JEEP_COMPASS:
                return "Jeep Compass";
            case CADILLAC_ATS:
                return "Cadillac ATS";
            case CADILLAC_CTS:
                return "Cadillac CTS";
            case CADILLAC_XTS:
                return "Cadillac XTS";
            case CADILLAC_ESCALADE:
                return "Cadillac Escalade";
            case HARLEY_DAVIDSON_SPORTSTER:
                return "Harley-Davidson Sportster";
            case HARLEY_DAVIDSON_SOFTAIL:
                return "Harley-Davidson Softail";
            case HARLEY_DAVIDSON_TOURING:
                return "Harley-Davidson Touring";
            case DUCATI_MONSTER:
                return "Ducati Monster";
            case DUCATI_MULTISTRADA:
                return "Ducati Multistrada";
            case DUCATI_PANIGALE:
                return "Ducati Panigale";
            case YAMAHA_YZF:
                return "Yamaha YZF";
            case YAMAHA_MT:
                return "Yamaha MT";
            case YAMAHA_XSR:
                return "Yamaha XSR";
            case KAWASAKI_NINJA:
                return "Kawasaki Ninja";
            case KAWASAKI_Z:
                return "Kawasaki Z";
            case KAWASAKI_VERSYS:
                return "Kawasaki Versys";
            case SUZUKI_GSX:
                return "Suzuki GSX";
            case SUZUKI_V_STROM:
                return "Suzuki V-Strom";
            case SUZUKI_SV:
                return "Suzuki SV";
            case WINNEBAGO_MINNIE:
                return "Winnebago Minnie";
            case WINNEBAGO_MICRO_MINNIE:
                return "Winnebago Micro Minnie";
            case WINNEBAGO_REVEL:
                return "Winnebago Revel";
            case CHRYSLER_PACIFICA:
                return "Chrysler Pacifica";
            case CHRYSLER_VOYAGER:
                return "Chrysler Voyager";
            case CHRYSLER_GRAND_VOYAGER:
                return "Chrysler Grand Voyager";
            default:
                return model.name().replace('_', ' ').toLowerCase();
        }
    }
    private String vehicleTypeConverter(VehicleTypes vehicleTypes) {
        switch (vehicleTypes) {
            case CAMPER:
                return "Camper";
            case CONVERTIBLE:
                return "Convertible";
            case COUPE:
                return "Coupe";
            case HATCHBACK:
                return "Hatchback";
            case MINIVAN:
                return "Minivan";
            case MOTORCYCLE:
                return "Motorcycle";
            case PICKUP:
                return "Pickup";
            case SEDAN:
                return "Sedan";
            case SUV:
                return "SUV";
            default:
                return vehicleTypes.name().toLowerCase();
        }
    }
    private String GearBoxConverter(GearBox gearBox) {
        switch (gearBox) {
            case AUTOMATIC:
                return "Automatic";
            case MANUAL:
                return "Manual";
            default:
                return gearBox.name().toLowerCase();
        }
    }
    private String FuelTypeConverter(FuelType fuelType) {
        switch (fuelType) {
            case PETROL:
                return "Petrol";
            case DIESEL:
                return "Diesel";
            case ELECTRIC:
                return "Electric";
            case HYBRID:
                return "Hybrid";
            default:
                return fuelType.name().toLowerCase();
        }
    }
    private String ColorConverter(Color color) {
        switch (color) {
            case BLACK:
                return "Black";
            case BLUE:
                return "Blue";
            case GRAY:
                return "Gray";
            case GREEN:
                return "Green";
            case ORANGE:
                return "Orange";
            case PURPLE:
                return "Purple";
            case RED:
                return "Red";
            case WHITE:
                return "White";
            case YELLOW:
                return "Yellow";
            default:
                return color.name().toLowerCase();
        }
    }
    private int YearConverter(Year year) {
        switch (year) {
            case Y2019:
                return 2019;
            case Y2020:
                return 2020;
            case Y2021:
                return 2021;
            case Y2022:
                return 2022;
            case Y2023:
                return 2023;
            case Y2024:
                return 2024;
            default:
                return 0;
        }
    }
    private String BrandConverter(Brand brand){
        switch (brand){
            case AUDI:
                return "Audi";
            case BMW:
                return "BMW";
            case MERCEDES_BENZ:
                return "Mercedes-Benz";
            case VOLKSWAGEN:
                return "Volkswagen";
            case PORSCHE:
                return "Porsche";
            case OPEL:
                return "Opel";
            case FORD:
                return "Ford";
            case CHEVROLET:
                return "Chevrolet";
            case TOYOTA:
                return "Toyota";
            case HONDA:
                return "Honda";
            case NISSAN:
                return "Nissan";
            case HYUNDAI:
                return "Hyundai";
            case KIA:
                return "Kia";
            case PEUGEOT:
                return "Peugeot";
            case RENAULT:
                return "Renault";
            case CITROEN:
                return "Citroen";
            case FIAT:
                return "Fiat";
            case ALFA_ROMEO:
                return "Alfa Romeo";
            case FERRARI:
                return "Ferrari";
            case LAMBORGHINI:
                return "Lamborghini";
            case MASERATI:
                return "Maserati";
            case ASTON_MARTIN:
                return "Aston Martin";
            case BENTLEY:
                return "Bentley";
            case ROLLS_ROYCE:
                return "Rolls-Royce";
            case JAGUAR:
                return "Jaguar";
            case LAND_ROVER:
                return "Land Rover";
            case TESLA:
                return "Tesla";
            case VOLVO:
                return "Volvo";
            case SUBARU:
                return "Subaru";
            case MAZDA:
                return "Mazda";
            case SUZUKI:
                return "Suzuki";
            case WINNEBAGO:
                return "Winnebago";
            case CHRYSLER:
                return "Chrysler";
            case DODGE:
                return "Dodge";
            case JEEP:
                return "Jeep";
            case CADILLAC:
                return "Cadillac";
            case HARLEY_DAVIDSON:
                return "Harley-Davidson";
            case DUCATI:
                return "Ducati";
            case YAMAHA:
                return "Yamaha";
            case KAWASAKI:
                return "Kawasaki";
            default:
                return brand.name().toLowerCase();
        }
    }

    public void changeEmailButtonPressed(ActionEvent actionEvent) {
        Customer customer = new WorkWithJSON().findCustomerById(usernameLabel.getText());
        CustomerDataFunctions customerDataFunctions = new CustomerDataFunctions();
        String oldEmail = oldEmailField.getText();
        String newEmail = newEmailField.getText();
        if (newEmail.isEmpty()) {
            displayError("Please enter a valid email");
        }
        if (!newEmail.contains("@") || !newEmail.contains(".")) {
            displayError("Please enter a valid email");
        }
        if(oldEmail.equals(newEmail)){
            displayError("Please enter a different email");
        }
        if(!oldEmail.equals(customer.getEmail())) {
            displayError("Please enter a valid email");
        }
        customerDataFunctions.changeEmail(newEmail, customer.getId());
    }

    public void changeAddressButtonPressed(ActionEvent actionEvent) {
        Customer customer = new WorkWithJSON().findCustomerById(usernameLabel.getText());
        CustomerDataFunctions customerDataFunctions = new CustomerDataFunctions();
        String newAddress = newAddressArea.getText();
        if (newAddress.isEmpty()) {
            displayError("Please enter a valid address");
        }
        customerDataFunctions.changeAddress(newAddress, customer.getId());
    }

    public void changeNumberButtonPressed(ActionEvent actionEvent) {
        Customer customer = new WorkWithJSON().findCustomerById(usernameLabel.getText());
        CustomerDataFunctions customerDataFunctions = new CustomerDataFunctions();
        String oldNumber = oldPhoneNumber.getText();
        String newNumber = newPhoneNumber.getText();
        if (newNumber.isEmpty()) {
            displayError("Please enter a valid phone number");
        }
        if (newNumber.length() != 10) {
            displayError("Please enter a valid phone number");
        }
        if(newNumber.contains("[a-zA-Z]+")){
            displayError("Please enter a valid phone number");
        }
        if(oldNumber.equals(newNumber)){
            displayError("Please enter a different phone number");
        }
        if(!oldNumber.equals(customer.getPhone())) {
            displayError("Please enter a valid phone number");
        }
        customerDataFunctions.changeMobilePhoneNumber(newNumber, customer.getId());
    }
    public void changePasswordButtonPressed(ActionEvent actionEvent) {
        Customer customer = new WorkWithJSON().findCustomerById(usernameLabel.getText());
        CustomerDataFunctions customerDataFunctions = new CustomerDataFunctions();
        String currentPassword = currentPasswordField.getText();
        String newPassword = newPasswordField.getText();
        if (newPassword.isEmpty()) {
            displayError("Please enter a valid password");
        }
        if(currentPassword.equals(newPassword)){
            displayError("Please enter a different password");
        }
        if(!currentPassword.equals(customer.getPassword())) {
            displayError("Incorrect password");
        }
        if(newPassword.contains(" ")){
            displayError("Password cannot contain space");
        }
        customerDataFunctions.changePassword(newPassword, customer.getId());
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
    public void displayCustomerInfo() {
        WorkWithJSON workWithJSON = new WorkWithJSON();
        Customer customer = workWithJSON.findCustomerById(usernameLabel.getText());

        String customerInfo = "Name: " + customer.getName() + "\n" +
                "Surname: " + customer.getSurname() + "\n" +
                "Age: " + customer.getAge() + "\n" +
                "Phone: " + customer.getPhone() + "\n" +
                "Email: " + customer.getEmail() + "\n" +
                "Address: " + customer.getAddress() + "\n";

        accountDescLabel.setText(customerInfo);
    }
}
