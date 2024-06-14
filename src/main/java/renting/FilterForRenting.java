package renting;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import org.json.JSONArray;
import vehicle.data.Vehicle;
import vehicle.data.VehicleTypes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FilterForRenting {
    private final String vehiclesDataJSON = "src/main/resources/VehiclesData.json";
    @SneakyThrows
    public ArrayList<Vehicle> displayAllAvailableVehicles()
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

        vehicles.removeIf(Vehicle::isReserved);

        vehicles.removeIf(vehicle -> vehicle.getVehicleTypes() != VehicleTypes.CAR);
        return vehicles;

    }

   /* public ArrayList<Vehicle> displayVehiclesAfterFilter()
    {

    }*/
}
