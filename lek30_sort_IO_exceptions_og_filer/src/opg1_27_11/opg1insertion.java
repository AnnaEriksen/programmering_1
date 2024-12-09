package opg1_27_11;

import model.Customer;

import java.util.ArrayList;

public class opg1insertion {

//    I denne opgave skal der laves en metode der indsætter en Kunde i en ArrayList af kunde objekter.
//    Det kan antages at listen inden indsættelsen er sorteret efter kundernes fornavne. Efter
//    indsættelsen skal listen fortsat være sorteret. Du skal ikke sortere hele listen igen, derimod skal du
//    finde den plads hvor kunden skal stå og indsætte Kunde objektet.

    public static void insertCustomer(ArrayList<Customer> customers, Customer customer){
       boolean found = false;
       int i = 0;
       //Customer c = customers.get(i);
       while (!found && i < customers.size()){
           if (customers.get(i).getFirstName().compareTo(customer.getFirstName()) > 0){
               found = true;
           }
           else {
               i++;
           }
       }
       customers.add(i, customer);


    }

    public static void insert (ArrayList<Integer> list, int e) {
        boolean found = false;
        int i = 0;;
        while (!found && i<list.size()) {
            if (list.size() > e){
                found = true;
            }
            else {
                i++;
            }
        }
        list.add(i, e);
    }

}

