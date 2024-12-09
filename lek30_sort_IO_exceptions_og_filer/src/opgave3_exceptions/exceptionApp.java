package opgave3_exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class exceptionApp {
    public static void main(String[] args) {

//        I klassen ExceptionApp indlæses et tal, og der vises primtallet med dette nummer. Men kun hvis
//        nummeret ligger mellem 1 og 10. Kør programmet og prøv at taste tal ind som er under 1 eller over 10.

//        a) Undersøg hvilke exceptions, der bliver kastet.
//                //TODO vi får en outOfBoundsException

//        b) Udvid koden, så de exceptions, der opstår, fanges og håndteres


        int[] prim = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Hvilket nr. primtal skal vises?: ");
            int n = scan.nextInt();
            System.out.println("Primtal nr. " + n + " er " + prim[n - 1] + "\n");

        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Tallet er ikke mellem 1 og 10, prøve igen :)");

        }
        catch (InputMismatchException e){
            System.out.println("Dit input stemmer ikke med opgaven, prøve igen :)");
        }
        System.out.println("Afslutter program...");

    }
}






