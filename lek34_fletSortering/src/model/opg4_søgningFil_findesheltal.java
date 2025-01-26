package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class opg4_søgningFil_findesheltal {
    // Skriv en metode der søger efter heltal i en fil.
    //Metoden skal returnere om tallet findes i filen eller ej. Anvend søgeskabelonen.
    //Du kan fx lave en talfil.txt med følgende indhold:
    //9140
    //4450
    //5885
    //1284
    //219
    //4203
    //8965
    //4919
    //982
    //959

    public static void main(String[] args) {
        String fileName = "C:\\Users\\annae\\IdeaProjects\\projekt 1\\lek34_fletSortering\\src\\model\\opgave4.talfill.txt";
        try {
            PrintWriter printWriter = new PrintWriter(fileName);

            printWriter.println(9140);
            printWriter.println(4450);
            printWriter.println(5885);
            printWriter.println(1284);
            printWriter.println(219);
            printWriter.println(4203);
            printWriter.println(8965);
            printWriter.println(4919);
            printWriter.println(982);
            printWriter.println(952);

            // skriv filen
            printWriter.close();

            System.out.println("Filen er lavet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // findes heltal i filen?
        try {
            System.out.println("Findes heltallet i filen? " + linFileSearch("C:\\Users\\annae\\IdeaProjects\\projekt 1\\lek34_fletSortering\\src\\model\\opgave4.talfill.txt", 982));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public static boolean linFileSearch(String fileName, int target) throws FileNotFoundException {
        File filein = new File(fileName);
        Scanner scanner = new Scanner(filein);

        boolean helTalErFundet = false;

        while (!helTalErFundet && scanner.hasNext()) { // så længe der er mere at scanne i filen
            int tal = scanner.nextInt();
            if (tal == target) {
                helTalErFundet = true;
            }
        }
        scanner.close();
        return helTalErFundet;


    }


}
