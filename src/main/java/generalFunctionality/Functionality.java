package generalFunctionality;

import customer.data.CustomerDataFunctions;
import customer.data.RentalHistory;
import parsingCSV.WorkWithJSON;
import renting.FilterForRenting;
import renting.RentalFunctions;
import vehicle.data.Year;

import java.util.ArrayList;
// TODO this class will be removed
public class Functionality {
    public static void main(String[] args) {


        WorkWithJSON workWithJSON = new WorkWithJSON();
        //System.out.println(workWithJSON.findVehicleById("1"));

       /* workWithJSON.addCustomer("a", "b",
                50, "fdgf","gdfbgdf", "gfhfg", "123",
                new ArrayList<RentalHistory>(), 0.04);*/
        /*workWithJSON.addCustomer("a", "b",
                50, "fdgf","gdfbgdf", "gfhfg", "123",
                null, 0.04);*/


      /*  workWithJSON.addRentalInformationRecord("q1", "1",
                3, null, null);
*/
        //RentalFunctions rentalFunctions = new RentalFunctions();
        //
        //System.out.println(workWithJSON.findVehicleById("40"));
        //System.out.println(workWithJSON.findCustomerById("4"));
        //RentalFunctions rentalFunctions = new RentalFunctions();
        //rentalFunctions.rentVehicle("44", "4", 1);
        //rentalFunctions.returnVehicle("rkp03");
        //rentalFunctions.rentVehicle("44", "4", 1);
        //System.out.println(workWithJSON.findRentalInformationById("DZTRk"));

        //System.out.println(workWithJSON.findRentalInformationById("GywX5"));
       // rentalFunctions.returnVehicle("GywX5");


       /* System.out.println(workWithJSON.findCustomerById("JohnSmith"));
        CustomerDataFunctions cdf = new CustomerDataFunctions();
        cdf.changePassword("nnn", "JohnSmith");
        System.out.println(workWithJSON.findCustomerById("JohnSmith"));*/


        FilterForRenting filter = new FilterForRenting();


       /* RentalFunctions rf = new RentalFunctions();
        //rf.rentVehicle("5", "JamesTaylor", 2);
        rf.returnVehicle("s8ahT");
        rf.rentVehicle("7", "JamesTaylor",1);*/
    }


}

