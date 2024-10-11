package playdice.crapsgame;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Craps {
    public static void main(String[] args) {
        System.out.println("Welcome to the game off Craps :D!");
        printRules(); //Kalder metode for at vise regler

        playCraps();
        System.out.println();

        rollDice();

        //Metoden skal kaste de to terninger, indtil kastet er 7 eller point.
        // Metoden returnerer true, hvis point kastes.
        System.out.println();

    }
    private static void printRules(){ //metoden
        System.out.println("==============================================================================================");
        System.out.println("The player throw two dice until he/she wins or loses");
        System.out.println("If the first throw is 7 or 11, the player wins");
        System.out.println("If the first throw is 2, 3, or 12, the player loses");
        System.out.println("If the first throw is 4, 5, 6, 8, 9 or 10 it becomes the players number of points");
        System.out.println("The player keeps rolling the dice, until they lose by landing on 7," +
                " or win by getting the same number they did on the previous throw ");
        System.out.println("if the player doesn't get a 7 or the same number as their previous throw, the game continues");
        System.out.println("=============================================================================================");
    }

    private static void playCraps(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Roll the dice!!");
        String answer = scan.nextLine();

        int[] firstThrow = rollDice(); //vi laver et nyt array med længden 2
        int result = firstThrow[0] + firstThrow[1];
        System.out.println("Result: " + result);

        if (result == 7 || result == 11){
            System.out.println("You won :D! ");
        }
        else if (result ==2 || result == 3 || result == 12){
            System.out.println("You lost ): ");
        }
        else{
            int point = result;
            System.out.println("Your point is: " + point);


            boolean Result2 = rollforPoint(point);
        }

    }
    private static int[] rollDice(){
        int[] firstThrow = new int [2];
        firstThrow[0] = (int) (Math.random() * 6 +1 );
        firstThrow[1] = (int) (Math.random() * 6 +1 );

        return firstThrow;
    }

    private static boolean rollforPoint(int point){

        boolean result = false;//Metoden skal kaste de to terninger, indtil kastet er 7 eller point Metoden returnerer true, hvis point kastes.
        boolean stop = true; // vi laver en boolean for at spillet kan køre videre, hvis spilleren hverken får et vinder- eller taberkast

        while (stop){ // loopet kører indtil "stop" bliver false. Dvs at den kører så længe spilleren ikke får et vinder/taberkast
            System.out.println("Roll again");
            Scanner scan = new Scanner(System.in);
            int[] otherThrows = rollDice();
            int newResult = otherThrows[0] + otherThrows[1];
            System.out.println("You got: " + newResult);

            if (newResult == point){
                result = true;
                stop = false;
                System.out.println("You got your point and won :D! ");
            }
            else if (newResult == 7) {
                stop = false; // loopet stopper
                System.out.println("You lost ):");
            }
        }

        return result;
    }
}
