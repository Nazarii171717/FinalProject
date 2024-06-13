package parsingCSV;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import customer.data.Customer;
import customer.data.RentalHistory;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import vehicle.data.Vehicle;

public class WorkWithCSV {

    private final String vehicleDataJSON = "src/main/resources/VehiclesData.json";
    private final String customersDataJSON = "src/main/resources/CustomersData.json";
    private final String rentalInformationJSON = "src/main/resources/RentalInformation.json";



    @SneakyThrows
    public Vehicle findVehicleById(String vehicleId)
    {
        Path path = Path.of(vehicleDataJSON);

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

        Vehicle vehicle = vehicles.stream()
                .filter(vehicle1 -> vehicle1.getId().equals(vehicleId))
                .findFirst() // id is unique but it requires this function
                .orElse(null);
        return vehicle;
    }

    public Customer findCustomerById(String customerId)
    {
        return null;
    }

    public void addVehicle(String id, String type, String brand, String model,
     int year, String vin, String color, double maxSpeed, double maxLoad, double engine,
     double fuelTankCapacity, double fuelConsumption, String engineType, String fuelType,
     String gearBox, double mileage, int numberOfSeats, boolean isReserved)
    {
    }

    //  TODO implement method which write the data about new renting
    //   to rentalinformation.json following the structure of RentalInformation class
    @SneakyThrows
    public void addRentalInformationRecord(String operationId, String vehicleId, String customerId,
                                           int duration, LocalDateTime rentalDate, LocalDateTime returnDate)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("operationId", operationId);
        jsonObject.put("vehicleId", vehicleId);
        jsonObject.put("customerId", customerId);
        jsonObject.put("duration", duration);
        jsonObject.put("rentalDate", rentalDate);
        jsonObject.put("returnDate", returnDate);

        FileReader reader = new FileReader(rentalInformationJSON);
        int i;
        StringBuilder jsonString = new StringBuilder();
        while ((i = reader.read()) != -1) {
            jsonString.append((char) i);
        }
        reader.close();

        JSONArray jsonArray = new JSONArray(jsonString.toString());

        jsonArray.put(jsonObject);

        FileWriter writer = new FileWriter(rentalInformationJSON);
        writer.write(jsonArray.toString());
        writer.close();
    }


    @SneakyThrows
    public void addCustomer(String name, String surname, int age,
                            String phone, String email, String address, String id,
                            String password, ArrayList<RentalHistory> rentalHistories, double discount)
    {
        /*Customer customer = new Customer(name, surname,
                45, phone,email, address, id, password,
                new ArrayList<RentalHistory>(), 0.04);
*/
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("surname", surname);
        jsonObject.put("age", age);
        jsonObject.put("phone", phone);
        jsonObject.put("email", email);
        jsonObject.put("address", address);
        jsonObject.put("id", id);
        jsonObject.put("password", password);
        jsonObject.put("rentalHistories", rentalHistories);
        jsonObject.put("discount", discount);

        FileReader reader = new FileReader(customersDataJSON);
        int i;
        StringBuilder jsonString = new StringBuilder();
        while ((i = reader.read()) != -1) {
            jsonString.append((char) i);
        }
        reader.close();

        JSONArray jsonArray = new JSONArray(jsonString.toString());

        jsonArray.put(jsonObject);

        FileWriter writer = new FileWriter(customersDataJSON);
        writer.write(jsonArray.toString());
        writer.close();
    }
}
