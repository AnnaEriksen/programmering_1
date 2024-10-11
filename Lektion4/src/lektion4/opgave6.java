package lektion4;

import java.util.Scanner;

public class opgave6 {
    public static String sign(int tal1) {

        Scanner scan = new Scanner(System.in);
        String result ="";

        result =" Type a positive or negative number: ";
        int number1 = scan.nextInt();

        //udregn om tallet er positivt eller negatvivt
        if (number1 < 0){
            result =" number is negative";

        } //hvis taller er ..... ellers gør ..
        else if (number1 > 0){
            result =" number is positive";

        }
        else{
            result ="number is 0 ";
        }
        return result;


    }
    public static void main(String[]args){
        //opsæt scanner
        Scanner scan = new Scanner(System.in);

        System.out.println("Indtast positivt eller negativt tal: ");

        //vi laver en variabel
        int tal2 = scan.nextInt();


        System.out.println(sign(tal2));

    }
}



