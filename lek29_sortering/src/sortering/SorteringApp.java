package sortering;

import model.Customer;
import java.util.ArrayList;
import java.util.Arrays;

import static sortering.SelectionSort_opg2.selectionSortArrayList;

public class SorteringApp {

    public static void main(String[] args) {
        final int[] tabelInit = {34, 12, 56, 12, 45, 89, 2};

        // Test Bubble Sort
        System.out.println("Bubbelsortering");
        int[] tabel = Arrays.copyOf(tabelInit, tabelInit.length);
        System.out.println(Arrays.toString(tabel));
        BubbelSortering_opg1.bubbleSort(tabel);
        System.out.println(Arrays.toString(tabel));

        System.out.println("--------------------------------");

        // Test Insertion Sort
        System.out.println("Insertionsortering");
        tabel = Arrays.copyOf(tabelInit, tabelInit.length);
        System.out.println(Arrays.toString(tabel));
        InsertionSortering_opg3.insertioneSort(tabel);
        System.out.println(Arrays.toString(tabel));

        System.out.println("--------------------------------");

        // Test Selection Sort
        System.out.println("Selectionsortering");
        String[] s2 = {"Erna", "Elly", "Laurits", "Bertha", "Christian", "August", "Marius", "John", "Tove", "Poul", "Torkild"};
        String[] sCopy2 = Arrays.copyOf(s2, s2.length);
        System.out.println(Arrays.toString(s2));
        SelectionSort_opg2.selectionSortering(sCopy2);
        System.out.println(Arrays.toString(sCopy2));

        System.out.println("--------------------------------");

        // Test ArrayList Selection Sort
        System.out.println("Opgave 2: ArrayList");
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Anna", "Eriksen", 22));
        customers.add(new Customer("Vanessa", "Trinh", 22));
        customers.add(new Customer("Emma", "Hansen", 27));

        System.out.println("Before sorting customers: " + customers);
        selectionSortArrayList(customers);
        System.out.println("After sorting customers: " + customers);

        System.out.println("--------------------------------");

        // Test String[] Insertion Sort
        String[] stringArray = {"Peter", "Anna", "Kurt", "Bo", "Zara"};
        System.out.println("Insertionsortering for String[]");
        System.out.println(Arrays.toString(stringArray));
        InsertionSortering_opg3.insertionSorter(stringArray);
        System.out.println(Arrays.toString(stringArray));

        System.out.println("--------------------------------");

        // Test ArrayList<Customer> Insertion Sort
        System.out.println("Insertionsortering for ArrayList<Customer>");
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        customerArrayList.add(new Customer("Peter", "Hansen", 43));
        customerArrayList.add(new Customer("Anna", "Larsen", 32));
        customerArrayList.add(new Customer("Kurt", "Jensen", 48));

        System.out.println("Before sorting customers: " + customerArrayList);
        InsertionSortering_opg3.insertionSorterArrayList(customerArrayList);
        System.out.println("After sorting customers: " + customerArrayList);
    }
}
