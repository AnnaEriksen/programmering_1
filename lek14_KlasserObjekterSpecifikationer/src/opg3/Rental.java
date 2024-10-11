package opg3;

import java.time.LocalDate;

public class Rental {

    private int number;
    private double price;
    private int days;
    private LocalDate startDate;

    public Rental(int number, int days,  double price,LocalDate startDate){
        this.number = number;
        this.price = price;
        this.startDate = startDate;
        this.days = days;
    }

    public double getPricePrDay(){
        return price;
    }

    public void setDays(int days){
        this.days = days;
    }

    public int getDays(){
        return days;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate(){
        return startDate.plusDays(days);
    }

    public double getTotalPrice(){
        return price * days;
    }

}
