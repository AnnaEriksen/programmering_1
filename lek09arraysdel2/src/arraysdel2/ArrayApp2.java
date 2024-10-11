package arraysdel2;

import com.sun.source.tree.ReturnTree;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayApp2 {

    // Metode der adderer 1 til alle tal i array og returnerer en kopi
    public static int[] addOne(int[] tabel) {
        int[] result = new int[tabel.length];
        for (int i = 0; i < tabel.length; i++) {
            result[i] = tabel[i] + 1;
        }
        return result;
    }

    // Metode der adderer 1 til alle tal i input array
    public static void addOne2(int[] tabel) {
        for (int i = 0; i < tabel.length; i++) {
            tabel[i] = tabel[i] + 1;
        }
    }


    public static void shiftLeft(int[] tabel) {
        int temp = tabel[0];
        for (int i = 1; i < tabel.length; i++) {
            tabel[i - 1] = tabel[i];
        }
        tabel[tabel.length - 1] = temp;
    } //der skal ikke tilføjes flere efter palds 5.


    // Metode der finder antal tekster i et array der starter med et bestemt begyndelses bogstav
    public static int starterMed(String[] tabel, char c){
        int antal = 0;
        for (int i = 0; i < tabel.length; i++){
            if (tabel[i].charAt(0) == c ){
                antal++;
            }
        }
        return antal;
    }

    // Eksempel med forEach
    // Metode der finder antal tekster i et array der starter med et bestemt begyndelses bogstav
    public static int starterMed2(String[] tabel, char c){
        int antal = 0;
        for (String tekst: tabel){
            if (tekst.charAt(0) == c ){
                antal++;
            }
        }
        return antal;
    }


    // Opgave 1.1
    public static boolean swapFirstLast(int[] tabel) { //Vi skal ikke bruge en lykke
        // TODO 1.1
        int temp = tabel[0];
        tabel[0] = tabel [tabel.length -1]; //tabel.length: fordi vi ikke kender længden af indekset endnu
        tabel[tabel.length -1] = temp; // der skal ikke tilføjes flere efter plads 5.

        return false;
    }


    // Opgave 1.2. Erstat alle lige tal med et 0.
    public static void swapEvenWithZero(int[] tabel) {
        // TODO 1.2
        for (int i = 0; i < tabel.length; i++){
            if (tabel[i] % 2 == 0){
                tabel[i] = 0;
            }
            return;
        }
    }


    //Opgave 1.3
    //En metode der returnerer det mindste element i input-arrayet. //kunne godt bruge en foreach
    public static int returnSmall(int[] tabel){
        int min = 99; //for at finde det mindste element, skal man ikke sætte small til noget småt fra starten af

        for (int i = 0; i < tabel.length; i++){
            if (min > tabel[i]){
                min = tabel[i];
            }
        }
        return min;
    }


    // opgave 1.4
    public static int shiftRight(int[] tabel){
        int temp = tabel[tabel.length-1]; // starter med at tage tallet der står bagerst for ikke at override
        for (int i = tabel.length-1; i > 0; i--){
            tabel[i] = tabel[i-1]; // her refererer vi til 0 og 1 pladsen.
        }
        tabel[0] = temp;
        return temp;
    }

    // opgave 1.5 //kunne godt bruge en foreach
    public static int secondLargest(int[] tabel){
        int max = 0;
        int nextMax = 0;
        for (int i = 0; i < tabel.length; i++){
            if (tabel[i] > max) {
                nextMax = max;
                max = tabel[i];
            }
            else if (tabel[i] > nextMax){
                nextMax = tabel[i];
            }
        }
        return nextMax;
    }

    //opgave 1.6
    //En metode der returnerer true hvis input-arrayet er sorteret i stigende orden.

    public static boolean increasingOrder (int[] tabel){
        boolean result = true;
        for (int i = 0; i < tabel.length-1; i++){
            if (tabel[i] > tabel[i+1]){
                result = false;
            }
        }
        return result;
    }

    //ogpave 1.7
    public static boolean doubles(int[] tabel){
        boolean result = false;
        for (int i = 0; i < tabel.length-1; i++){
            for (int j = 0; j < tabel.length; j++){
                if (i == j){ // for at tjekke om i og j er lige lang
                }
                else if (tabel[i] == tabel[j]){
                    result = true;
                }
            }

        }
        return result;

    }

    // opgave 2.1
    public static int fireChar(String[] tabel){

        int antal = 0;
        for (int i = 0; i <= tabel.length-1; i++){ // man siger length-1, fordi at den første forekomst i array,
            //starter med 0
            if (tabel[i].length() == 4){
                antal++;
            }
        }
        return antal;
    }

    // opgave 2.2
    public static int antalChar(String[] tabel, int antal){
        int count = 0;
        for (int i = 0; i <= tabel.length-1; i++){ // man siger length-1, fordi at den første forekomst i array,
            //starter med 0
            if (tabel[i].length() == antal){
                count++;
            }
        }
        return count;
    }


    //opgave 2.3
    public static String[] upperCase(String[] tabel){
        //tabe.length, betyder at upperCaseArray får samme længde som "tabel" parameteren

        String[] upperCaseArray = new String[tabel.length];

        for (int i = 0; i <= tabel.length-1; i++){
            upperCaseArray[i] = tabel[i].toUpperCase();
        }
        return upperCaseArray;
    }

    //opgave 3.1
    public static int ogpave3ForEach(String[] tabel){

        int antal = 0; //vi skal stadig bruge dette
        for (String navn: tabel){ //tabellen indeholder alle forekomsterne,
             if (navn.length() == 4) {
                 antal++;
             } //jeg har nu lavet en erstatninng for forloopet med et foreach loop
        }
//        for (int i = 0; i <= tabel.length-1; i++){ // man siger length-1, fordi at den første forekomst i array,
//            //starter med 0
//            if (tabel[i].length() == 4){
//                antal++;
//            }
//        }
        return antal;
    }

    //opgave 3.2
    public static int opgave32forEach(String[] tabel, int antal){

        int count = 0;
        for (String navn:tabel)
            // Hver gang forloopet udføres, får jeg næste element i tabellen, indtil der ikke er flere,
            // og så slutter forloopet.
            //
            if (navn.length() == antal){
                count++;
            }

        // her er forskellen fra forloops er at man ikke bruger indekset, if sætningen fortæller

//        for (int i = 0; i <= tabel.length-1; i++){ // man siger length-1, fordi at den første forekomst i array,
//            //starter med 0
//            if (tabel[i].length() == antal){
//                count++;
//            }
//        }
        return count;
    }


    //opgave 3.3
    public static String[] opg33upperCase(String[] tabel){

        String[] upperCaseArray = new String[tabel.length];
        int count = 0;
        for (String navn: tabel){
            // jeg skal ikke bruge en if, da jeg skal behandle hvert element,
            // der er ikke nogen betingelser for at lave elemterne til uppercase

            // vi bruger metoden "toUpperCase", for hvert navn i tabellen

            navn.toUpperCase(); //nu skal den puttes ind i det nye array,

            upperCaseArray[count] =  navn.toUpperCase();
            count++;
            // note til mig selv: Hvis en metode skal svare på hvor mange elemtenter der i et array,
            //så har man ikke brug for et forloop. Man kan bare bruge "metode".length.
        }

//        for (int i = 0; i <= tabel.length-1; i++){
//            upperCaseArray[i] = tabel[i].toUpperCase();
//        }
        return upperCaseArray;

    }
    public static void main(String[] args) {
        int[] tal = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(tal));
        int[] newTabel = addOne(tal);
        System.out.println("Gamle: " + Arrays.toString(tal));
        System.out.println("Nye  : " + Arrays.toString(newTabel));
        System.out.println();
        addOne2(tal);
        System.out.println("Gamle: " + Arrays.toString(tal));
//
        int[] copy = new int[tal.length];
        for (int i = 0; i < tal.length; i++){
            copy[i] = tal[i];
        }

        System.out.println();
        shiftLeft(tal);
        System.out.println(Arrays.toString(tal));

        System.out.println();
        String[] navne = {"Maria", "Mette", "Lene", "Mona", "Jane"};
        System.out.println("Starter med M: " + starterMed(navne,'M'));
        //System.out.println("Starter med M: " + starterMed2(navne,'M'));

        // opgave 1.1
        int[] swap1 = {2, 3, 6, 9, 8};
        System.out.println(Arrays.toString(swap1)); //udskriver inden vi kalder metoden der swapper dem

        //metoden der bytter dem
        swapFirstLast(swap1);
        System.out.println(Arrays.toString(swap1)); //her udskrives metoden efter tallene er byttet

        //opgave 1.2
        int[] tabelevenNum = new int[]{5, 3, 8, 2};
        System.out.println(Arrays.toString(tabelevenNum));

        swapEvenWithZero(tabelevenNum);
        System.out.println(Arrays.toString(tabelevenNum));

        //Opgave 1.3
        int[] smallestElement = new int []{4, 5, 9, 8};
        System.out.println(returnSmall(smallestElement));

        //Opgave 1.4

        int[] shift = {1, 4, 9, 16, 25};
        System.out.println(Arrays.toString(shift));

        shiftRight(shift);
        System.out.println(Arrays.toString(shift));

        //Opgave 1.5

        int[] maxElement = {2, 5, 8, 9, 3};
        System.out.println(Arrays.toString(maxElement));
        int second = secondLargest(maxElement);

        System.out.println(second);

        // opgave 1.6
        int [] stigende = {2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(stigende));


        System.out.println(increasingOrder(stigende));

        int[] dobbel = {2, 5, 8, 5};
        System.out.println(Arrays.toString(dobbel));
        System.out.println(doubles(dobbel));

        //opgave 2.1

        String[] navneTabel = {"Anna", "Lisa", "Michael", "Simba", "Rudolf"};
        System.out.println(fireChar(navneTabel));

        //opgave 2.2
        int antal = 7;
        System.out.println(antalChar(navneTabel, antal));
        // AntalCHar fortæller hvor mange arrays i strengen er 7 lange

        //opgave 2.3
        System.out.println(Arrays.toString(upperCase(navneTabel)));

        //opgave 3.1
        System.out.println(ogpave3ForEach(navneTabel));

        //opgave 3.2
        System.out.println(opgave32forEach(navneTabel, antal));

        //opgave 3.3
        System.out.println("opgave 3.3: " + Arrays.toString(opg33upperCase(navneTabel)));
















    }
}
