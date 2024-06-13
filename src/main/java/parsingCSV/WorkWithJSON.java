package parsingCSV;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import customer.data.Customer;
import customer.data.RentalHistory;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import renting.RentalInformation;
import vehicle.data.Vehicle;


public class WorkWithJSON {

    private final String vehiclesDataJSON = "src/main/resources/VehiclesData.json";
    private final String customersDataJSON = "src/main/resources/CustomersData.json";
    private final String rentalInformationJSON = "src/main/resources/RentalInformation.json";

    private ArrayList<String> allId = new ArrayList<>();

    public String generateUniqueId()
    {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder id = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < 5; i++) {
            id.append(characters.charAt(rnd.nextInt(characters.length())));
        }


        String idf = allId.stream().filter(id1 -> id1.equals(id)).findFirst().orElse(null);
        if (!idf.equals(null))
        {
            id = generateUniqueId();
        }
        return String.valueOf(id);
    }


    @SneakyThrows
    public Vehicle findVehicleById(String vehicleId)
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

        Vehicle vehicle = vehicles.stream()
                .filter(vehicle1 -> vehicle1.getId().equals(vehicleId))
                .findFirst() // id is unique but it requires this function
                .orElse(null);
        return vehicle;
    }

    @SneakyThrows
    public Customer findCustomerById(String customerId)
    {
        Path path = Path.of(customersDataJSON);

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        String jsonContent = Files.readString(path);
        JSONArray jsonArray = new JSONArray(jsonContent);

        ArrayList<Customer> customers = new ArrayList<>();
        for (Object jsonObject : jsonArray)
        {
           Customer customer = gson.fromJson(String.valueOf(jsonObject), Customer.class);
            customers.add(customer);
        }

        Customer customer = customers.stream()
                .filter(customer1 -> customer1.getId().equals(customerId))
                .findFirst() // id is unique but it requires this function
                .orElse(null);
        return customer;
    }


    @SneakyThrows
    public RentalInformation findRentalInformationById(String rentalInformationId)
    {
        Path path = Path.of(rentalInformationJSON);

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        String jsonContent = Files.readString(path);
        JSONArray jsonArray = new JSONArray(jsonContent);

        ArrayList<RentalInformation> customers = new ArrayList<>();
        for (Object jsonObject : jsonArray)
        {
            RentalInformation rentalInformation = gson.fromJson(String.valueOf(jsonObject), RentalInformation.class);
            customers.add(rentalInformation);
        }

        RentalInformation rentalInformation = customers.stream()
                .filter(rentalInformation1 -> rentalInformation1.getId().equals(rentalInformationId))
                .findFirst() // id is unique but it requires this function
                .orElse(null);
        return rentalInformation;
    }



   /* public void addVehicle(String id, String type, String brand, String model,
     int year, String vin, String color, double maxSpeed, double maxLoad, double engine,
     double fuelTankCapacity, double fuelConsumption, String engineType, String fuelType,
     String gearBox, double mileage, int numberOfSeats, boolean isReserved)
    {
    }*/

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
