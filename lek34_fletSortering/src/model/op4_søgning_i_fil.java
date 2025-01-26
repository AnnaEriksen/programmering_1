package model;

import java.awt.print.Printable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class op4_søgning_i_fil {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\annae\\IdeaProjects\\projekt 1\\talfil.txt";
        try {
            PrintWriter pr = new PrintWriter(fileName);

            pr.println(9140);
            pr.println(4450);
            pr.println(1284);
            pr.println(219);
            pr.println(4203);
            pr.println(8965);
            pr.println(4919);
            pr.println(982);
            pr.println(959);


            pr.close(); //skriver filen

            System.out.println("filen er lavet");


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        //findes heltal i filen?
        System.out.println("Heltal i filen: " + linFileSearch( "C:\\Users\\annae\\IdeaProjects\\projekt 1\\talfil.txt", 982));


    }
    public static boolean linFileSearch(String fileName, int target){

        File filein = new File(fileName);
        Scanner scan = new Scanner(System.in);
        boolean heltalFundet = false;

        while (!heltalFundet && scan.hasNext()){
            int tal = scan.nextInt();
            if (tal == target){
                heltalFundet = true;
            }
        }
        scan.close();

        return heltalFundet;
    }

}
