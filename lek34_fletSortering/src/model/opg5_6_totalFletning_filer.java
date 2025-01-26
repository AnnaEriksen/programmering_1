package model;
// Denne opgave går ud på at lave en total fletning af to filer indeholdende heltal (int).
//a) Programmer en klasse med en main() metode.
//b) Lav to tekstfiler der indeholder int.
// Heltallene skal komme i stigende orden og begge filer skal som det sidste tal have:
//2147483647= Integer.MAX_VALUE
//c) Programmer følgende metode i klassen som en totalfletning.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class opg5_6_totalFletning_filer {
    public static void main(String[] args) {
        // fil 1
        String fileName1 = "C:\\Users\\annae\\IdeaProjects\\projekt 1\\lek34_fletSortering\\src\\model\\opgave5.totalfletning.filer";
        try {
            PrintWriter printWriter = new PrintWriter(fileName1);

            printWriter.println(2);
            printWriter.println(9);
            printWriter.println(170);
            printWriter.println(399);
            printWriter.println(777);
            printWriter.println(2000);
            printWriter.println(2147483647);

            // skriv filen
            printWriter.close();

            System.out.println("Fil 1 er lavet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // fil 2
        String fileName2 = "C:\\Users\\annae\\IdeaProjects\\projekt 1\\lek34_fletSortering\\src\\model\\opgave5.totalfletning.filer";
        try {
            PrintWriter printWriter2 = new PrintWriter(fileName2);

            printWriter2.println(1);
            printWriter2.println(7);
            printWriter2.println(10);
            printWriter2.println(200);
            printWriter2.println(900);
            printWriter2.println(3000);
            printWriter2.println(2147483647);

            // skriv filen
            printWriter2.close();

            System.out.println("Fil 2 er lavet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // fil 3
        String fileNameNy = "C:\\Users\\vanes\\OneDrive\\Programmering1\\L34_fletning_fil_søgning\\opgave5_fileNameNy.txt";
        try {
            PrintWriter printWriterNy = new PrintWriter(fileNameNy);

            // skriv filen
            printWriterNy.close();

            System.out.println("Den nye flettede fil er lavet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        // afprøver metode
        try {
            fletAlleHeltal(fileName1, fileName2, fileNameNy);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // metode

    /**
     * Laver en sorteret fil i fileNameNy der indeholder alle
     * heltal fra fileName1 og fileName2 (MAX_VALUE skal ikke i
     * resultatet)
     * Krav: filename1 og filename2 er navne på to sorterede filer.
     */

    public static void fletAlleHeltal(String fileName1, String fileName2, String fileNameNy) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(fileNameNy);

        File fil1 = new File(fileName1);
        Scanner scanner1 = new Scanner(fil1);
        File fil2 = new File(fileName2);
        Scanner scanner2 = new Scanner(fil2);

        int file1 = Integer.MAX_VALUE; // hvis der ikke er flere tal at scanne, så vil værdien være ugyldig, da vi senere ignorer max_value
        int file2 = Integer.MAX_VALUE;

        // tjekker at der er noget i begge filer, inden de sammenlignes og flettes:
        if (scanner1.hasNext()) { // hvis der er noget at læse, scannes det første tal
            file1 = scanner1.nextInt();
        }

        if (scanner2.hasNext()) { // hvis der er noget at læse, så læses det første tal
            file2 = scanner2.nextInt();
        }

        // fletning
        while (scanner1.hasNext() || scanner2.hasNext()) { // så længe der er mere at scanne i en af filerne
            if (file1 <= file2 && file1 != Integer.MAX_VALUE) { // hvis file1s første tal er mindst(eller =), tilføjes den i den nye fil
                printWriter.println(file1);

                if (scanner1.hasNext()) { // hvis der er flere tal at scanne, så bliver det gemt i file1
                    file1 = scanner1.nextInt();

                } else {
                    file1 = Integer.MAX_VALUE; // hvis ikke der er flere tal, får det en ugyldig værdi (maxvalue)
                }


            } else if (file2 != Integer.MAX_VALUE) { // hvis file2s første tal er mindst, tilføjes den i den nye fil
                printWriter.println(file2);

                if (scanner2.hasNext()) {
                    file2 = scanner2.nextInt();

                } else {
                    file2 = Integer.MAX_VALUE; // hvis ikke der er flere tal, får det en ugyldig værdi (maxvalue)
                }

            }
        }

        // hvis der er resterende tal i file1
        while (scanner1.hasNext()) {
            file1 = scanner1.nextInt();
            if (file1 != Integer.MAX_VALUE) {
                printWriter.println(file1);
            }
        }

        while (scanner2.hasNext()) {
            file2 = scanner2.nextInt();
            if (file2 != Integer.MAX_VALUE) {
                printWriter.println(file2);
            }
        }

        scanner1.close();
        scanner2.close();
        printWriter.close();

    }
}
