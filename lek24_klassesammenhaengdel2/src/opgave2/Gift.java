package opgave2;

import java.util.ArrayList;

public class Gift {
    private String description;
    private double price;
    private Person person;
    private ArrayList<Person> personeRecieved = new ArrayList<>();

    public Gift(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public ArrayList<Person> getPersoneRecieved() {
        return new ArrayList<>(personeRecieved);
    }

    public void setPersoneRecieved(ArrayList<Person> personer) {
        this.personeRecieved = personeRecieved;
    }

    @Override
    public String toString() {
        return description;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
