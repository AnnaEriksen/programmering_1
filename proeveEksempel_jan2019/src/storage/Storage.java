package storage;

import model.Forestilling;
import model.Kunde;

import java.util.ArrayList;

public class Storage {
    public static ArrayList<Forestilling> forestillinger = new ArrayList<>();
    public static ArrayList<Kunde> kunder = new ArrayList<>();


    public static ArrayList<Forestilling> getForestillinger() {
        return new ArrayList<>(forestillinger);
    }

    public static ArrayList<Kunde> getKunder() {
        return new ArrayList<>(kunder);
    }

    public static void addForestilling(Forestilling forestilling){
        forestillinger.add(forestilling);
    }

    public static void addKunde(Kunde kunde){
        kunder.add(kunde);
    }






}
