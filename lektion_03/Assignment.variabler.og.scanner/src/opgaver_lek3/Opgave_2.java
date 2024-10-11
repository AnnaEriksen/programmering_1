package opgaver_lek3;

import java.util.Scanner;
public class Opgave_2 {public static void main(String[]args){
    Scanner input = new Scanner(System.in);

    System.out.println("Indtast beløb" );

    //Da vi har med kommatal at gøre, skal vi bruge double
double købsBeløb = input.nextDouble();
    double moms = købsBeløb * 0.25;

    System.out.println("momsen er " + (int)(moms * 100 / 100));


}
}
