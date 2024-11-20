package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Controller {

//    Tilføj klassen Controller i pakken controller. Klassen skal indeholde metoder til at oprette
//    objekter af klasserne Forestilling, Kunde og Plads.


    public static Forestilling createForestilling(String navn, LocalDate startDato, LocalDate slutDato){
        Forestilling forestilling = new Forestilling(navn, startDato, slutDato);
        Storage.addForestillinger(forestilling);
        return forestilling;
    }

    public static Kunde createKunde(String navn, String mobil){
        Kunde kunde = new Kunde(navn, mobil);
        Storage.addKunde(kunde);
        return kunde;
    }

    public static ArrayList<Kunde> getKunder(){
        return Storage.getKunder();
    }

    public static ArrayList<Forestilling> getForestillinger(){
        return Storage.getForestillinger();
    }

    public static ArrayList<Plads> getPladser(){
        return Storage.getPladser();

    }


    public static Plads createPlads(int række, int nr, int pris, Pladstype pladstype){
        Plads plads = new Plads(række, nr, pris, pladstype);
        Storage.addPladser(plads);
        return plads;
    }

    public static Bestilling opretBestillingMedPladser(Forestilling forestilling, Kunde kunde, LocalDate dato, ArrayList<Plads> pladser){
        boolean erLedig = true;


        // Tjek om alle pladser er ledige
        for (Plads p: pladser) {
            if (!forestilling.erPladsLedig(p.getRække(), p.getNr(), dato)){
                erLedig = false;
            }
        }
        // Tjek om datoen ligger inden for forestillingens visningsperiode
        if (dato.isBefore(forestilling.getStartDato()) || dato.isAfter(forestilling.getSlutDato())){
            erLedig = false;
        }

        // Opret bestilling kun hvis dato og alle pladser er ledige. Dvs hvis alle betingelser er opfyldt, ellers forbliver den null.
        Bestilling bestilling = null;
        if (erLedig) {
            bestilling = forestilling.CreateBestilling(dato, kunde);
            for (Plads p : pladser) {
                bestilling.addPlads(p);

            }
        }
        return bestilling;
    }
}