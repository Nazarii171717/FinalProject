package customer.data;

import lombok.*;
import renting.RentalFunctions;
import renting.RentalInformation;

import java.util.ArrayList;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class Customer {
    private String name;
    private String surname;
    private int age;
    private String phone;
    private String email;
    private String address;
    private String id;
    private String password;
    private ArrayList<RentalInformation> rentalHistories;
    private double discount;


}
