package model;

import javax.swing.*;
import java.lang.invoke.CallSite;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class MethodsArrayList_Opg2 {
    
    /**
     *
     * @param list
     * @return sums the mumbers in the list using a for loop
     */
    public static int sumListe(ArrayList<Integer> list) {
        int resultat = 0;
        for (int i = 0; i < list.size(); i++) {
        //	int tal = list.get(i);
            resultat = resultat + list.get(i);
        }
        return resultat;
    }
    
    /**
    *
    * @param list
    * @return sums the mumbers in the list using a forEach loop
    */
    public static int sumListe2(ArrayList<Integer> list) {
        int resultat = 0;
        for (int tal : list) {
            resultat = resultat + tal;
        }
        return resultat;
    }
    
    /**
     *
     * @param list
     * @return index at the first even number
     */
    public static int hasEvenAtIndex(ArrayList<Integer> list) {
        int index = -1;
        int i = 0;
        while (index == -1 && i < list.size()) {
            if (list.get(i) % 2 == 0) {
                index = i;
            }
            i++;
        }
        return index;
        
    }
    public static int min(ArrayList<Integer> list){
        int min = Integer.MAX_VALUE;
        for (Integer tal: list){
            if (min > tal){
                min = tal;
            }
        }return min;

    }

    public static double average(ArrayList<Integer> list){
        double average = 0;
        double sum = 0;
        for (Integer tal : list) {
            sum = sum + tal;
            average = sum / list.size();
        }
        return average;
    }


    public static int countZeros(ArrayList<Integer> list){
        int count = 0;
        for (Integer tal: list){
            if (tal == 0){
                count++;
            }
        }
        return count;
    }

    public static void swapEvenWithZero(ArrayList<Integer> list){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) % 2 == 0){
                list.set(i, 0);
            }
        }
    }

    public static ArrayList<Integer> anEvenList(ArrayList<Integer> list){
        ArrayList<Integer> even = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) % 2 == 0){
                even.add(list.get(i));
            }
        }
        return even;
    }


    public static void swapFirstAndLast(ArrayList<Integer> list){
        int temp = list.get(list.getLast());
        list.set(list.size()-1, list.getFirst());
        list.set(0, temp);

    }
    public static void shiftRight (ArrayList<Integer> list){
        int temp = list.removeLast();
        list.addFirst(temp);
        for (int i = 0; i < list.size(); i++){

            //det kan godt være det driller lidt, men der plejede at stå -1 inde i list.get(i)
            list.set(i, list.get(i));
        }

    }

    public static int nextMax (ArrayList<Integer> list){
        //denne kommando sorterer noget der kan sorteres. Dvs den ligger den i stigende rækkefølge
        Collections.sort(list);
        return list.get(list.size()-2);

    }
    public static boolean isInOrder (ArrayList<Integer> list){
        boolean isInOrder = false;
        for (int i = 0; i < list.size()-2; i++){
            if (list.get(i) > list.get(i+1)){
                isInOrder = true;
            }

        }
        return isInOrder;
    }
    public static boolean hasDuplicates (ArrayList<Integer> list){
        ArrayList<Integer> dupes = new ArrayList<>();
        for (int number: list){
            if (dupes.contains(number)){
                return true;
            }
            dupes.add(number);

        }
        return false;
    }





    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(19);
        list.add(35);
        list.add(14);
        list.add(7);
        System.out.println(list);
        System.out.println("Summen af tallene i listen med for "
                + sumListe(list));
        System.out.println("Summen af tallene i listen med forEach "
                + sumListe2(list));

        System.out.println("Indeks for det første lige tal: "
                + hasEvenAtIndex(list));

        //public static int min(ArrayList<Integer> list){}
        System.out.println("Mindste tal: " + min(list));

        //public static double average(ArrayList<Integer> list){}
        System.out.println("Gennemsnit: " + average(list));

        //public static int countZeros(ArrayList<Integer> list){}
        System.out.println("Antal gange 0 forekommer: " + countZeros(list));

        //public static void swapEvenWithZero(ArrayList<Integer> list){
        System.out.println("Erstat lige tal med nul: ");
        //swapEvenWithZero(list);
        System.out.println(list);

        //public static ArrayList<Integer> anEvenList(ArrayList<Integer> list){
        System.out.println("Kun lige tal: ");
        System.out.println(anEvenList(list));

        //public void swapFirstAndLast(ArrayList<Integer> list){
        System.out.println("Skift første og sidste");

        //shift
        System.out.println("Skift til højre: ");
        System.out.println(list);
        shiftRight(list);
        System.out.println(list);

        //nextMax
        System.out.println("næsthøjeste: " + nextMax(list));

        //duplicates
        ArrayList<Integer> array1 = new ArrayList<>();
        array1.add(2);
        array1.add(5);
        array1.add(8);
        array1.add(5); // Der er en duplet her

        ArrayList<Integer> array2 = new ArrayList<>();
        array2.add(2);
        array2.add(5);
        array2.add(8);
        array2.add(6); // Ingen dupletter her

        System.out.println(hasDuplicates(array1)); // true
        System.out.println(hasDuplicates(array2)); // false

    }

}
