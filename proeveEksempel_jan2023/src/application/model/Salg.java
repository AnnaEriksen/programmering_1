package application.model;

import java.util.ArrayList;

public class Salg {
    private String købersNavn;
    private int aftaltSamletPris;

    private ArrayList<Vare> varer = new ArrayList<>();

    public Salg(String købersNavn, int aftaltSamletPris, ArrayList<Vare> varer) {
        this.købersNavn = købersNavn;
        this.aftaltSamletPris = aftaltSamletPris;
        this.varer = new ArrayList<>(varer);

        // markerer varerne solgt
        for (Vare v : varer) {
            v.setSolgt(true);
        }
    }

    public ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    public int getAftaltSamletPris() {
        return aftaltSamletPris;
    }

    public String getKøbersNavn() {
        return købersNavn;
    }

    @Override
    public String toString() {
        return "Købers navn: "+ købersNavn +
                "\nAftalt pris: " + aftaltSamletPris +
                "\nVarer: " + varer;
    }
}
