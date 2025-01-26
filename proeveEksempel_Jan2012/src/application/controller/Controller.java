package application.controller;

import application.model.Hold;
import application.model.Medlem;
import application.model.Tilmelding;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {
    // S4 (10 points) 2/2
    //Programmer klasserne Service og Dao med de tilhørende metoder til at gemme og opdatere objekter af klasserne Medlem og Hold.

    // Programmer også metoder til at hente listerne.
    //Bemærk : du behøver ikke at lave metoder til at slette objekterne.

    //Tilføj en static void createSomeObjects()metode til Dao klassen, der opretter og gemmer to hold og 5 medlemmer.
    // Tre medlemmer tilmeldes det ene hold, to som VIPmedlemmer og to medlemmer tilmeldes det andet hold, en som VIPmedlem.
    // ********  LAVET SOM INITSTORAGE I CONTROLLER


    public static Hold createHold(String navn, String disciplin, int maxAntal) {
        Hold hold = new Hold(navn, disciplin, maxAntal);
        Storage.addHold(hold);
        return hold;
    }

    public static Medlem createMedlem(String navn, String adresse, String email, int mobiltlf) {
        Medlem medlem = new Medlem(navn, adresse, email, mobiltlf);
        Storage.addMedlem(medlem);
        return medlem;
    }


    public static ArrayList<Medlem> getMedlemmer() {
        return Storage.getMedlemmer();
    }

    public static ArrayList<Hold> getAlleHold() {
        return Storage.getAlleHold();
    }

    public static void updateMedlem(Medlem medlem, String navn, String adresse, String email, int mobiltlf) {
        medlem.setNavn(navn);
        medlem.setAdresse(adresse);
        medlem.setEmail(email);
        medlem.setMobiltlf(mobiltlf);
    }

    public static void updateHold(Hold hold, String navn, String disciplin, int maxAntal) {
        hold.setDisciplin(disciplin);
        hold.setNavn(navn);
        hold.setMaxAntal(maxAntal);
    }

    // S5 (7 points)
    // returnerer en ArrayList af hold, der kan tage mindst det antal deltagere der er angivet i parameteren antal.
    public static ArrayList<Hold> findStoreHold(int antal) {
        ArrayList<Hold> holdMedPlads = new ArrayList<>();
        for (Hold h : getAlleHold()) {
            if (h.getMaxAntal() >= antal) {
                holdMedPlads.add(h);
            }
        }
        return holdMedPlads;

    }

    // S6 (8 points)
    // Objekter af klassen Medlem skal kunne sammenlignes på medlemmernes navne, så et medlem kommer før et andet medlem,
    // hvis et medlems navn kommer før et andet medlems navn i henhold til den naturlige ordning af String.
    // Lad klassen Medlem implementere interfacet Comparable, så ovenstående implementeres.

    public void insertionSort(ArrayList<Medlem> list) {
        for (int i = 1; i < list.size(); i++) { // starter i = 1, da i = 0 betragtes sorteret
            Medlem next = list.get(i); // gemmer det element vi kigger på i øjeblikket
            int j = i; // den position hvor next skal indsættes
            boolean found = false; // til at stoppe while, når den rigtige position er fundet
            while (!found && j > 0) { // så længe !found og har flere elementer tilbage at tjekke j > 0 dvs., når hen til starten af listen
                if (next.getNavn().compareTo(list.get(j - 1).getNavn()) >= 0) { // hvis navnet i next er alfabetisk >= navn på kunden før (j-1),
                    found = true; //, så er den på den rigtige position og løkken stoppes ved found = true;
                } else {
                    list.set(j, list.get(j - 1)); // j-1 sættes på j's plads
                    j--; // går en position tilbage for at sammenligne næste element
                }
            }
            list.set(j, next); // når den rigtige position findes (eller løkken stopper), sættes next på j's position
        }
    }


    //Tilføj en static void createSomeObjects()metode til Dao klassen, der opretter og gemmer to hold og 5 medlemmer.
    // Tre medlemmer tilmeldes det ene hold, to som VIPmedlemmer og to medlemmer tilmeldes det andet hold, en som VIPmedlem.
    public static void initStorage() {
        Hold h1 = createHold("h1", "Yoga", 30);
        Hold h2 = createHold("h2", "Cykling", 30);

        Medlem m1 = createMedlem("Bo", "Christian X's vej", "@", 12345678);
        Medlem m2 = createMedlem("Ronja", "Christian X's vej", "@", 12345678);
        Medlem m3 = createMedlem("Jan", "Christian X's vej", "@", 12345678);
        Medlem m4 = createMedlem("Tom", "Christian X's vej", "@", 12345678);
        Medlem m5 = createMedlem("Tina", "Christian X's vej", "@", 12345678);

        // h1
        Tilmelding t1 = h1.createTilmelding(true, true, m1);
        Tilmelding t2 = h1.createTilmelding(true, true, m2);
        Tilmelding t3 = h1.createTilmelding(true, false, m3);
        // h2
        Tilmelding t4 = h2.createTilmelding(true, true, m4);
        Tilmelding t5 = h2.createTilmelding(true, false, m5);







    }
}
