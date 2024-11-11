package opgave4;

import java.util.ArrayList;

public class HundApp {
    public static void main(String[] args) {


        Hund h1 = new Hund("Benny", 2000, Race.PUDDEL, true);
        Hund h2 = new Hund("Bent", 7500, Race.BOKSER, true);
        Hund h3 = new Hund("Ruth", 3000, Race.TERRIER, true);
        Hund h4 = new Hund("Max", 8000, Race.PUDDEL, true);
        Hund h5 = new Hund("Lille mand", 12000, Race.PUDDEL, true);

        ArrayList<Hund> hunde = new ArrayList<>();

        hunde.add(h1);
        hunde.add(h2);
        hunde.add(h3);
        hunde.add(h4);
        hunde.add(h5);

        System.out.println("samlet pris på puddel: " + samletPris(hunde, Race.PUDDEL));

    }

    public static int samletPris(ArrayList<Hund> hunde, Race race){
        int samletPris = 0;
        for (Hund h : hunde) {
            if (h.getRace().equals(race)) {
                samletPris += h.getPris();

            }
        }
        return samletPris;

    }
}
