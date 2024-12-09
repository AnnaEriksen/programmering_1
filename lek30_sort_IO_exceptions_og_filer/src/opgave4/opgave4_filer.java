package opgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class opgave4_filer {
    //Lav med notesblokken i Windows en fil med en række heltal, f.eks.34, -20, 0
    //200, 177, 285. Lav en applikation der i main-metoden læser denne fil, og udskriver det dobbelte af tallene i
    //consolvinduet dvs, 68, -40, 0, 400, 354, 570

    public static void main(String[] args) throws FileNotFoundException {

        //TODO denne kommando kan bruges hvis man ikke kan finde sti til sin fil
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        //find sti til fil

        // Angiv filens navn
        File filein = new File("C:\\\\Users\\\\annae\\\\IdeaProjects\\\\projekt 1\\\\opgave4_tal.txt");
        Scanner scan = new Scanner(filein);

//        System.out.println("File path: " + filein.getAbsolutePath()); /TODO kan også bruges til at finde sti til en fil
        //find sti til fil

       // Læs tallene fra filen
       while (scan.hasNext()){
           // Læs næste tal som en streng og konverter til heltal
           int tal = Integer.parseInt(scan.next());
            // Beregn og udskriv det dobbelte af tallet
           System.out.println(tal * 2);
        }
       scan.close();
   }
}
