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

    private VehicleTypes vehicleTypes; //enum

    private Brand brand;  //enum
    private Model model; //enum
    private Year year; //enum

    private String vin;

    private Color color; //enum
    private String maxSpeed;
    private double maxLoad;
    private double engine;
    private double fuelTankCapacity;
    private double fuelConsumption;
    private String engineType;
    private FuelType fuelType; //enum
    private GearBox gearBox; //enum
    private double mileage;
    private int numberOfSeats;
    private boolean isReserved;
    private PricePerDay pricePerDay; //enum


}
