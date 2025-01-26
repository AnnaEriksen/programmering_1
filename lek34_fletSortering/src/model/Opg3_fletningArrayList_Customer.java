package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Opg3_fletningArrayList_Customer {
    public static void main(String[] args) {

        ArrayList<Customer> l1 = new ArrayList<>();
        l1.add(new Customer("Anna", "Jensen", 28));
        l1.add(new Customer("Bent", "Nielsen", 40));
        l1.add(new Customer("Camilla", "Thomsen", 29));
        l1.add(new Customer("Charlotte", "Sørensen", 33));
        l1.add(new Customer("Vanessa", "Trinh", 22));

        Customer[] l2 = {
                new Customer("Jonas", "Petersen", 31),
                new Customer("Lars", "Hansen", 35),
                new Customer("Camilla", "Thomsen", 29) // Denne findes også i l1
        };

        ArrayList<Customer> result = goodCustomers(l1, l2);
        System.out.println(result); // Udskriv resultatet



    }

    public static ArrayList<Customer> goodCustomers(ArrayList<Customer> l1, Customer[] l2){
        ArrayList<Customer> result = new ArrayList<>();

        int i1 = 0;
        int i2 = 0;

        //så længe der er noget i listerne l1 og l2
        while (i1 < l1.size() && i2 < l2.length) {
            if (l1.get(i1).getFirstName().compareTo(l2[i2].getFirstName()) < 0) {
                result.add(l1.get(i1));
                i1++;
            } else if (l1.get(i1).getFirstName().compareTo(l2[i2].getFirstName()) > 0) {
                i2++;
            } else { // Hvis kunden findes i begge lister, springes den over
                i1++;
                i2++;
            }
        }

        while (i1 < l1.size()) { // Tilføj resterende elementer fra l1
            result.add(l1.get(i1));
            i1++;
        }

        return result;
    }
    }





