package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Kunde {
    private String navn;
    private String mobil;

    // association 1 --> 0..* Bestilling
    private final ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Kunde(String navn, String mobil) {
        this.navn = navn;
        this.mobil = mobil;
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    @Override
    public String toString() {
        return navn + " " + mobil;
    }

    //-----------------------------------------------------

    // TODO: metoder til linkattributten til Bestilling klassen

    public ArrayList<Bestilling> getBestillinger() {
        return new ArrayList<>(bestillinger);
    }

    public void addBestilling(Bestilling bestilling) {
        if (!bestillinger.contains(bestilling)) {
            bestillinger.add(bestilling); // link Kunde -> Bestilling
            bestilling.setKunde(this); // link Bestilling -> Kunde
        }
    }

    public void removeBestilling(Bestilling bestilling) {
        if (bestillinger.contains(bestilling)) {
            bestillinger.remove(bestilling);
            bestilling.setKunde(null);
        }
    }

    //-----------------------------------------------------

    // S5
    public ArrayList<Plads> bestiltePladserTilForestillingPaaDag(Forestilling forestilling, LocalDate dato) {
        ArrayList<Plads> bestiltePladser = new ArrayList<>(); //orpetter tom liste

        //for hver bestilling tjekker vi, om den matcher den angivne forestilling og dato
        for (Bestilling b : bestillinger) {
            if (b.getForestilling().equals(forestilling) && b.getDato().equals(dato)) { //matcher forestilling og dato
                bestiltePladser.addAll(b.getPladser()); //hvis alle betingelser er opfyldt,
                // tilføjes pladserne til listen af bestilte pladser
            }
        }
        return bestiltePladser;
    }
}
