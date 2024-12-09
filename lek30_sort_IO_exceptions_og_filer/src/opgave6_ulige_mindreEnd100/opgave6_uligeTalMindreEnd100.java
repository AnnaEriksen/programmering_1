package opgave6_ulige_mindreEnd100;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class opgave6_uligeTalMindreEnd100 {
    public static void main(String[] args) {
        String filename = "C:\\Users\\annae\\IdeaProjects\\projekt 1\\lek30_opg6_uligeTal.txt";

        try {
            PrintWriter pr = new PrintWriter(filename);
            for (int i = 1; i < 100; i +=2 ){ //her lægger vi 2 til hver gang for at få et ulige tal
                pr.println(i);
            }
            pr.close();
            System.out.println("Filen er lavet");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
