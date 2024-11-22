package sortering;

import model.Customer;

import java.util.ArrayList;

public class SelectionSort_opg2 {
//    private static void swap(int[] list, int i, int j) {
//        int temp = list[i];
//        list[i] = list[j];
//        list[j] = temp;
//    }
//
//    public static void selectionSort(int[] list) {
//        for (int i = 0; i < list.length; i++) {
//            int minPos = i;
//            for (int j = i + 1; j < list.length; j++) {
//                if (list[j] < list[minPos]) {
//                    minPos = j;
//                }
//
//            }
//            swap(list, i, minPos);
//        }
//    }



    //TODO string[]
    public static void swapStringArray(String[] list, int i, int j){
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;


    }

    //TODO string[]
    public static void selectionSortering(String[] list){
        for (int i = 0; i < list.length; i++){
            int minPosition = i;
            for (int j = i + 1; j < list.length; j++){
                if (list[j].compareTo(list[minPosition]) < 0){
                    minPosition = j;
                }
                swapStringArray(list, i, minPosition);
            }
        }
    }


    //TODO arrayList
    public static void swapArrayList(ArrayList<Customer> customers, int i, int j){
        Customer temp = customers.get(i);
        customers.set(i, customers.get(j));
        customers.set(j, temp);

    }

    //TODO arrayList
    public static void selectionSortArrayList(ArrayList<Customer> customers){
        for (int i = 0; i < customers.size(); i++){
            int minPos = i;
            for (int j = i + 1; j < customers.size(); j++){
                if (customers.get(j).getFirstName().compareTo(customers.get(minPos).getFirstName()) < 0){
                    minPos = j;
                }
            }
            swapArrayList(customers, i, minPos);
        }

    }


}


