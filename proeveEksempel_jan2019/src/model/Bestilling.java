package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
    private LocalDate dato;

    // association 1 --> 0..* Plads
    private final ArrayList<Plads> pladser = new ArrayList<>();

    // association 0..* --> 1 Kunde
    private Kunde kunde;

    // composition 0..* --> 1 Forestilling
    private Forestilling forestilling;

    public Bestilling(LocalDate dato, Kunde kunde, Forestilling forestilling) {
        this.dato = dato;
        // this.kunde = kunde;
        // kunde.addBestilling(this);
        setKunde(kunde);
        this.forestilling = forestilling; // link Bestilling -> Forestilling
    }

    public LocalDate getDato() {
        return dato;
    }

    //-----------------------------------------------------

    public ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    public void addPlads(Plads plads) {
        if (!pladser.contains(plads)) {
            pladser.add(plads);
        }
    }

    public void removePlads(Plads plads) {
        if (pladser.contains(plads)) {
            pladser.remove(plads);
        }
    }

    //-----------------------------------------------------

    // TODO: metoder til linkattributten til Kunde klassen

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        if (this.kunde != kunde) {
            Kunde oldKunde = this.kunde;
            if (oldKunde != null) {
                oldKunde.removeBestilling(this);
            }
            this.kunde = kunde; // link Bestilling -> Kunde
            if (kunde != null) {
                kunde.addBestilling(this); // link Kunde -> Bestilling
            }
        }
    }

    //-----------------------------------------------------

    // TODO: metoder til linkattributten til Forestilling klassen

    public Forestilling getForestilling() {
        return forestilling;
    }

    //-----------------------------------------------------

    // S2
    public int samletPris() {
        int samletPris = 0;
        for (Plads plads : pladser) {
            samletPris += plads.getPris();
        }
        return samletPris;
    }
}
