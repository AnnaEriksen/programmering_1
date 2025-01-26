package storage;

import model.Arrangement;
import model.Tutor;
import model.Uddannelse;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Uddannelse> uddannelser = new ArrayList<>();
    private static final ArrayList<Tutor> tutorer = new ArrayList<>();
    private static final ArrayList<Arrangement> arrangementer = new ArrayList<>();

    public static ArrayList<Uddannelse> getAlleUddannelser() {
        return new ArrayList<>(uddannelser);
    }

    public static void storeUddannelse(Uddannelse uddannelse) {
        uddannelser.add(uddannelse);
    }

    // TODO: Tutor og Arrangement

    public static ArrayList<Tutor> getAlleTutorer() {
        return new ArrayList<>(tutorer);
    }

    public static void storeTutor(Tutor tutor) {
        tutorer.add(tutor);
    }

    public static ArrayList<Arrangement> getAlleArrangementer() {
        return new ArrayList<>(arrangementer);
    }

    public static void storeArrangement(Arrangement arrangement) {
        arrangementer.add(arrangement);
    }
}
