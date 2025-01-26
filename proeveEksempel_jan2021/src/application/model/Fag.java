package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fag {
    private String navn;
    private String klasse;

    private ArrayList<Lektion> lektioner = new ArrayList<>();

    public Fag(String navn, String klasse) {
        this.navn = navn;
        this.klasse = klasse;
    }

    public String getNavn() {
        return navn;
    }

    public String getKlasse() {
        return klasse;
    }

    //--

    public ArrayList<Lektion> getLektioner() {
        return new ArrayList<>(lektioner);
    }


    public void addLektion(Lektion lektion) {
        if (!lektioner.contains(lektion)) {
            lektioner.add(lektion);
        }
    }

//    public void removeLektion(Lektion lektion) {
//        if (lektioner.contains(lektion)) {
//            lektioner.remove(lektion);
//        }
//    }

    //--

    public ArrayList<Studerende> sygdomPåDato(LocalDate date) {
        ArrayList<Studerende> sygeStuderende = new ArrayList<>();
        for (Lektion l : getLektioner()) {
            if (date.equals(l.getDato())) {
                for (Deltagelse d : l.getDeltagelser()) {
                    if (d.getStatus().equals(DeltagerStatus.SYG) && !sygeStuderende.contains(d.getStuderende())) {
                        sygeStuderende.add(d.getStuderende());
                    }
                }
            }
        }

        return sygeStuderende;
    }

    //--

    public Lektion lektionMedMestFravær() {
        Lektion lektion = null;
        int count = 0;
        int lektionMedMestFravær = Integer.MIN_VALUE;

        for (Lektion l : getLektioner()) {
            for (Deltagelse d : l.getDeltagelser()) {
                if (d.erRegistreretFraværende()) {
                    count++;
                }
            }
            if (count > lektionMedMestFravær) {
                lektion = l;
                lektionMedMestFravær = count;
                count = 0;
            }
        }
        return lektion;
    }

    @Override
    public String toString() {
        return navn + " " + klasse;
    }
}
