package enkeltesammenænge;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Kollegie kollegie = new Kollegie("EAAA","Byvej 1");

        Bolig bolig1 = kollegie.createBolig(25, "Byvej 1, lejl. 1", 2000);

        Bolig bolig2 = new Bolig(30, "Byvej 1, lejl 2", 2500);
        kollegie.addBolig(bolig2);

        Lejeaftale aftale1 = bolig1.createLejeaftale(LocalDate.parse("2024-01-01"));

        Lejer hans = new Lejer("Hans", "Datamatiker");
        aftale1.setLejer1(hans);
        Lejer ulla = new Lejer("Ulla", "Datamatiker");
        aftale1.setLejer2(ulla);

        Lejeaftale aftale2 = bolig2.createLejeaftale(LocalDate.parse("2024-08-01"));

        Lejer per = new Lejer("Per", "It-teknolog");
        aftale2.setLejer1(per);
    }
}
