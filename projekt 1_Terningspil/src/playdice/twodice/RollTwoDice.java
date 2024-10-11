package playdice.twodice;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Arrays;
import java.util.Scanner;

public class RollTwoDice {
    private static int rollCount = 0;
    private static int sum = 0;
    private static int countDoubles = 0;
    private static int[] tabel = new int[7];

    public static void main(String[] args) {
        System.out.println("Welcome to the game of Roll Two Dice :D!");
        printRules();
        System.out.println();
        System.out.println();
        playTwoDice();
        System.out.println();
        System.out.println("Thank you for playing rollTwoDice!");
    }

    private static void printRules(){
        System.out.println("=====================================================");
        System.out.println("Rules of Roll the Dice: ");
        System.out.println("The player rolls two dice as long as he/she wants.");
        System.out.println("=====================================================");
    }

    private static void playTwoDice(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Roll? ('no' stops) ");
        String answer = scan.nextLine();

        while (!answer.equals("no")) {
            int[] eyes = rollDice();
            System.out.println("Eyes: " +  Arrays.toString(eyes));
            System.out.println();

            updateStatistics(eyes); //ved nyt opdateres kast
            int max = 0;
            for (int i = 0; i < 1; i++)
                if (eyes[0] > eyes[1]){
                    max = eyes[0];
                    System.out.println("Biggest eye: " + max);
                }

            //vi skal lave en if-sætning for at finde ud af hvad er størst
            if (eyes[1] > eyes[0]){
                max = eyes[1];
                System.out.println("Biggest eye: " + max);
            }
            if (eyes[0] == eyes[1]){
                System.out.println("The eyes are even");
            }
            System.out.print("Roll? ('no' stops) ");
            answer = scan.nextLine();
        }
        printStatistics();
        scan.close(); //scanneren lukkes ned
    }

    private static int[] rollDice(){
        int[] eyes = new int [2];
        eyes[0]  = (int) (Math.random() * 6 + 1);
        eyes[1] =(int) (Math.random() * 6 + 1);
        return eyes;
    }

    private static void updateStatistics(int[] eyes) {
        rollCount++;
        int CurrentSum = eyes[0] + eyes[1];
        sum = sum + CurrentSum;

        ////her er der lavet et forloop for finde dubletter. Grunden til at i < 1 er...(..)

        for (int i = 0; i < 1; i++){ //hvis vi slår 4 på 0´s plads,
            // tælles plads nr 4 op i det nye array med 1
            if (eyes[0] == eyes[1]){
                countDoubles++;
            }
        }
        tabel[eyes[0]]++;
        tabel[eyes[1]]++;
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.println("Roll count: " + rollCount);
        System.out.println("The total sum is: " + sum);
        System.out.println("Doubles: " + countDoubles);


        //vi kan lave et for loop der printer det ud, ændrer tekst og tæller op, men ved ikke lige hvordan.
        for(int i = 1; i <= 6; i++){
            System.out.println("Eye " + i + " occurrences: " + tabel[i] );

        }
    }
}

