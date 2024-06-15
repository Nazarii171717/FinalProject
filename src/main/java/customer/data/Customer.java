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

    public Customer(String name, String surname, int age, String phone, String email, String address, String id, String password) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.id = id;
        this.password = password;
        this.rentalHistories = new ArrayList<>();
        this.discount = 0;
    }
}
