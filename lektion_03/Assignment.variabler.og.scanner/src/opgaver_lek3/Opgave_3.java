package opgaver_lek3;

import java.util.Scanner;
public class Opgave_3 {public static void main(String[]args){
    Scanner scan = new Scanner(System.in);

    System.out.println("Tal i mil");
    double miles = scan.nextDouble();

    double kilometers = miles * 1.6;

    System.out.println("mil konverteret til kilometer " + kilometers);

}
}
