package opgaver_lek3;

import java.util.Scanner;
public class Opgave3del2 {public static void main(String[]args){

Scanner scan = new Scanner(System.in);

System.out.println("Indtast længden af siderne på en ligesidet trekant");
double sidelængde = scan.nextDouble();
double area = (Math.sqrt(3) / 4 * Math.pow(sidelængde,2));

    System.out.println("Arealet af trekanten " + area);

    double volume = area * sidelængde;
    System.out.println("Volumen af trekanten " + volume);

}
}
