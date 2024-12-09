package opg8_lavFil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

// Til denne opgave benyttes filer.zip, som i klassen PrintWriterTal har et eksempel på skrivning af tal til en fil.
//Lav med denne applikation et par filer med et antal heltal. Den første fil kan passende indeholde 10 tal, den næste 2500 tal.

public class Opg8_lavFil {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\annae\\IdeaProjects\\projekt 1\\opg8_2500_tal.txt";
        try {
            PrintWriter printWriter = new PrintWriter(fileName);

            // indlaes antal tal i filen
            Scanner scan = new Scanner(System.in);
            System.out.print("Antal tal der skal skrives i filen: ");
            int antal = scan.nextInt();

            // skab tilfældige tal generator Random
            Random rnd = new Random();

            // generer og skriv de tilfældige tal
            for (int n = 1; n <= antal; n++) {
                int tal = rnd.nextInt(10000);
                printWriter.println(tal);
            }

            // skriv filen
            printWriter.close();
            scan.close();

            System.out.println("Filen er lavet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
