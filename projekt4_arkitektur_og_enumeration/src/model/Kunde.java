package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Kunde {
    private String navn;
    private String mobil;

    // association 1 --> 0..* Bestilling
    // TODO
    private final ArrayList<Bestilling> bestillinger = new ArrayList<>();
    //når den er final, kan vores variabel kun, i vores tilfælde, pege på én bestemt arraylist.

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

    public void addBestilling(Bestilling bestilling){
        if (!bestillinger.contains(bestilling)){
            bestillinger.add(bestilling);
        }
    }

    public List<Plads> bestiltePladserTilForestillingPådag(Forestilling forestilling, LocalDate dato) {

        //laver en tom arrayliste med
        List<Plads> bestiltePladser = new ArrayList<>();

        //går listen af bestillinger igennem
        for (Bestilling b : forestilling.getBestillinger()) {

            // Tjek om den specifikke kunde har placeret bestillingerne
            if (b.getKunde().equals(this) && b.getDato().equals(dato)){

                //hvis alle betingelser er opfyldt, tilføjer vi alle pladserne til listen af bestilte pladser
                bestiltePladser.addAll(b.getPladser());
            }
        }
        return bestiltePladser;
    }
}
