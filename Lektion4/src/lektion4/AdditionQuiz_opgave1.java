package lektion4;

import java.util.Scanner;

public class AdditionQuiz_opgave1 {
    public static void main(String[] args) {

        // Lav to tilfældige tal mellem 1 og 10
        int number1 = (int) ((Math.random() * 10) + 1);
        int number2 = (int) ((Math.random() * 10) + 1);
        int number3 = (int) ((Math.random() * 10) + 1);

        // Create a Scanner
        Scanner input = new Scanner(System.in);

        //her blev + lavet om til *
        System.out.print(
                "What is " + number1 + " * " + number2 + " * " + number3 + "? ");

        int answer = input.nextInt();

        //Her blev plus også lavet om til gange
        boolean correct = number1 * number2 * number3 == answer;

        //Her blev der proppet et "*" ind i mellem plus-ikonerne
        System.out.println(number1 + " * " + number2 + " * " + number3 + " = " + answer + " is " + correct);
    }
}
