package storage;

import model.Forestilling;
import model.Kunde;
import model.Plads;

import java.util.ArrayList;

public class Storage {
//    Tilføj klassen Storage i pakken storage. Klassen skal indeholde lister med systemets
//    forestillinger, kunder og pladser. Klassen skal også indeholde metoder til at gemme objekter af
//    klasserne Forestilling, Kunde og Plads, og metoder til at hente alle forestillinger, kunder
//    og pladser.

    public static ArrayList<Forestilling> forestillinger = new ArrayList<>();
    public static ArrayList<Kunde> kunder = new ArrayList<>();
    public static ArrayList<Plads> pladser = new ArrayList<>();


//-------------------------------------------------------------------------------------
    public static ArrayList<Forestilling> getForestillinger() {
        return new ArrayList<>(forestillinger);
    }

    public static void addForestillinger(Forestilling forestilling) {
        forestillinger.add(forestilling);
    }
    //-------------------------------------------------------------------------------------
    public static ArrayList<Kunde> getKunder() {
        return new ArrayList<Kunde>(kunder);
    }

    public static void addKunde(Kunde kunde) {
        kunder.add(kunde);
    }
//-------------------------------------------------------------------------------------
    public static ArrayList<Plads> getPladser() {
        return new ArrayList<Plads>(pladser);
    }

    public static void addPladser(Plads plads) {
        pladser.add(plads);
    }
//-------------------------------------------------------------------------------------


}
