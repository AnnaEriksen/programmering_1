package opgaver_lek3;

import java.util.Scanner;
public class opgave6a {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);

        System.out.println("subtotal");
        double subTotal = Scan.nextDouble();

        System.out.println("gratuityrate");
        double gratuityRate = Scan.nextDouble();

        double gratuity = subTotal * (gratuityRate / 100);
        double total = subTotal + gratuity;
        System.out.println("gratuity: " + gratuity);
        System.out.println("total: " + total);








}
}
