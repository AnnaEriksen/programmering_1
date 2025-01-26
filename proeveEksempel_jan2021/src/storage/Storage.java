package storage;


import application.model.Fag;
import application.model.Lektion;
import application.model.Studerende;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Fag> fagliste = new ArrayList<>();
    private static ArrayList<Studerende> studerendeliste = new ArrayList<>();

    private static ArrayList<Lektion> lektioner = new ArrayList<>();


    public static ArrayList<Fag> getFagliste() {
        return new ArrayList<>(fagliste);
    }

    public static void addFag(Fag fag) {
        fagliste.add(fag);
    }

    public static ArrayList<Studerende> getStuderendeliste() {
        return new ArrayList<>(studerendeliste);
    }

    public static void addStuderende(Studerende studerende) {
        studerendeliste.add(studerende);
    }

    public static void addLektion(Lektion lektion) {
        lektioner.add(lektion);
    }


}
