package application.model;

import java.util.ArrayList;

public class Fag {

    private String navn;
    private String klasse;
    private ArrayList<Lektion> lektioner = new ArrayList<>(); //link til lektionklassen



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

    public ArrayList<Lektion> getLektioner() {
        return new ArrayList<>(lektioner);
    }

    public void addLektion(Lektion lektion) {
        if (!lektioner.contains(lektion)) {
            lektioner.add(lektion);
        }
    }

    /**
     * Removes the person from this group,
     * if they are connected.
     */
    public void removeLektion(Lektion lektion) {
        if (lektioner.contains(lektion)) {
            lektioner.remove(lektion);
        }
    }


}
