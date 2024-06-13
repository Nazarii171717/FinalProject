package renting;

import parsingCSV.WorkWithJSON;

import java.time.LocalDateTime;

public class RentalFunctions {

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
        workWithJSON.addRentalInformationRecord(vehicleId, customerId, duration,
                rentalDate, returnDate, RentingStatus.IN_PROCESS);}
    }

    // TODO yyyy-mm-dd hh:mm:ss
    // TODO RENT VEHICLE FOR A
    public void reserveVehicleForADAte(String vehicleId, String customerId,
                               int duration, LocalDateTime reservationDate) {
        LocalDateTime rentalDate = reservationDate;
        LocalDateTime returnDate = rentalDate.plusDays(duration);

        boolean isReserved = workWithJSON.findVehicleById(vehicleId).isReserved();
        if (isReserved) {
            System.out.println("Car is reserved");
        } else {
            System.out.println("You reserved vehicle");

            workWithJSON.updateVehicleData(vehicleId, true);
            workWithJSON.addRentalInformationRecord(vehicleId, customerId, duration,
                    rentalDate, returnDate, RentingStatus.NOT_STARTED);
        }
    }

    public void returnVehicle(String rentalInformationId)
    {
        RentalInformation rentalInformation = workWithJSON.findRentalInformationById(rentalInformationId);
        workWithJSON.updateVehicleData(rentalInformation.getVehicleId(), false);
        workWithJSON.updateRentalInformation(rentalInformationId);
        workWithJSON.updateCustomerData(rentalInformation.getCustomerId(), rentalInformation);
    }


}
