package opgave7;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class opgave7_indlæs_tal_i_fil {
    public static void main(String[] args) {

        String filename = "C:\\Users\\annae\\IdeaProjects\\projekt 1\\lek30_opg7.txt";

        try {
            PrintWriter pr = new PrintWriter(filename);
             Scanner scan = new Scanner(System.in);

            System.out.println("Indtast tal der skal gemmes i filen, skriv -1 for at lukke ned");

            int tal = 0;
            while ((tal = scan.nextInt()) != -1){
                if (tal < 0) {
                    throw new IllegalArgumentException("negativt tal er ikke tilladt");
                }
                if (tal > 0){
                    pr.println(tal);
                }
            }

            pr.close();
            scan.close();

            System.out.println("Fil er lavet");

        } catch (FileNotFoundException e){
            throw new RuntimeException(e);


        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
