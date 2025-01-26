package storage;

import application.model.Fag;
import application.model.Lektion;
import application.model.Studerende;

import java.util.ArrayList;

public class storage {
    private static final ArrayList<Fag> alleFag = new ArrayList<>();
    private static final ArrayList<Studerende> studenterListe = new ArrayList<>();
    private static final ArrayList<Lektion> lektioner = new ArrayList<>();


    public ArrayList<Fag> getFag() {
        return new ArrayList<>(alleFag);
    }
    public static void addFag(Fag fag){
        alleFag.add(fag);

    }


    public ArrayList<Studerende> getStuderende() {
        return new ArrayList<>(studenterListe);
    }

    public static void addStuderende(Studerende studerende){
        studenterListe.add(studerende);
    }


    public ArrayList<Lektion> getLektioner(){
        return new ArrayList<>(lektioner);
    }

    public static void addLektioner(Lektion lektion){
        lektioner.add(lektion);
    }





}
