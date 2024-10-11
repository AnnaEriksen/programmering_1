package lektion4;
import java.util.Scanner;
public class opgave8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Indrast en måned: ");
        int maaned = scan.nextInt();

        System.out.println("Indtast en dag: ");
        int dag = scan.nextInt();

        //
        String aarstid = findAarstid(maaned, dag);
        System.out.println(aarstid);
    }

    public static String findAarstid(int maaned, int dag) {
        String aarstid = "";
//Man skal bruge == når man returnerer strings
// Man kan bruge både if og else if
        // Vinter
        if (maaned == 1 || maaned == 2 || maaned == 3) {
            if (maaned % 3 == 0 && dag >= 21) {
                aarstid = "Foraar";
            } else {
                aarstid = "Vinter";
            }
        }
        // Forår
        else if (maaned == 4 || maaned == 5 || maaned == 6){
            if (maaned % 3 == 0 && dag >= 21) {
                aarstid = "Sommer";
            }
            else {
                aarstid = "Foraar";
            }
        }
        // Sommer
        else if (maaned == 7 || maaned == 8 || maaned == 9){
            if (maaned % 3 == 0 && dag >= 21){
                aarstid = "Efteraar";
            }
            else {
                aarstid = "Sommer";
            }
        }
        // Efterår
        else if (maaned == 10 || maaned == 11 || maaned == 12){
            if (maaned % 3 == 0 && dag >= 21){
                aarstid = "Vinter";
            }
            else{
                aarstid = "Efteraar";
            }
        }
        return aarstid;
    }
}