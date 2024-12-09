package opg1_27_11;

import model.Customer;
import opg2.opg2_insertionArray;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {


        //opgave 1
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Anna", "Eriksen", 22));
        customers.add(new Customer("Emma", "Hansen", 27));
        customers.add(new Customer("Vanessa", "Trinh", 22));

        Customer c = new Customer("Bo", "Jensen", 43);
        ArrayList<Customer> customersCopy = new ArrayList<>(customers);
        System.out.println("Før: " + customersCopy);
        opg1insertion.insertCustomer(customersCopy, c);
        System.out.println("Liste efter: " + customersCopy);

        System.out.println("____________________________________________________________________________");

        //Opgave 2
        Customer c1 = new Customer("Anna", "Eriksen", 22);
        Customer c2 = new Customer("Bo", "Hansen", 56);
        Customer c3 = new Customer("Emma", "Hansen", 27);
        Customer c4 = new Customer("Vanessa", "Trinh", 22);


        //ny customer



        Customer c5 = new Customer("Bent", "Borisen", 42);


        Customer[] customers2 = {c1, c2, c3, c4};

        System.out.println("Før: " +Arrays.toString(customers2));
        opg2_insertionArray.insertCustomer(customers2, c5);
        System.out.println("Liste efter: " + Arrays.toString(customers2));






    }
}
