package renting;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import org.json.JSONArray;
import vehicle.data.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FilterForRenting {
    private final String vehiclesDataJSON = "src/main/resources/VehiclesData.json";

    // TODO gets list with all vehicles
    @SneakyThrows
    public ArrayList<Vehicle> getListWithVehicles()
    {
        Path path = Path.of(vehiclesDataJSON);

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        String jsonContent = Files.readString(path);
        JSONArray jsonArray = new JSONArray(jsonContent);

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Object jsonObject : jsonArray)
        {
            Vehicle vehicle = gson.fromJson(String.valueOf(jsonObject), Vehicle.class);
            vehicles.add(vehicle);
        }

        return vehicles;
    }

    @SneakyThrows
    public ArrayList<Vehicle> displayAllAvailableVehicles()
    {
        ArrayList<Vehicle> vehicles = getListWithVehicles();
        vehicles.removeIf(Vehicle::isReserved);
        return vehicles;
    }

    public ArrayList<Vehicle> displayForSpecificColor(Color color)
    {
        ArrayList<Vehicle> vehicles = getListWithVehicles();
        vehicles.removeIf(vehicle -> vehicle.getColor() != color);
        return vehicles;
    }

    public ArrayList<Vehicle> displayForSpecificYear(Year year)
    {
        ArrayList<Vehicle> vehicles = getListWithVehicles();
        vehicles.removeIf(vehicle -> vehicle.getYear() != year);
        return vehicles;
    }

    public ArrayList<Vehicle> displayForSpecificBrand(Brand brand)
    {
        ArrayList<Vehicle> vehicles = getListWithVehicles();
        vehicles.removeIf(vehicle -> vehicle.getBrand() != brand);
        return vehicles;
    }

    public ArrayList<Vehicle> displayForSpecificModel(Model model)
    {
        ArrayList<Vehicle> vehicles = getListWithVehicles();
        vehicles.removeIf(vehicle -> vehicle.getModel() != model);
        return vehicles;
    }

    public ArrayList<Vehicle> displayForSpecificFuelType(FuelType fuelType)
    {
        ArrayList<Vehicle> vehicles = getListWithVehicles();
        vehicles.removeIf(vehicle -> vehicle.getFuelType() != fuelType);
        return vehicles;
    }


    public ArrayList<Vehicle> displayForSpecificGearBox(GearBox gearBox)
    {
        ArrayList<Vehicle> vehicles = getListWithVehicles();
        vehicles.removeIf(vehicle -> vehicle.getGearBox() != gearBox);
        return vehicles;
    }

    public ArrayList<Vehicle> displayForSpecificPricePerDay(PricePerDay pricePerDay)
    {
        ArrayList<Vehicle> vehicles = getListWithVehicles();
        vehicles.removeIf(vehicle -> vehicle.getPricePerDay() != pricePerDay);
        return vehicles;
    }
    public ArrayList<Vehicle> displayForSpecificVehicleType(VehicleTypes vehicleTypes)
    {
        ArrayList<Vehicle> vehicles = getListWithVehicles();
        vehicles.removeIf(vehicle -> vehicle.getVehicleTypes() != vehicleTypes);
        return vehicles;
    }

}
