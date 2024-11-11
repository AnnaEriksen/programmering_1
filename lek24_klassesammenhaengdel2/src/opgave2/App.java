package opgave2;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        Gift g1 = new Gift("bil");
        Gift g2 = new Gift("Mobil");
        Gift g3 = new Gift(" Designer taske");
        Gift g4 = new Gift("Smykke");

        //opretter personer
        Person p1 = new Person("Ulla", 40);
        Person p2 = new Person("Henning",45);

        g1.setPrice(200000);
        g2.setPrice(8500);
        g3.setPrice(14000);
        g4.setPrice(2300);

        p2.setGiftGiven(g1);
        p2.setGiftGiven(g2);
        p2.setGiftGiven(g3);
        p2.setGiftGiven(g4);

        ArrayList<Gift> giftList = new ArrayList<>();

        giftList.add(g1);
        giftList.add(g2);
        giftList.add(g3);
        giftList.add(g4);

        p1.setGifts(giftList);

        System.out.println(" Værdien af Ullas gaver: " + p1.valueOfGifts());

        ArrayList<Person> personWhoGives = new ArrayList<>();
        personWhoGives.add(p2);

        g1.setPersoneRecieved(personWhoGives);
        g2.setPersoneRecieved(personWhoGives);
        g3.setPersoneRecieved(personWhoGives);
        g4.setPersoneRecieved(personWhoGives);

        g1.setPerson(p2);
        g2.setPerson(p2);
        g3.setPerson(p2);
        g4.setPerson(p2);

        System.out.println("Ulla fik gaver af: " + p2.whoGave());
        System.out.println("Ulla fik: " + p1.getGifts());







    }
}
