package lektion4;
import java.util.Scanner;
public class opgave3og7 {
    public static void main(String[]args){
    Scanner scan = new Scanner(System.in);

    //få bruger til at indtaste et heltal

    System.out.println("indtast et heltal: ");
    int nr1 = scan.nextInt();

    System.out.println("indtast et heltal: ");
    int nr2 = scan.nextInt();

    System.out.println("indtast et sidste heltal: ");
    int nr3 = scan.nextInt();
    System.out.println("dit tal er: " + nr1 + nr2 + nr3);

    //udregn om de er i rækkefølge ved hjælp af if og else if - Flyttet til inorder metoden
  /*  if (tal1 < tal2 && tal2 < tal3){
        System.out.println("Tallene er voksende");
    }
    else if (tal1 > tal2 && tal2 > tal3) {
        System.out.println("tallene er aftagende");
    }
    else{
        System.out.println("Tallene er hverken aftagende eller voksende");
    }*/

// Her er opg 7 lavet

        String s = inorder(nr1,nr2,nr3);
        System.out.println(s);
    }

    public static String inorder(int tal1, int tal2, int tal3) {

        String svar = "";

        if (tal1 < tal2 && tal2 < tal3){
            svar = "Tallene er voksende";
        }
        else if (tal1 > tal2 && tal2 > tal3) {
            svar = "tallene er aftagende";
        }
        else{
            svar = "Tallene er hverken aftagende eller voksende";
        }

        return svar;
    }
}
