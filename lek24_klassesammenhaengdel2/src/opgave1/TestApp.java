package opgave1;

import opgave1.Rental;

public class TestApp {
    public static void main(String[] args) {
        Car c1 = new Car("FH34860", 2021);
        Car c2 = new Car("VM34058", 2021);
        Car c3 = new Car("MG39485", 2021);
        Car c4 = new Car("HÆ43534", 2021);
        Car c5 = new Car("AA49050", 2021);

        Rental r1 = new Rental(1, 20, "21-11-24");
        Rental r2 = new Rental(2, 20, "23-4-24");

        r1.addCar(c1);
        r1.addCar(c2);
        r1.addCar(c3);
        r2.addCar(c4);
        r2.addCar(c5);

        System.out.println("Pris: " + r1.getPrice());

        System.out.println("max days: " + c1.daysRented());

    }

}
