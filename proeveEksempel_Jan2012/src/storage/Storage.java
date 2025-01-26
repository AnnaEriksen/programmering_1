package storage;


import application.model.Hold;
import application.model.Medlem;

import java.util.ArrayList;

// S4 (10 points) 1/2
// Klassen Dao skal indeholde to ArrayList’er med systemets medlemmer og hold, navnene på listerne er medlemmer og alleHold.

//Programmer klasserne Service og Dao med de tilhørende metoder til at gemme og opdatere objekter af klasserne Medlem og Hold.

// Programmer også metoder til at hente listerne.
//Bemærk : du behøver ikke at lave metoder til at slette objekterne.

//Tilføj en static void createSomeObjects()metode til Dao klassen, der opretter og gemmer to hold og 5 medlemmer. Tre medlemmer tilmeldes det ene hold, to som VIPmedlemmer og to medlemmer tilmeldes det andet hold, en som VIPmedlem.
// ********  LAVET SOM INITSTORAGE I CONTROLLER

public class Storage {
    private static ArrayList<Medlem> medlemmer = new ArrayList<>();
    private static ArrayList<Hold> alleHold = new ArrayList<>();

    public static void addMedlem(Medlem medlem) {
        medlemmer.add(medlem);
    }

    public static void addHold(Hold hold) {
        alleHold.add(hold);
    }

    public static ArrayList<Medlem> getMedlemmer() {
        return new ArrayList<>(medlemmer);
    }

    public static ArrayList<Hold> getAlleHold() {
        return new ArrayList<>(alleHold);
    }

    // S7 (10 points)
    //Tilføj til klassen Dao en ny metode
    //public static void indsætMedlem(Medlem medlem)
    //der indsætter et nyt medlem i listen af medlemmer i Dao’en .
    // Listen af medlemmer antages at være sorteret i stigenden orden efter navn på medlemmet.
    // Det er et krav at listen stadig er sorteret efter indsættelsen.
    // Det er et krav at princippet fra indsættelsessorteringen(insertion sort) benyttes i metoden. Bemærk: Der må ikke laves en fuld sortering.

    public static void indsætMedlem(Medlem medlem) {
        boolean found = false;
        int i = 0;
        while (!found && i < medlemmer.size()) {
            if (medlemmer.get(i).getNavn().compareTo(medlem.getNavn()) > 0) {
                found = true;
            } else {
                i++;
            }

        }
        medlemmer.add(i, medlem);
    }


}
