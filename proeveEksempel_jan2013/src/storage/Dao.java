package storage;

import application.model.Facilitet;
import application.model.Gruppe;

import java.util.ArrayList;

public class Dao {
    // Opgave S4 (5 point)
    // Klassen skal indeholde to ArrayList’er med systemets grupper og faciliteter.
    // Programmer klassen Dao med de tilhørende metoder til at gemme og opdatere objekter af
    // klasserne Gruppe og Facilitet. Programmer også metoder til at hente listerne.
    //Bemærk: du behøver ikke at lave metoder til at slette objekterne fra Dao.

    public static ArrayList<Gruppe> grupper = new ArrayList<>();
    public static ArrayList<Facilitet> faciliteter = new ArrayList<>();

    public static ArrayList<Gruppe> getGrupper() {
        return new ArrayList<>(grupper);
    }

    public static ArrayList<Facilitet> getFaciliteter() {
        return new ArrayList<>(faciliteter);
    }

    public static void addGruppe(Gruppe gruppe) {
        grupper.add(gruppe);
    }

    public static void addFacilitet(Facilitet facilitet) {
        faciliteter.add(facilitet);
    }

    public static void updateGruppe(Gruppe gruppe,int nr) {
        gruppe.setNr(nr);
    }

    public static void updateFacilitet(Facilitet facilitet, String navn, int minimumsalder, String åbningstid, int pris) {
        facilitet.setNavn(navn);
        facilitet.setMinimumsalder(minimumsalder);
        facilitet.setÅbningstid(åbningstid);
        facilitet.setPris(pris);
    }
    

}
