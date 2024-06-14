package vehicle.data;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NonNull
@ToString

public class Vehicle
{
    private String id;
    private String typeOfVehicle;
    private String type;
    private String brand;
    private String model;
    private int year;
    private String vin;
    private String color;
    private double maxSpeed;
    private double maxLoad;
    private double engine;
    private double fuelTankCapacity;
    private double fuelConsumption;
    private String engineType;
    private String fuelType;
    private String gearBox;
    private double mileage;
    private int numberOfSeats;
    private boolean isReserved;
    private double pricePerDay;



    private VehicleTypes vehicleTypes;
}
