package opgaver_lek3;

import java.util.Scanner;
public class Opgave_1 {
 public static void main(String[]args){
  Scanner scan = new Scanner(System.in);

  System.out.print("indtast heltal 1 ");
  int tal1 = scan.nextInt();

  System.out.print("indtast heltal 2 ");
  int tal2 = scan.nextInt();

  System.out.print("indtast heltal 3 ");
  int tal3 = scan.nextInt();

  int sum = tal1 + tal2 + tal3;
  int produkt = tal1 * tal2 * tal3;

  System.out.println("Summen af de tre tal "+ (tal1 + tal2 + tal3));
  System.out.println("Produkt af de tre tal " + (tal1 * tal2 * tal3));


}
}
