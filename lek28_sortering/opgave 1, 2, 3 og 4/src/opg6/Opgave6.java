package opg6;

import java.util.ArrayList;

public class Opgave6 {

    public static int find(ArrayList<Integer> list, int n) {
        int indeks = -1;
        int i = 0;

        while (indeks == -1 && i <list.size()){
            int t = list.get(i);
            if (t == n){
                if (i > 0) { // bytter KUN hvis det fundne tal, IKKE står på plads 0
                    list.set(i, list.get(i-1)); //rykker tallet en plads til venstre hvis betingelsen er opfyldt
                    list.set(i-1, t); // Pladsen til venstre for det fundne tal, er nu den nye plads
                    indeks = i - 1; //opdaterer den nye plads
                }
                else {
                    indeks = i; //returnerer i, hvis tal står på fundne plads
                }
            }
            else {
                i++;
            }
        }
        return indeks;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(4);
        list.add(8);
        list.add(13);
        list.add(2);

        System.out.println("liste før: " + list);
        int position = find(list, 13); //find og flyt 13
        System.out.println("liste efter: " + list);
        System.out.println("Ny pos for 13: " + position);
    }
}

