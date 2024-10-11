package modelwhile;

import jdk.dynalink.beans.StaticClass;

public class loekkeOpgaver {

    public static void main(String[] args) {

//        Kald af metoder der afprøver opgave 1

        System.out.println(summerEven(100));
        System.out.println(summerSquare(10));
        System.out.println(sumOdd(3, 19));
        allPowers(6);

    }

    // Metoden returnerer summen af alle lige tal mellem 2 og n OPG 1a
    public static int summerEven(int n) {
        // TODO Opgave 1.a

        int result = 0;
        int i = 2;
        while (i <= n){
            result = result + i;
            i++;
        }
        return result;
    }

    // Metoden returnerer summen af alle kvdrater mellem 1*1 og n*n
    public static int summerSquare(int n) {
        // TODO Opgave 1.b

        int result = 0;
        int i = 1;
        while (i <= n){

            result = result + i * i;
            i++;
        }
        return result;
    }

    // Metoden returnerer summen af alle ulige tal mellem a og b
    public static int sumOdd(int a, int b) {
        int result = 0;
        int i = a;
        while (a < b){

            //vi gør dette for at be eller afkræfte, om det er lige eller ulige
            if (a % 2 == 1){
                result = result + a;
                a++;
            }
            return result;
        }
        // TODO Opgave 1.c
        return -1;
    }

    // Metoden udskriver 2 potenser. Ændre allpowers fra 20 til 6
    public static void allPowers(int n) {
        // TODO Opgave 1.d
        int potens = 0;
        int result = 1;
        while (potens <= n){
            System.out.println(result);
            result = result * 2;

            potens++;
        }
    }
}








