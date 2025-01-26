package model;

// a) Opret en fil personer.txt med nedenstående opbygning: et antal linjer med et nummer, et fornavn og et efternavn:
//133 Jens Hansen
//150 Laila Jensen
//887 Karl Thomsen
//605 Bent Jensen
//100 Ove Andersen
//488 Hanne Hansen
//320 Egon Olsen
//122 Inge Jensen
//Skriv en metode der leder efter en person med et bestemt efternavn:
//Metoden skal returnere hele personens navn. Hvis personen ikke findes, skal den tomme streng returneres.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class opg7_søgningFil_efternavn {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\annae\\IdeaProjects\\projekt 1\\lek34_fletSortering\\src\\model\\opgave7_personer";
        try {
            PrintWriter printWriter = new PrintWriter(fileName);

            printWriter.println("133 Jens Hansen");
            printWriter.println("150 Laila Jensen");
            printWriter.println("887 Karl Thomsen");
            printWriter.println("605 Bent Jensen");
            printWriter.println("100 Ove Andersen");
            printWriter.println("488 Hanne Hansen");
            printWriter.println("320 Egon Olsen");
            printWriter.println("122 Inge Jensen");

            // skriv filen
            printWriter.close();

            System.out.println("Filen er lavet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(linFileSearchPerson(fileName, "Jensen"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public static String linFileSearchPerson(String fileName, String target) throws FileNotFoundException {
        File filein = new File(fileName);
        Scanner scan = new Scanner(filein);

        String result = "";

        while (scan.hasNext()) { // så længe der er mere at scanne
            String k = scan.nextLine();
            if (k.contains(target)) {
                result += k.substring(4) + "\n"; // substring fjerner tallene
            }
        }
        scan.close();
        return result;

    }


}
