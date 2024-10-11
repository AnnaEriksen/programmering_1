package playdice.pigsgame;

import java.util.Scanner;

public class Pigs {
    private static int count1 = 0; // tæller spiller 1's point
    private static int count2 = 0; // tæller spiller 2's point

    public static void main(String[] args) {
        System.out.println("Welcome to the game of pigs !:D");
        printRules(); //kalder metode for at spillets regler
        System.out.println();
        playPigs();

    }
    private static void printRules(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("The game consists of two players who take turns throwing a die ");
        System.out.println("Player 1 throw a die until they get a 1, or decides end the turn, same goes for player 2.");
        System.out.println("if the player gets a 1, they get no points that round and it becomes the next players turn");
        System.out.println("if the player decides to end the turn before they get 1 one, the sum of all their throws is" +
                " added to the players point total");
        System.out.println("The first player to reach 100 points is the winner");
        System.out.println("Have fun and enjoy :D!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private static void playPigs1(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Player 1 rolling...('stop' stops) ");
        String stop = scan.nextLine();
        int eyes = rollDie(); //kalder metode der viser et tilfældigt tal fra 1 til 6

        while (!stop.equals("stop")){
            eyes = rollDie();
            System.out.println("Eyes: " + eyes);
            count1 += eyes;
            System.out.println("Player 1's points currently: " + count1);
            System.out.println();

            if (eyes != 1){
                count1 += eyes;
                System.out.println("Player 1's score is: " + count1);
            }
            else if (eyes == 1){
                count1 = 0;
                System.out.println("PLayer 1's score is: " + count1);
                System.out.println("You lost your points this turn, turn goes to the next player");
                break;
            }
            stop = scan.nextLine();
        }
    }

    private static int rollDie(){return (int) (Math.random() * 6 + 1);
    }

    private static void playPigs2(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Player 2 rolling...('stop' stops)");
        String stop = scan.nextLine();
        int eyes = rollDie();

        while (!stop.equals("stop")){
            eyes = rollDie();
            System.out.println("Eyes: " + eyes);
            count2 += eyes;
            System.out.println("Player 2's points currently: " + count2);

            if (eyes != 1){
                count2 += eyes;
                System.out.println("Player 2's score is: " + count2);
            }

            else if (eyes == 1) {
                count2 = 0;
                System.out.println("Player 2's score is: " + count2);
                System.out.println("You lost your points. The turn goes to the next player");
                break;
            }
        }
            stop = scan.nextLine();
        }
    private static void playPigs(){
      while (count1 != 100 && count2 != 100){
          playPigs1();
          playPigs2();


    }


}
}


