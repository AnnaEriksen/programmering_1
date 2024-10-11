package lektion4;
import java.util.Scanner;
public class opgave2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //få bruger til at taste et tal
        System.out.println("Type a positive or negative number: ");
        //declare en variabel

        int number1 = scan.nextInt();

        //udregn om tallet er positivt eller negatvivt
        if (number1 < 0){
            System.out.println("number is negative");
        } //hvis taller er ..... ellers gør ..
        else if (number1 > 0){
            System.out.println("number is positive");

        }
        else{
            System.out.println("number equals 0 ");
        }




    }
}
