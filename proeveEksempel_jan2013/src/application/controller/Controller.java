package application.controller;

import application.model.Facilitet;
import application.model.Gruppe;
import application.model.PersonChip;
import storage.Dao;

import java.util.ArrayList;
import java.util.SortedMap;

public class Controller {
    public static Gruppe createGruppe(int nr) {
        Gruppe gruppe = new Gruppe(nr);
        Dao.addGruppe(gruppe);
        return gruppe;
    }

    public static PersonChip createPersonChip(int nr, String navn, int maxSaldo, int alder, Gruppe gruppe) {
        PersonChip personChip = new PersonChip(nr, navn, maxSaldo, alder, gruppe);
        return personChip;
    }

    public static Facilitet createFacilitet(String navn, int minimumsalder, String åbningstid, int pris) {
        Facilitet facilitet = new Facilitet(navn, minimumsalder, åbningstid, pris);
        Dao.addFacilitet(facilitet);
        return facilitet;
    }

    public static ArrayList<Gruppe> getGrupper() {
        return Dao.getGrupper();
    }

    public static ArrayList<Facilitet> getFaciliteter() {
        return Dao.getFaciliteter();
    }


    // opretter objekter - createSomeObjects()
    public static void initStorage() {
        Gruppe g1 = createGruppe(1);

        PersonChip p1 = createPersonChip(1, "Peter", 200, 12, g1);
        PersonChip p2 = createPersonChip(2, "Søren", 0, 35, g1);
        PersonChip p3 = createPersonChip(3, "Camilla", 300, 15, g1);


        Facilitet f1 = createFacilitet("Badeland", 3, "08.00-22.00", 0);
        Facilitet f2 = createFacilitet("Bowling", 10, "08.00-22.00", 50);
        Facilitet f3 = createFacilitet("Billard", 15, "08.00-22.00", 75);

        p1.addFacilitet(f1);
        p1.addFacilitet(f3);

        p2.addFacilitet(f1);

        p3.addFacilitet(f1);
        p3.addFacilitet(f2);
        p3.addFacilitet(f3);

        // tester sortering (S7)
        ArrayList<Facilitet> testFacilitetsListe = new ArrayList<>();
        testFacilitetsListe.add(f3);
        testFacilitetsListe.add(f1);
        testFacilitetsListe.add(f2);
        sorteretFaciliteter(testFacilitetsListe);
        System.out.println(testFacilitetsListe);


    }

    // Opgave S7 (15 point) 1/2
    //Objekter af klassen Facilitet skal kunne sammenlignes på facilitetens alder og pris.
    // En facilitet kommer før en anden facilitet,
    // hvis facilitetens minimumsalder er lavere end den anden facilitets minimumsalder.
    // Hvis minimumsalderen er den samme,
    // sammenlignes der på prisen, og en facilitet kommer før en anden facilitet,
    // hvis facilitetens pris er lavere end den anden facilitets pris.
    // Udvid derfor klassen Facilitet, så den implementerer interfacet Comparable, så ovenstående implementeres.

    // INSERTION SORTERING (dvs., sortere bagfra) - primær og sekundær sortering (mere simpel sammenlignet med OCR-løb)
    public static void sorteretFaciliteter(ArrayList<Facilitet> sorteretFaciliteter) {
        for (int i = 1; i < sorteretFaciliteter.size(); i++) {
            Facilitet next = sorteretFaciliteter.get(i); // det element vi kigger på lige nu
            int j = i; // den position hvor next skal indsættes
            boolean found = false; // til at stoppe while, når den rigtige position er fundet
            while (!found && j > 0) { // så længe !found og har flere elementer tilbage at tjekke j > 0 dvs., når hen til starten af listen
                if (next.getMinimumsalder() > (sorteretFaciliteter.get(j - 1).getMinimumsalder())) {
                    found = true; //, så er den på den rigtige position og løkken stoppes ved found = true;
                } else if (next.getMinimumsalder() == sorteretFaciliteter.get(j - 1).getMinimumsalder() && next.getPris() > sorteretFaciliteter.get(j - 1).getPris()) {
                    found = true; //, så er den på den rigtige position og løkken stoppes ved found = true;
                } else {
                    sorteretFaciliteter.set(j, sorteretFaciliteter.get(j - 1)); // j-1 sættes på j's plads
                    j--; // går en position tilbage for at sammenligne næste element
                }
            }
            sorteretFaciliteter.set(j, next); //
        }
    }


    // Opgave S7 (15 point) 2/2
    //Tilføj til klassen Service en metode alleFaciliteter der fletter alle elementer fra
    // to sorterede lister af faciliteter over i en samlet liste af faciliteter, som returneres.
    //Det kan antages at listen faciliteterTidligere og listen faciliteterNu er sorteret efter faciliteternes alder og pris
    // (jf. Facilitet ovenfor er en implementation af Comparable).
    //Det er et krav at metoden alleFaciliteter er implementeret under anvendelse af fletteskabelonen.

    public static ArrayList<Facilitet> alleFaciliteter(ArrayList<Facilitet> faciliteterTidligere, ArrayList<Facilitet> faciliteterNu) {
        ArrayList<Facilitet> alleFaciliteter = new ArrayList<>();
        int i1 = 0; // holder styr på den aktuelle position i faciliteterTidligere
        int i2 = 0; // -||- faciliteter nu

        while (i1 < faciliteterTidligere.size() && i2 < faciliteterNu.size()) { // flet så længe der er noget i begge lister
            if (faciliteterTidligere.get(i1).getMinimumsalder() < faciliteterNu.get(i2).getMinimumsalder()) {
                // hvis tidligere's min.alder er lavere end nu's min.alder, tilføjes den til listen
                alleFaciliteter.add(faciliteterTidligere.get(i1));
                i1++;
            } else if (faciliteterTidligere.get(i1).getMinimumsalder() > faciliteterNu.get(i2).getMinimumsalder()) {
                // hvis nu's min.alder er lavest, tilføjes denne til listen
                alleFaciliteter.add(faciliteterNu.get(i2));
                i2++;

            } else if (faciliteterTidligere.get(i1).getMinimumsalder() == faciliteterNu.get(i2).getMinimumsalder() && faciliteterTidligere.get(i1).getPris() < faciliteterNu.get(i2).getPris()) {
                alleFaciliteter.add(faciliteterTidligere.get(i1));
                i1++;
            } else if (faciliteterTidligere.get(i1).getMinimumsalder() == faciliteterNu.get(i2).getMinimumsalder() && faciliteterTidligere.get(i1).getPris() > faciliteterNu.get(i2).getPris()) {
                alleFaciliteter.add(faciliteterNu.get(i2));
                i2++;
            }
        }
        while (i1 < faciliteterTidligere.size()) { // hvis der er flere elementer i 'tidligere', tilføjes disse
            alleFaciliteter.add(faciliteterTidligere.get(i1));
            i1++;
        }
        while (i2 < faciliteterNu.size()) {
            alleFaciliteter.add(faciliteterNu.get(i2));
            i2++;
        }
        return alleFaciliteter;

    }


}
