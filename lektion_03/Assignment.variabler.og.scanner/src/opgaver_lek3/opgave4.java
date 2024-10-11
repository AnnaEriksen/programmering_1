package opgaver_lek3;

import java.util.Scanner;
public class opgave4 {
    public static void main(String[]args){
   Scanner scan = new Scanner(System.in);
        System.out.print("Monthly Income");

        double monthlySalary = scan.nextDouble();
        double yearlySalay = monthlySalary * 12;
        double taxableIncome = yearlySalay - 48000;
        double YearlyTax = taxableIncome * 37 /100;
        double monthlyTax = YearlyTax / 12;

        System.out.println("monthlyTax " + monthlyTax);




}
}
