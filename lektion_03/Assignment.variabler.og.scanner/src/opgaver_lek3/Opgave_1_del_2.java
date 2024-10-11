package opgaver_lek3;

import java.util.Scanner; //Husk at import Scanner
public class Opgave_1_del_2 {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in); //Husk Scanner scan

//Indtast kommatal 1
System.out.println("Indtast kommatal 1 ");
double tal1 = scan.nextDouble();

//Husk at bruge nextDouble();, hvis du bruger "double"

//Indtast kommatal 2
System.out.println("Indtast kommatal 2 ");
double tal2 = scan.nextDouble();

//Indtast kommatal 3
System.out.println("Indtast kommatal 3 ");
double tal3 = scan.nextDouble();

System.out.println("Summen af de tre tal " + (tal1 + tal2 + tal3));
System.out.println("Produktet af de tre tal " + (tal1 * tal2 * tal3));

}
}
