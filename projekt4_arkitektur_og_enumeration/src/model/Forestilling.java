package model;

import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Timer;

public class Forestilling {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;

    // composition 1 --> 0..* Bestilling

    private final ArrayList<Bestilling> bestillinger = new ArrayList<>();


    public Forestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public String getNavn() {
        return this.navn;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    @Override
    public String toString() {
        return navn + " " + startDato + " " + slutDato;
    }

    //-----------------------------------------------------

    // TODO: metoder til linkattributten til Bestilling klassen
    public ArrayList<Bestilling> getBestillinger() {
        return new ArrayList<>(bestillinger);
    }

    public Bestilling CreateBestilling(LocalDate date, Kunde kunde){
        Bestilling bestilling = new Bestilling(date, kunde, this); //når jeg allerede er inde i den klasse
        // hvis parametre jeg skal kalde, bruger man "this"
        bestillinger.add(bestilling);
        return bestilling;
    }



    public boolean erPladsLedig(int række, int nr, LocalDate dato){
        boolean erLedig = true;
        for (Bestilling b : bestillinger) {
            if (b.getDato().equals(dato)){
               for (Plads p : b.getPladser()){
                   if (p.getNr() == nr && p.getRække() == række){
                       erLedig = false;

                   }
               }

            }
            
        }

        return erLedig ;

    }

    public int antalBestiltePladserPaaDag(LocalDate dato) {
        int antal = 0;
        for (Bestilling b : bestillinger) {
            if (b.getDato().equals(dato)){
            antal += b.getPladser().size();
        }
    }
        return antal;

    }

    public LocalDate succesDato() {
        LocalDate successDato = null;
        int max = 0;
        for (Bestilling b : bestillinger) {
            if (antalBestiltePladserPaaDag(b.getDato()) > max){
                max = antalBestiltePladserPaaDag(b.getDato());
                successDato = b.getDato();

            }

        }
        return successDato;
    }
}
