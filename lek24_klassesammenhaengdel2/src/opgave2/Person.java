package opgave2;

import javax.xml.transform.Result;
import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private ArrayList<Gift> gifts = new ArrayList<>();
    private Gift giftGiven;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return this.name;
    }

    public double valueOfGifts(){
        double value = 0;
        for (Gift g: gifts){
            value += g.getPrice();
        }
        return value;
    }

    public Gift getGiftGiven() {
        return giftGiven;
    }

    public void setGiftGiven(Gift giftGiven) { //lige nu ser den sdan her ud,
        // da den ikke er dobbeltrettet
        this.giftGiven = giftGiven;
    }

    public ArrayList<Gift> getGifts() {
        return new ArrayList<>(gifts);
    }

    public void setGifts(ArrayList<Gift> gifts) {
        this.gifts = gifts;
    }

    public ArrayList<Person> whoGave(){
        ArrayList<Person> p = new ArrayList<>();
        for (Gift g: gifts){
            //if sætning for at idiotsikre
            if (!p.contains(g.getPerson())){
            p.add(g.getPerson());
        }
    }
        return p;
    }
}
