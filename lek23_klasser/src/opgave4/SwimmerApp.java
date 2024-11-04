package opgave4;

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

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);

        TrainingPlan t1 = new TrainingPlan('A', 20, 20);

        // Opret og tilføj svømmere
        Swimmer s1 = t1.createSwimmer("Bo", 1995, lapTimes, "Lyseng");
        Swimmer s2 = t1.createSwimmer("Jan", 1994, lapTimes, "AGF");

        // Udskriv alle svømmere før fjernelse
        System.out.println("Svømmere før fjernelse:");
        for (Swimmer s : t1.getSwimmers()) {
            System.out.println(s.getName());
        }

        // Fjern svømmeren med objektet s1
        t1.removeSwimmer(String.valueOf(s1));

        // Udskriv alle svømmere efter fjernelse for at bekræfte fjernelse
        System.out.println("\nSvømmere efter fjernelse:");

            System.out.println(s1.getName());
        }
    }

