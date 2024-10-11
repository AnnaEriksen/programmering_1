package lek8.modelarray;
import java.util.Arrays;

public class ArrayApp {
    public static int[] fyldArrayPP(){
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++){
            result[i] = i * 3;
        }
        return result;
    }
    public static int findMax(int[] tabel) {
        int max = -1;
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i] > max) {
                max = tabel[i];
            }
        }
        return max;
    }

    public static void printArray(int[] tabel) {
        System.out.print("{");
        for (int i = 0; i < tabel.length; i++) {
            if (i == 0) {
                System.out.print(tabel[i]);
            }
            else {
                System.out.print(", " + tabel[i]);
            }
        }
        System.out.println("}  ");
    }

    // OPGAVE 1


    /**
     *
     * @return et array med indhold [0,0,0,0,0,0,0,0,0,0]
     */
    public static int[] fyldArrayA() {
        int[] result = new int[10];
        return result;
    }

    /**
     *
     * @return et array med indhold [2,44,-23,99,8,-5,7,10,20,30]
     */
    public static int[] fyldArrayB() {
        //int[] result =new int[10];
        int[] result ={2,44,-23,99,8,-5,7,10,20,30};
        return result;
    }

    /**
     *
     * @return et array med indhold [0,1,2,3,4,5,6,7,8,9]
     */
    public static int[] fyldArrayC() {
        int[] result = new int[10];
        for(int i = 0; i<result.length; i++){
            result[i] = i;
        }
        return result;
    }

    /**
     *
     * @return et array med indhold [2,4,6,8,10,12,14,16,18,20] - skal laves
     */
    public static int[] fyldArrayD() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++){
            result[i] = (i+1) * 2; //Vi ganger med 2 for ikke at få 0 til at starte med
        }
        return result;
    }

    /**
     *
     * @return et array med indhold [1,4,9,16,25,36,49,64,81,100] - skal laves
     */
    public static int[] fyldArrayE() {
        int[] result = new int[10];
        //TODO
        for (int i = 1; i <= result.length; i++)
            result[i-1] = i * i; // man skriver [i-1, da den først rykker 1 til venstre (0´s plads)
        //for den rykker til højre

        return result;
    }

    /**
     *
     * @return et array med indhold [0,1,0,1,0,1,0,1,0,1] - skal laves
     */
    public static int[] fyldArrayF() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++)
            if (i % 2 == 0){
                result[i] = 0;
            }
            else {
                result[i] = 1;
            }
        //TODO
        return result;
    }

    /**
     *
     * @return et array med indhold [0,1,2,3,4,0,1,2,3,4] - skal laves
     */
    public static int[] fyldArrayG() {

        int[] result = new int[10];
        //TODO
        for (int i = 0; i < 5; i++){
            result[i] = i;
        }

        for (int i = 6; i < 10; i++){
            result[i] = i - 5; // man trækker 5 fra for at få den til at tælle fra 0

        }
        return result;
    }


    public static void main(String[] args) {

        int tabel[] =fyldArrayPP();
        System.out.println("Forventet: [0, 3, 6, 9, 12, 15, 18, 21, 24, 27]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));

        int[] tabel2 = { 78, 23, 1, 4, 65, 3, 87, 5, 12 };
        printArray(tabel2);
        System.out.println(findMax(tabel2));

        tabel = fyldArrayA();
        System.out.println("Forventet: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayB();
        System.out.println("Forventet: [2, 44, -23, 99, 8, -5, 7, 10, 20, 30]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayC();
        System.out.println("Forventet: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayD();
        System.out.println("Forventet: [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayE();
        System.out.println("Forventet: [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayF();
        System.out.println("Forventet: [0, 1, 0, 1, 0, 1, 0, 1, 0, 1]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayG();
        System.out.println("Forventet: [0, 1, 2, 3, 4, 0, 1, 2, 3, 4]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        // opgave 2
        int[] tabel3 = {4, 6, 7, 2, 3};
        System.out.println(sum(tabel3));

        //opgave 2 del 2
        double[] test1 = {4.2, 5.7, 6, 7.6, 9};
        System.out.println(sum(test1));

        //opgave 3
        int[] test3 = {4,6,7,2,3};
        System.out.println(antalLige(test3));

        //opgave 4
        int[]test4 = {4,6,7,2,7};
        System.out.println(antalForekomster(test4, 7));

        // opgave 5
         int[] a = {4,6,7,2,3};
         int[] b = {3,0,9,5,5};
        System.out.println((Arrays.toString(makeSum(a, b))));

        //opgave 6
        int[] test5 = {4,6,7,2,3};
        System.out.println(hasUneven(test5));

    }

    // Opgave 2
    public static int sum(int[] tabel){

        int sum = 0;
        for (int i = 0; i < tabel.length; i++){
            sum += tabel[i];
        }
        return sum;
    }
    public static double sum(double[]tabel){
        double sum = 0;
        for (int i = 0; i < tabel.length; i++){ //man skal bruge int i for-loopet,
            // da selve pladserne er heltal og kan aldrig hedde 0,2, 7,3 etc etc....
            sum += tabel[i];
        }
        return sum;
    }

    // Opgave 3
    public static int antalLige(int[] tabel){

        int ligeTal = 0;
        for (int i = 0; i < tabel.length; i++){
            if (i % 2 == 0){
                ligeTal += 1; // den hedder
            }
        }

        return ligeTal;
    }

// opgave 4
    public static int antalForekomster(int[] tabel, int tal){
        int forekomster = 0;
        for (int i = 0; i < tabel.length; i++){
            if (tal == tabel[i]){ //hvis det tal, der indtastes i den metode vi kalder,
                // er lig med et tal i indekset, bliver det talt op.

                forekomster++;
            }
        }
        return forekomster;
    }
    //Opgave 5
    public static int[] makeSum(int[] a, int[] b){
        int sum = 0;
        int[] array = new int[a.length];
        for (int i = 0; i < a.length; i++){
            array[i] = a[i] + b[i];
        }

        return array;
    }

    // Opgave 6

    public static boolean hasUneven(int[]tabel){
        boolean uneven = false;

        for (int i = 0; i < tabel.length; i++){
            int number = tabel[i];
            if (number % 2 == 1) {
                uneven = true;
                break;
            }
        }
        return uneven;
    }
}







