package renting;

import customer.data.Customer;
import lombok.*;
import vehicle.data.Vehicle;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NonNull
@ToString
public class RentalInformation {
    private String id;
    private String vehicleId;
    private String customerId;
    private int duration; //in days
    public LocalDateTime rentalDate;
    public LocalDateTime returnDate;
    public  RentingStatus rentingStatus;
}
