package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
    private LocalDate dato;
    private Kunde kunde;  // association 0..* --> 1 Kunde
    private Forestilling forestilling; // composition 0..* --> 1 Forestilling

    // association 1 --> 0..* Plads
    private final ArrayList<Plads> pladser = new ArrayList<>();

    public Bestilling(LocalDate dato, Kunde kunde, Forestilling forestilling) {
        this.dato = dato;
        this.kunde = kunde;
        kunde.addBestilling(this);

        // setKunde(kunde); //nu er kunden og bestilling forbundet og den er sat begge veje.
        this.forestilling = forestilling;

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

    // TODO: metoder til linkattributten til Kunde klassen

    public Kunde getKunde() {
        return kunde;
    }

//når man har en linkatttribut der har et 1 tal, så skal det ind i constructoren.

    //-----------------------------------------------------

    // TODO: metoder til linkattributten til Forestilling klassen

    public Forestilling getForestilling() {
        return forestilling;
    }


    //-----------------------------------------------------


    public int samletPris() {
        int samletPris = 0;
        for (Plads plads : pladser) {
            samletPris += plads.getPris();
        }

        return samletPris;
    }

    @Override
    public String toString() {
        return "Bestilling{" +
                "dato=" + dato +
                ", kunde=" + kunde +
                ", forestilling=" + forestilling +
                ", pladser=" + pladser +
                '}';
    }
}
