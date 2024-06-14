package customer.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import generalFunctionality.LocalDateTimeAdapter;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;
import parsingCSV.WorkWithJSON;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;


public class CustomerDataFunctions {
    private final String customersDataJSON = "src/main/resources/CustomersData.json";
    WorkWithJSON workWithJSON = new WorkWithJSON();

    @SneakyThrows
    // TODO dont use this method directly
    public void update(String customerId, Customer customer)
    {
        FileReader reader = new FileReader(customersDataJSON);
        int i;
        StringBuilder jsonString = new StringBuilder();
        while ((i = reader.read()) != -1) {
            jsonString.append((char) i);
        }
        reader.close();

        JSONArray jsonArray = new JSONArray(jsonString.toString());
        int indexOfCustomer = workWithJSON.findIndexOfJsonObject(jsonArray, customerId);

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
    public void changePassword(String newPassword,String customerId)
    {
        Customer customer = workWithJSON.findCustomerById(customerId);
        if (!customer.getPassword().equals(newPassword))
        {
            customer.setPassword(newPassword);
            update(customerId, customer);
        }
        else
        {
            System.out.println("The password was not changed. It is the same");
        }
    }

    public void changeMobilePhoneNumber(String newNumber,String customerId)
    {
        Customer customer = workWithJSON.findCustomerById(customerId);
        if (!customer.getPhone().equals(newNumber))
        {
            customer.setPhone(newNumber);
            update(customerId, customer);
        }
        else
        {
            System.out.println("The phone number was not changed. It is the same");
        }
    }

    public void changeEmail(String newEmail,String customerId)
    {
        Customer customer = workWithJSON.findCustomerById(customerId);
        if (!customer.getEmail().equals(newEmail))
        {
            customer.setEmail(newEmail);
            update(customerId, customer);
        }
        else
        {
            System.out.println("The email was not changed. It is the same");
        }
    }

    public void changeAddress(String newAddress, String customerId)
    {
        Customer customer = workWithJSON.findCustomerById(customerId);
        if (!customer.getAddress().equals(newAddress))
        {
            customer.setAddress(newAddress);
            update(customerId, customer);
        }
        else
        {
            System.out.println("The address was not changed. It is the same");
        }
    }

    public void changeName(String newName, String customerId)
    {
        Customer customer = workWithJSON.findCustomerById(customerId);
        if (!customer.getName().equals(newName))
        {
            customer.setName(newName);
            update(customerId, customer);
        }
        else
        {
            System.out.println("The name was not changed. It is the same");
        }
    }
    public void changeSurname(String newSurname, String customerId)
    {
        Customer customer = workWithJSON.findCustomerById(customerId);
        if (!customer.getSurname().equals(newSurname))
        {
            customer.setSurname(newSurname);
            update(customerId, customer);
        }
        else
        {
            System.out.println("The surname was not changed. It is the same");
        }
    }
}
