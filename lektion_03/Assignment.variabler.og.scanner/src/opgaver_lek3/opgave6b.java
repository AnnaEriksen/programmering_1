package opgaver_lek3;

import java.util.Scanner;
public class opgave6b {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("indtast heltal fra 0 til 1000");

        //Når du divider 932 med 10 får du 93.2 for at dividere med 10 rykker kommaet til venstre.
                //Og modulus (%) giver dig kun det der står efter kommaet.
        //Dvs. 932 % 10 = 2 og derfor kan man også sige 932 / 10 = 93
                // (fordi int fjerner decimal) 93 % 10 = 3. osv osv.

        int number = scan.nextInt();
        int firstDigit = number % 10;
        int secondDigit = (number / 10) % 10;
        int thirdDigit = (number / 100) % 10;
        int fourthDigit = (number / 1000) % 10;

        int sum = firstDigit + secondDigit + thirdDigit + fourthDigit;

        System.out.println("Sum of all digits " + sum);



    }
}
