package Storage;

import Application2020.model2020.Festival;
import Application2020.model2020.FrivilligForening;

import java.util.ArrayList;

public class Storage {

    //Opgave S4 (3 point)
    //Tilføj klassen Storage i pakken storage. Klassen skal indeholde lister med festivaler og frivillige.
    //Klassen skal også indeholde metoder til at gemme objekter af klasserne Festival og Frivillig,
    //og metoder til at hente alle festivaler og frivillige. Lav ikke metoder til at slette objekterne fra



    private static ArrayList<Festival> festivaller = new ArrayList<>();
    private static ArrayList<FrivilligForening> frivilligeForeninger = new ArrayList<>();

    public static ArrayList<Festival> getFestivaller() {
        return festivaller;
    }

    public static ArrayList<FrivilligForening> getFrivilligeForeninger() {
        return frivilligeForeninger;
    }

    public static void addFestivaller(Festival festival){
        festivaller.add(festival);
    }

    public static void addFrivilligeForeninger(FrivilligForening frivilligForening){
        frivilligeForeninger.add(frivilligForening);
    }


}
