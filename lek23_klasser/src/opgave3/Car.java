package opgave3;

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

    public void addRentals(Rental rental){
        if (!rentals.contains(rental)) {
            rentals.add(rental);
        }
    }

    public void removeRentals(Rental rental){
        if (rentals.contains(rental)) {
            rentals.remove(rental);

        }
    }
}

