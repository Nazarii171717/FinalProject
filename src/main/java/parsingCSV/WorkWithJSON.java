package parsingCSV;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import customer.data.Customer;
import customer.data.RentalHistory;
import generalFunctionality.LocalDateTimeAdapter;
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
import renting.RentalFunctions;
import renting.RentalInformation;
import renting.RentingStatus;
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

        String idStr = id.toString();

        String idf = allId.stream().filter(id1 -> id1.equals(idStr)).findFirst().orElse(null);
        if (idf != null)
        {
            id = new StringBuilder(generateUniqueId());
        }
        allId.add(String.valueOf(id));
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

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();

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
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();

        String jsonContent = Files.readString(path);
        JSONArray jsonArray = new JSONArray(jsonContent);

        ArrayList<RentalInformation> rI = new ArrayList<>();
        for (Object jsonObject : jsonArray)
        {
            RentalInformation rentalInformation = gson.fromJson(String.valueOf(jsonObject),
                    RentalInformation.class);
            rI.add(rentalInformation);
        }


        RentalInformation rentalInformation = rI.stream()
                .filter(rI1 -> rI1.getId().equals(rentalInformationId))
                .findFirst() // id is unique but it requires this function
                .orElse(null);
        return rentalInformation;
    }


    @SneakyThrows
    public String addRentalInformationRecord(String vehicleId, String customerId,
                                           int duration, LocalDateTime rentalDate,
                                           LocalDateTime returnDate, RentingStatus rs)
    {
        String id = generateUniqueId();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("vehicleId", vehicleId);
        jsonObject.put("customerId", customerId);
        jsonObject.put("duration", duration);
        jsonObject.put("rentalDate", rentalDate);
        jsonObject.put("returnDate", returnDate);
        jsonObject.put("rentingStatus", rs);

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
        return id;
    }


    @SneakyThrows
    public void addCustomer(String name, String surname, int age,
                            String phone, String email, String address, String id,
                            String password, ArrayList<RentalHistory> rentalHistories)
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
        jsonObject.put("discount", 0);

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

    public int findIndexOfJsonObject(JSONArray jsonArray, String uniqueId) {
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if (jsonObject.has("id") && jsonObject.getString("id").equals(uniqueId)) {
                return i;
            }
        }
        return -1;
    }

    @SneakyThrows
    // TODO don't use it directly
    public void updateVehicleData(String vehicleId, boolean isReserved)
    {
        Vehicle vehicle = findVehicleById(vehicleId);
        vehicle.setReserved(isReserved);

        FileReader reader = new FileReader(vehiclesDataJSON);
        int i;
        StringBuilder jsonString = new StringBuilder();
        while ((i = reader.read()) != -1) {
            jsonString.append((char) i);
        }
        reader.close();

        JSONArray jsonArray = new JSONArray(jsonString.toString());
        int indexOfVehicle = findIndexOfJsonObject(jsonArray, vehicleId);

        jsonArray.remove(indexOfVehicle);

        Gson gson = new Gson();
        String vehicleAsJsonObject = gson.toJson(vehicle);

        JSONObject jsonVehicle = new JSONObject(vehicleAsJsonObject);
        jsonArray.put(jsonVehicle);

        FileWriter writer = new FileWriter(vehiclesDataJSON);
        writer.write(jsonArray.toString());
        writer.close();
    }

    @SneakyThrows
    // TODO don't use it directly
    public void updateCustomerData(String customerId, RentalInformation rI)
    {
        Customer customer = findCustomerById(customerId);
        ArrayList<RentalInformation> list = new ArrayList<>();
        if (customer.getRentalHistories() != null)
        {
            list = customer.getRentalHistories();
        }
        //ArrayList<RentalInformation> list = customer.getRentalHistories();
        if (!list.removeIf(rentalInformation -> rentalInformation.getId().equals(rI.getId())))
        {
            customer.setDiscount(customer.getDiscount() + 0.01);
        }
        list.add(rI);
        customer.setRentalHistories(list);

        FileReader reader = new FileReader(customersDataJSON);
        int i;
        StringBuilder jsonString = new StringBuilder();
        while ((i = reader.read()) != -1) {
            jsonString.append((char) i);
        }
        reader.close();

        JSONArray jsonArray = new JSONArray(jsonString.toString());
        int indexOfCustomer = findIndexOfJsonObject(jsonArray, customerId);

        jsonArray.remove(indexOfCustomer);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
        String customerAsJsonObject = gson.toJson(customer);

        JSONObject jsonCustomer = new JSONObject(customerAsJsonObject);
        jsonArray.put(jsonCustomer);

        FileWriter writer = new FileWriter(customersDataJSON);
        writer.write(jsonArray.toString());
        writer.close();
    }


    @SneakyThrows
    // TODO don't use it directly
    public void updateRentalInformation(String rentalInformationId, RentingStatus status)
    {
        RentalInformation rentalInformation = findRentalInformationById(rentalInformationId);
        rentalInformation.setRentingStatus(status);

        FileReader reader = new FileReader(rentalInformationJSON);
        int i;
        StringBuilder jsonString = new StringBuilder();
        while ((i = reader.read()) != -1) {
            jsonString.append((char) i);
        }
        reader.close();

        JSONArray jsonArray = new JSONArray(jsonString.toString());
        int indexOfRentalInformation = findIndexOfJsonObject(jsonArray, rentalInformationId);

        jsonArray.remove(indexOfRentalInformation);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
        String rentalInformationAsJsonObject = gson.toJson(rentalInformation);

        JSONObject jsonCustomer = new JSONObject(rentalInformationAsJsonObject);
        jsonArray.put(jsonCustomer);

        FileWriter writer = new FileWriter(rentalInformationJSON);
        writer.write(jsonArray.toString());
        writer.close();
    }
}
