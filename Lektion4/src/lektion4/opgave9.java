package lektion4;
import java.util.Scanner;
public class opgave9 {public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

// vi erklærer vores variabler og initialiserer dem ved at give en værdi
    int elapsedDays = 0;
    int day = 0;

    //vi beder brugeren om input
    System.out.println("Indtast  nr på i dag (0-6) hvor søndag er 0: ");
    day = scan.nextInt();
    System.out.println("Indtast det antal dage for en fremtidig dag:  ");
    elapsedDays = scan.nextInt();

    // vi laver en string der kan gemme returen fra futureday
    String result;

    //Definer result. Result bliver assignet med returværdien fra futureday
    result = futureDay(day, elapsedDays);
    System.out.println("Future day is " + result);
}
    //Det er lettest at lave selve metoden, der regner det ud først.
    public static String futureDay(int day, int elapsedDays){

        String today = "";
        int numberOfWeekDays = 7;
        int numberOfDaysSum = day + elapsedDays;
        int resultDay = numberOfDaysSum % 7;

        if (resultDay == 0){
            today = "Sunday";
        }
        if (resultDay == 1){
            today = "Monday";
        }
        if (resultDay == 2){
            today = "Tuesday";
        }
        if (resultDay == 3){
            today = "Wednesday";
        }
        if (resultDay == 4){
            today = "Thursday";
        }
        if (resultDay == 5){
            today = "Friday";
        }
        if (resultDay == 6){
            today = "Saturday";
        }

        return"Today is: " + today;
    }
}
