package storage;

import application.model.LøbeGruppe;
import application.model.Medlem;

import java.util.ArrayList;

public class storage {
    private static ArrayList<LøbeGruppe> løbeGrupper = new ArrayList<>();
    private static ArrayList<Medlem> medlemmer = new ArrayList<>();

    public static void addLøbegrupper(LøbeGruppe løbeGruppe) {
        if (løbeGruppe != null && !løbeGrupper.contains(løbeGruppe)) {
            løbeGrupper.add(løbeGruppe);
        }
    }

    public static void addMedlemmer(Medlem medlem) {
        if (medlem != null && !medlemmer.contains(medlem)) {
            medlemmer.add(medlem);
        }
    }

    public static ArrayList<LøbeGruppe> getLøbeGrupper() {
        return new ArrayList<>(løbeGrupper);
    }

    public static ArrayList<Medlem> getMedlemmer() {
        return new ArrayList<>(medlemmer);
    }
}
