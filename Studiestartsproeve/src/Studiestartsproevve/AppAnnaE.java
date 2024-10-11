package Studiestartsproevve;
import java.util.Scanner;
public class AppAnnaE {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Indtast antal km fra EAAA og hjem: ");
        int antalKilometerFraHjemTilEaaa = scan.nextInt();
        System.out.println("Indtast antal gange der er cykklet til EAAA; ");

        int antalGangeCyklet = scan.nextInt();
        int samledeAntalKilometer = 2 * antalKilometerFraHjemTilEaaa * antalGangeCyklet;

        if (samledeAntalKilometer < 100){
            System.out.println("Samlede antal kilometer er lavt");
        }

        if (samledeAntalKilometer > 100 && antalGangeCyklet == 400 ){
            System.out.println("Samlede antal kilometer er mellem");
        }
        else if (samledeAntalKilometer > 400) {
            System.out.println("Samlede distance er høj");

        }


    }

}
