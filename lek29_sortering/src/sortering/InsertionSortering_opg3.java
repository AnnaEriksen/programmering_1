import model.Customer;

import java.util.ArrayList;

public static class InsertionSortering_opg3 {

    public static void insertioneSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int next = list[i];
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next >= list[j - 1]) {
                    found = true;
                } else {
                    list[j] = list[j - 1];
                    j--;
                }
            }
            list[j] = next;
        }
    }

    //TODO opgave 3: String[]

    public static void insertionSorter(String[] customers){
        for(int i = 1; i < customers.length; i++){
            String next = customers[i];
            int j = i;

            //skubber elementer til højre for at gøre plads til "next"
            while (j > 0 && next.compareTo(customers[j - 1]) < 0){
                customers[j] = customers[j - 1];
                j--; // Dekrementér j
            }

            customers[j] = next; //indsæter next på den rette plads
        }
    }
}

public static void insertionSorterArrayList(ArrayList<Customer> customerArrayList){
    for (int i = 1; i < customerArrayList.size(); i++){
        Customer next = customerArrayList.get(i); //elementer der skal indsættes
        int j = i;

        //skubber elementer til højre for at få plads til next
        while (j > 0 && next.getFirstName().compareTo(customerArrayList.get(j - 1).getFirstName()) < 0) {
            customerArrayList.set(j, customerArrayList.get(j - 1));
            j--;

        }
        customerArrayList.set(j, next);


    }

}








}
