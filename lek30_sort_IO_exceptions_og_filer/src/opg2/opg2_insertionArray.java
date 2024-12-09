package opg2;

import model.Customer;

public class opg2_insertionArray {



//    I denne opgave skal du løse det samme problem som i opgave 2, blot i et array af Kunder i stedet.
//    Metoden skal da have følgende specifikation. Indsætter kunde i kunder. Arrayet kunder er sorteret
//    Krav: kunder er sorteret. Det kan antages at der er plads til den Kunde der skal indsættes, samt at
//    de pladser der ikke er anvendt i arrayet har værdien null. Lav i en main-metode det der skal til, for
//    at du kan afprøve metoden

    public static void insertCustomer(Customer[] customers, Customer customer){
        int j = customers.length -1;
        while (j >= 0 && customers[j] == null){ //while loopet kører til den finder en tom plads
            j--;
        }
        j++;
        boolean found = false;
        while (!found && j > 0){
            if (customer.getFirstName().compareTo(customers[j-1].getFirstName()) > 0){
                found = true;
            }
            else {
                j--;
            }
        }
        customers[j] = customer;

    }
    public static void insert(int[] tabel, int e) {
        int j = tabel.length-1;
        while(j>=0 && tabel[j]==0) {
            j--;
        }
        j++;
        boolean found = false;
        while (!found && j>0) {
            if (e>tabel[j-1]) {
                found = true;
            }
            else {
                tabel[j] = tabel[j-1];
                j--;
            }
        }
        tabel[j]= e;










    }
}
