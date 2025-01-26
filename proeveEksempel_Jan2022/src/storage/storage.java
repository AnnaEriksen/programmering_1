package storage;

import application.model.Forhindring;
import application.model.Løb;

import java.time.LocalDate;
import java.util.ArrayList;

public class storage {

    //Opgave S6 (3 point)
    //Tilføj klassen Storage til dit projekt. Klassen skal indeholde to ArrayList’er med systemets
    //løb og forhindringer. Programmér klassen Storage med de tilhørende metoder til at gemme objekter
    //af klasserne Løb og Forhindring. Programmer også metoder til at hente listerne.
    //Bemærk: Du behøver ikke at lave metoder til at slette objekterne fra Storage.

    private static ArrayList<Løb> løbs = new ArrayList<>();
    private static ArrayList<Forhindring> forhindringer = new ArrayList<>();

    public static void addLøb(Løb løb){
        løbs.add(løb);
    }

    public static ArrayList<Løb> getLøbs() {
        return new ArrayList<>(løbs);
    }

    public static void addForhindringer(Forhindring forhindring){
        forhindringer.add(forhindring);

    }

    public static ArrayList<Forhindring> getForhindringer() {
        return new ArrayList<>(forhindringer);
    }


}
