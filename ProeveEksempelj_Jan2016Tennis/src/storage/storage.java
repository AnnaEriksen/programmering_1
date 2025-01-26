package storage;

import application.model.Bane;
import application.model.Medlem;

import java.util.ArrayList;

public class storage {

    //Opgave S4 (3 point)
    //Tilføj klassen Storage til dit projekt. Klassen skal indeholde to ArrayLists med systemets baner og medlemmer.
    // Programmér klassen Storage med de tilhørende metoder til at gemme objekter af klasserne Bane og Medlem.
    // Programmér også metoder til at hente listerne.
    //Bemærk: Du behøver ikke at lave metoder til at slette objekterne fra Storage.


    private static ArrayList<Bane> baner = new ArrayList<>();
    private static ArrayList<Medlem> medlemmer = new ArrayList<>();

    public static ArrayList<Bane> getBaner() {
        return new ArrayList<>();
    }

    public static ArrayList<Medlem> getMedlemmer() {
        return new ArrayList<>();
    }

    public static void addBane(Bane bane){
        baner.add(bane);
    }

    public static void addMedlem(Medlem medlem){
        medlemmer.add(medlem);
    }


}

