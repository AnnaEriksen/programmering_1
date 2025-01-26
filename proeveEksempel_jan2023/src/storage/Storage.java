package storage;

import application.model.Saelger;
import application.model.Salg;
import application.model.Salgsannonce;
import application.model.Vare;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Saelger> saelgere = new ArrayList<>();
    private static ArrayList<Vare> varer = new ArrayList<>();
    private static ArrayList<Salg> salgs = new ArrayList<>();
    private static ArrayList<Salgsannonce> salgsannoncer = new ArrayList<>();
    //--


    public static ArrayList<Saelger> getSaelgere() {
        return new ArrayList<>(saelgere);
    }

    public static ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    public static ArrayList<Salg> getSalgs() {
        return new ArrayList<>(salgs);
    }

    public static ArrayList<Salgsannonce> getSalgsannoncer() {
        return new ArrayList<>(salgsannoncer);
    }

    //--

    public static void addSaelger(Saelger saelger) {
        saelgere.add(saelger);
    }

    public static void addVare(Vare vare) {
        varer.add(vare);
    }

    public static void addSalg(Salg salg) {
        salgs.add(salg);
    }

    public static void addSalgsannonce(Salgsannonce salgsannonce) {
        salgsannoncer.add(salgsannonce);
    }

    //--


}
