package lek6;
import java.util.Scanner;
public class opg1b {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Indtast et heltal: ");
        int heltal = scan.nextInt();
        løbendeSum(heltal);
    }
    public static void løbendeSum(int input) {
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        while (input != 0){
            sum = sum + input;
            System.out.println("Din sum er " + sum);
            System.out.println("Indtast en nyt tal eller fslut prompten med et 0 ");
            input = scan.nextInt();
        }





    }
}
