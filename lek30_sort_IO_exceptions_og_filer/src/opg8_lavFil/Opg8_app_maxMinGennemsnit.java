package opg8_lavFil;

// Til denne opgave benyttes filer.zip, som i klassen PrintWriterTal har et eksempel på skrivning af tal til en fil.
//Lav med denne applikation et par filer med et antal heltal. Den første fil kan passende indeholde 10 tal, den næste 2500 tal.

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Opg8_app_maxMinGennemsnit {
    public static void main(String[] args) {

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        // finder max i fil med 10 tal
        try {
            System.out.println("Max: " + max("C:\\Users\\annae\\IdeaProjects\\projekt 1\\opg8_2500_tal.txt"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // finder min i fil med 10 tal
        try {
            System.out.println("Min: " + min("C:\\Users\\annae\\IdeaProjects\\projekt 1\\opg8_2500_tal.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // finder gennemsnit i fil med 10 tal
        try {
            System.out.println("Gennemsnit: "+ gennemsnit("C:\\Users\\annae\\IdeaProjects\\projekt 1\\opg8_2500_tal.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    // METODER

    // finder maximum for tallene i filen med filnavnet fileName; det antages filen kun indeholder heltal. Metoden må ikke gemme tallene i en ArrayList.
    public static int max(String filename) throws IOException {
        int max = Integer.MIN_VALUE;

        File filein = new File(filename);

        Scanner scan = new Scanner(filein);

        while (scan.hasNext()) { // så længe der er mere data at hente
            int tal = scan.nextInt();
            if (tal > max) {
                max = tal;
            }
        }
        scan.close();
        return max;
    }

    // finder minimum for tallene i filen med filnavnet fileName; det antages filen kun indeholder heltal. Metoden må ikke gemme tallene i en ArrayList.
    public static int min(String fileName) throws IOException {
        int min = Integer.MAX_VALUE;
        File filein = new File(fileName);
        Scanner scanner = new Scanner(filein);

        while (scanner.hasNext()) {
            int tal = scanner.nextInt();
            if (tal < min) {
                min = tal;
            }
        }

        scanner.close();
        return min;

    }

    // finder gennemsnittet af tallene i filen med filnavnet fileName; det antages, at filen kun indeholder heltal. Metoden må ikke gemme tallene i en ArrayList.
    public static double gennemsnit(String fileName) throws IOException {
        double sum = 0;
        double antalHeltal = 0; // tæller antallet af heltal i en fil

        File filein = new File(fileName);
        Scanner scanner = new Scanner(filein);

        while (scanner.hasNext()) {
            sum += scanner.nextInt();
            antalHeltal++; // tæller hvert tal, der scannes
        }

        scanner.close();
        return sum/antalHeltal;
    }

}
