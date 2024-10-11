package lektion4;
import java.util.Random;
import java.util.Scanner;

public class opgave10 {
    public static void main(String[] args) {
        Random number = new Random();

        Scanner scan = new Scanner(System.in);
        System.out.println("Indtast et nummer fra 0 til 2: ");
        int brugerensBud = scan.nextInt();

        int randomNumber = number.nextInt(3);
        //man bruger to lighedstegn da det er en samligningsoperator

        if (brugerensBud == 0 && randomNumber == 1){
            System.out.println("Du har tabt! Computeren spillede " + randomNumber);

        }
        if (brugerensBud == 0 && randomNumber == 2){
            System.out.println("Tillykke du har vundet! Computeren spillede " + randomNumber);
        }
        if (brugerensBud == 1 && randomNumber == 2){
            System.out.println("Du har tabt! Computeren spillede " + randomNumber);
        }
        if (brugerensBud == 1 && randomNumber == 0){
            System.out.println("Tillykke du har vundet! Computeren spillede " + randomNumber);
        }
        if (brugerensBud == 2 && randomNumber == 0){
            System.out.println("Du har tabt! Computeren spillede " + randomNumber);
        }
        if (brugerensBud == 2 && randomNumber == 1){
            System.out.println("Tillykke du har vundet! Computeren spillede " + randomNumber);
        }
        if (brugerensBud == randomNumber){
            System.out.println("I står lige... Computeren spillede " + randomNumber);

        }
    }
}

