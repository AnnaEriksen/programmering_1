package lek5;
import java.util.Scanner;;
public class opg3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hvad skal der spilles til?: ");
        int tal = scan.nextInt();
        System.out.println(FizzBuzz(tal));

    }

    public static String FizzBuzz(int tal) {

        String result = "";


        int i = 1; //vi starter fra 1
        while (i <= tal){
            if (i % 5 == 0 && i % 3 == 0){
                result += "Fizzbuzz";
            }
            else if (i % 3 == 0){
                result += "Fizz, ";
            }
            else if (i % 5 == 0){
                result += "Buzz";
            }
            else {
                result += i + ",";
            }
        }return result;




    }
}
