package lek5;
import java.util.Scanner;
public class opg4 {
    public static void main(String[] args) {

        //laver en scanner, da jeg skal tage imod et nummer som bliver indtastet.
        Scanner scan = new Scanner(System.in);

        System.out.println("Indtast et nummer: ");
        // vi bruger scanneren til at indlæse tallet

        //det der bliver tastet, bliver gemt i variablen "number"
        int number = scan.nextInt();

        // laver en sout, da resultatet skal printes.vi sætter metodenkaldet
        // "(reverse(number)" ind som parameter til println

        //kalder metode som skal vende rækkefølgen om
        System.out.println(reverse(number));
    }

    //Nu skal der kød på selve metoden så den kan udføre sit job
    public static int reverse(int number){

        //vil skal declare en int (variabel), for at holde styr på resten i % operation.
        int rem = 0;

        //vi skal have en int mere, til det "mellem resultat" vi får i vores reverse
        // , da den kun tager et tal af gangen.
        int rev = 0;

        //resultatet, af hvad der sker i loopet, bliver returneret i return.
        //while loopet bliver brugt at vi skal have vores statements gentaget.
        while (number > 0) {
            rem = number % 10;
            rev = (rev * 10) + rem;
            number = number / 10;
            //vi skal ikke bruge f.eks "i++;, da number = number / 10; sørger for, at det bliver til 0
        }
        return rev;
    }
}