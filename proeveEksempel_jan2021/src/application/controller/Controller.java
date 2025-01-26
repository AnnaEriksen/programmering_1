package application.controller;

import application.model.*;
import storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    public static Studerende createStuderende(String navn, String email) {
        Studerende studerende = new Studerende(navn, email);
        Storage.addStuderende(studerende);
        return studerende;
    }

    public static Fag createFag(String navn, String klasse) {
        Fag fag = new Fag(navn, klasse);
        Storage.addFag(fag);
        return fag;
    }

    public static Lektion createLektion(LocalDate dato, LocalTime startTid, String lokale, Fag fag) {
        Lektion lektion = new Lektion(dato, startTid, lokale, fag);
        Storage.addLektion(lektion);
        return lektion;
    }

    public static ArrayList<Fag> getFag() {
        return Storage.getFagliste();
    }


    public static void initStorage() {
        Studerende s1 = createStuderende("Peter Hansen", "ph@stud.dk");
        Studerende s2 = createStuderende("Tina Jensen", "tj@stud.dk");
        Studerende s3 = createStuderende("Sascha Petersen", "sp@stud.dk");

        Fag f1 = createFag("PRO1", "20S");
        Fag f2 = createFag("PRO1", "20T");
        Fag f3 = createFag("SU1", "20S");

        Lektion l1 = createLektion(LocalDate.of(2021, 2, 1), LocalTime.of(8, 30), "A1.32", f1);

        Lektion l2 = createLektion(LocalDate.of(2021, 2, 1), LocalTime.of(10, 30), "A1.32", f1);

        Lektion l3 = createLektion(LocalDate.of(2021, 3, 2), LocalTime.of(8, 30), "A1.32", f1);

        Lektion l4 = createLektion(LocalDate.of(2021, 3, 2), LocalTime.of(10, 30), "A1.32", f1);

        opretDeltagelser(f1, s1);

        opretDeltagelser(f1, s2);

        opretDeltagelser(f1, s3);

    }

    //--

    public static void opretDeltagelser(Fag fag, Studerende studerende) {
        for (Lektion l : fag.getLektioner()) {
            l.createDeltagelse(studerende);
        }

    }


    // hjælpemetode til studerendeTilObservation
    public static void insertionSort(ArrayList<Studerende> list) {
        for (int i = 1; i < list.size(); i++) { // starter i = 1, da i = 0 betragtes sorteret
            Studerende next = list.get(i); // gemmer det element vi kigger på i øjeblikket
            int j = i; // den position hvor next skal indsættes
            boolean found = false; // til at stoppe while, når den rigtige position er fundet
            while (!found && j > 0) { // så længe !found og har flere elementer tilbage at tjekke j > 0 dvs., når hen til starten af listen
                if (next.getNavn().compareTo(list.get(j - 1).getNavn()) >= 0) { // hvis fornavnet i next er alfabetisk >= fornavnet på kunden før (j-1),
                    found = true; //, så er den på den rigtige position og løkken stoppes ved found = true;
                } else {
                    list.set(j, list.get(j - 1)); // j-1 sættes på j's plads
                    j--; // går en position tilbage for at sammenligne næste element
                }
            }
            list.set(j, next); // når den rigtige position findes (eller løkken stopper), sættes next på j's position
        }
    }

    public static ArrayList<Studerende> studerendeTilObservation(int grænse) {
        ArrayList<Studerende> studerendeliste = new ArrayList<>();
        for (Studerende s : Storage.getStuderendeliste()) {
            if (s.antalFraværsLektioner() > grænse && !studerendeliste.contains(s)) {
                studerendeliste.add(s);
            }
        }

        insertionSort(studerendeliste); // sorterer listen efter navne
        return studerendeliste;
    }


    public static void fraværOmgængere(String[] omgængere, ArrayList<Studerende> megetFravær, String filnavn) throws FileNotFoundException {

        PrintWriter printWriter = new PrintWriter(filnavn);

        // fletning
//        ArrayList<Studerende> result = new ArrayList<>();

        int i1 = 0; // aktuelle position i 'megetFravær'
        int i2 = 0; // aktuelle position i 'omgængere'

        while (i1 < megetFravær.size() && i2 < omgængere.length) {
            if (megetFravær.get(i1).getNavn().compareTo(omgængere[i2]) < 0) {
                i1++;
            } else if (megetFravær.get(i1).getNavn().compareTo(omgængere[i2]) > 0) {
                i2++;
            } else {
                Studerende s = megetFravær.get(i1);
                printWriter.println(s.getNavn() + " " + s.antalFraværsLektioner());
                i1++;
                i2++;

            }
        }

        printWriter.close();

    }


}
