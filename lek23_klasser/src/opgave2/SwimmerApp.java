package opgave2;

import model.Swimmer;

import java.util.ArrayList;

public class SwimmerApp {
    
    public static void main(String[] args) {

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        Swimmers s1 = new Swimmers("Jan", 1994, lapTimes, "AGF");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        Swimmers s2 = new Swimmers("Bo", 1995, lapTimes, "Lyseng");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);


        System.out.println(s1.getName() + "'s bedste tid: " + s1.bestLapTime());

        TrainingPlan t1 = new TrainingPlan('A', 20, 20);

        t1.addSwimmer(s1);
        t1.addSwimmer(s2);


        //opgave 2
        for (Swimmers s: t1.getSwimmers()){
            System.out.println(s.getName());
        }

        System.out.println("Til plan A " + t1.getSwimmers().getFirst());
        System.out.println("Til plan A " + t1.getSwimmers().getLast());








    }
    
}
