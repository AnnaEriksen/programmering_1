package opg3;

import java.time.LocalDate;

public class RentalApp {
    public static void main(String[] args) {

        //sæt alle dine parametre ind i parentesen
        Rental r1 = new Rental(304, 300, 500, LocalDate.of(2024,11,1));

        //denne her giver 10 måneder fra i dag
        Rental r2 = new Rental(304, 300, 500, LocalDate.now().plusMonths(10));

        System.out.println("Price: " + r1.getTotalPrice());
        System.out.println("Price: " + r2.getTotalPrice());
        System.out.println("=====================");
        System.out.println("End Date: " + r1.getEndDate());
        System.out.println("End Date: " + r2.getEndDate());
        System.out.println("Start Date: " + r1.getStartDate().minusDays(1));




    }
}
