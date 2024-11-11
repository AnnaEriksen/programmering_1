package opgave1;

import java.util.ArrayList;

public class Rental {
    private int number;
    private int days;
    private String date;
    private ArrayList<Car> cars = new ArrayList<>();

    public Rental(int number, int days, String date) {
        this.number = number;
        this.days = days;
        this.date = date;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }


    public ArrayList<Rental> getCars() {
        return new ArrayList<Rental>(days);
    }

    public void addCar(Car car){
        if (!cars.contains(car)) {
            cars.add(car);
            car.addRental(this);
        }
    }

    public void removeCar(Car car){
        if (cars.contains(car)) {
            cars.remove(car);
            car.removeRental(this);

        }
    }

    public double getPrice(){
        double sumOfPrice = 0;
        for (Car c: cars){
            sumOfPrice += c.getPricePerDay();
        }
        return sumOfPrice * getDays();
    }

}


