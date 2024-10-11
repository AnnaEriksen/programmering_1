package lek6;
import java.util.Scanner;
public class opg1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Type a number from 1 to 99: ");
        int heltal = scan.nextInt();
        order(heltal);
    }
    public static void order(int input) {
        int evenNum = 0;
        int oddNum = 0;
        int max = 0;
        int min = 99;

        Scanner scan = new Scanner(System.in);
        while (input != 0){
            if (input < 0 || input > 99){
                System.out.println("invalid number. Type a number between 1 and 99, ending it with a 0: ");
            }
            else{
                if (input % 2 == 0){
                    evenNum++;
                }
                else{
                    oddNum++;
                }
                if (input > max){
                    max = input;
                }
                else if (input < min && input != 0){
                    min = input;
                }
            }
            System.out.println("Type in a new number between 1 and 99, or end with 0: ");
            input = scan.nextInt();
        }
        System.out.println("Det højeste tal er: " + max);
        System.out.println("Det mindste tal er: " + min);
        System.out.println("You have typed " + evenNum + " even numbers and " + oddNum + " odd numbers" );
    }
}
