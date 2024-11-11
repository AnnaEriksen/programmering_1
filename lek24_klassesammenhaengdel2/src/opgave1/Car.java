package opgave1;

import opgave1.Rental;

import java.util.ArrayList;

public class Car {
    private String license;
    private double PricePerDay;
    private int purchaseYear;
    private ArrayList<Rental> rentals = new ArrayList<>();


    public Car(String license, int year) {
        this.license = license;
        this.purchaseYear = year;
        PricePerDay = 20;

    }

    public String getLicense() {
        return license;
    }

    public double getPricePerDay() {
        return PricePerDay;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }

    public void setPricePerDay(double pricePerDay) {
        PricePerDay = pricePerDay;
    }

    public ArrayList<Rental> getRentals() {
        return new ArrayList<Rental>(rentals);
    }

    public void addRental(Rental rental){
        if (!rentals.contains(rental)) {
            rentals.add(rental);
            rental.addCar(this);
        }
    }

    public void removeRental(Rental rental){
        if (rentals.contains(rental)) {
            rentals.remove(rental);
            rental.addCar(this);


        }
    }

    public int daysRented(){
        int max = 0;
        for (Rental r: rentals){
            if (r.getDays() > max){
                max = r.getDays();
            }
        }


        return max;
    }


}

