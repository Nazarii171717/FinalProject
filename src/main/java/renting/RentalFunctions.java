package renting;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import generalFunctionality.LocalDateTimeAdapter;
import lombok.SneakyThrows;
import org.json.JSONArray;
import parsingCSV.WorkWithJSON;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class RentalFunctions {

    private final String rentalInformationJSON = "src/main/resources/RentalInformation.json";
    private WorkWithJSON workWithJSON = new WorkWithJSON();
    // TODO RENT VEHICLE RIGHT NOW
    public void rentVehicle(String vehicleId, String customerId,
                            int duration /*in days*/)
    {
        boolean isReserved = workWithJSON.findVehicleById(vehicleId).isReserved();
        if (isReserved)
        {
            System.out.println("Vehicle is reserved");
        }

        else {
            System.out.println("You reserved vehicle");
        LocalDateTime rentalDate = LocalDateTime.now();
        LocalDateTime returnDate = rentalDate.plusDays(duration);

        workWithJSON.updateVehicleData(vehicleId, true);
        String id = workWithJSON.addRentalInformationRecord(vehicleId, customerId, duration,
                rentalDate, returnDate, RentingStatus.IN_PROCESS);
        workWithJSON.updateCustomerData(customerId, workWithJSON.findRentalInformationById(id));
        }

    }

    // TODO yyyy-mm-dd hh:mm:ss
    // TODO RENT VEHICLE FOR A SPECIFIC DATE
    public void reserveVehicleForADAte(String vehicleId, String customerId,
                               int duration, LocalDateTime reservationDate) {
        LocalDateTime rentalDate = reservationDate;
        // we can change to .plusMinutes
        LocalDateTime returnDate = rentalDate.plusDays(duration);

        boolean isReserved = workWithJSON.findVehicleById(vehicleId).isReserved();
        if (isReserved) {
            System.out.println("Car is reserved");
        } else {
            System.out.println("You reserved vehicle");

            workWithJSON.updateVehicleData(vehicleId, true);
            String id = workWithJSON.addRentalInformationRecord(vehicleId, customerId, duration,
                    rentalDate, returnDate, RentingStatus.NOT_STARTED);
            workWithJSON.updateCustomerData(customerId, workWithJSON.findRentalInformationById(id));

        }
    }

    public void returnVehicle(String rentalInformationId)
    {
        RentalInformation rentalInformation = workWithJSON.findRentalInformationById(rentalInformationId);
        workWithJSON.updateVehicleData(rentalInformation.getVehicleId(), false);
        workWithJSON.updateRentalInformation(rentalInformationId, RentingStatus.FINISHED);
        rentalInformation.setRentingStatus(RentingStatus.FINISHED);
        workWithJSON.updateCustomerData(rentalInformation.getCustomerId(), rentalInformation);
    }

    // TODO it checks the renting status of all vehicles,
    //  if the rent is expired it returns the vehicle to be free
    @SneakyThrows
    public void checkTheStatusOfAllVehicles()
    {
        Path path = Path.of(rentalInformationJSON);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();

        String jsonContent = Files.readString(path);
        JSONArray jsonArray = new JSONArray(jsonContent);

        ArrayList<RentalInformation> rentalInformations = new ArrayList<>();
        for (Object jsonObject : jsonArray)
        {
            RentalInformation rentalInformation = gson.fromJson(String.valueOf(jsonObject),
                    RentalInformation.class);
            rentalInformations.add(rentalInformation);
        }


        for (RentalInformation rI : rentalInformations)
        {
            if (!rI.getRentingStatus().equals(RentingStatus.FINISHED))
            {
                LocalDateTime currentDate = LocalDateTime.now();
                LocalDateTime rentalDate = rI.getRentalDate();
                LocalDateTime returnDate = rI.getReturnDate();

                if (rI.getRentingStatus().equals(RentingStatus.IN_PROCESS))
                {
                    if (returnDate.isBefore(currentDate))
                    {
                        returnVehicle(rI.getId());
                    }
                }
                else if (rI.getRentingStatus().equals(RentingStatus.NOT_STARTED))
                {
                    if (returnDate.isBefore(currentDate))
                    {
                        returnVehicle(rI.getId());
                    }
                    if (rentalDate.isBefore(currentDate) && returnDate.isAfter(currentDate))
                    {
                        workWithJSON.updateRentalInformation(rI.getId(), RentingStatus.IN_PROCESS);
                        workWithJSON.updateCustomerData(rI.getCustomerId(), rI);
                    }
                }
            }
        }
    }
}
