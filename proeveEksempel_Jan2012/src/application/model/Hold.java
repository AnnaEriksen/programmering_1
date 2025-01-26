package application.model;

import java.util.ArrayList;

public class Hold {
    private String navn;
    private String disciplin;
    private int maxAntal;

    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Hold(String navn, String disciplin, int maxAntal) {
        this.navn = navn;
        this.disciplin = disciplin;
        this.maxAntal = maxAntal;
    }

    public String getNavn() {
        return navn;
    }

    public String getDisciplin() {
        return disciplin;
    }

    public int getMaxAntal() {
        return maxAntal;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setDisciplin(String disciplin) {
        this.disciplin = disciplin;
    }

    public void setMaxAntal(int maxAntal) {
        this.maxAntal = maxAntal;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public Tilmelding createTilmelding(boolean aktiv, boolean VIPmedlem, Medlem medlem) {
        Tilmelding tilmelding = new Tilmelding(aktiv, VIPmedlem, medlem, this);
        tilmeldinger.add(tilmelding);
        return tilmelding;
    }

    public void addTilmelding(Tilmelding tilmelding) {
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
        }
    }

    public void removeTilmelding(Tilmelding tilmelding) {
        if (tilmeldinger.contains(tilmelding)) {
            tilmeldinger.remove(tilmelding);
        }
    }

    //

    // S2 (7 points)
    // beregner hvor mange tilmeldinger der er kommet fra medlemmer med en bestemt adresse.
    public int getAntalTilmeldinger(String adresse) {
        int antal = 0;
        for (Tilmelding t : getTilmeldinger()) {
            if (adresse.equalsIgnoreCase(t.getMedlem().getAdresse())) {
                antal++;
            }
        }
        return antal;

    }

    // S3 (8 points)
    //finder et medlem, som er VIPmedlem på holdet.
    // Metoden returnerer navnet på det medlem, som er VIPmedlem.
    // Hvis et VIPmedlem ikke findes returneres null.
    // Det er et krav, at metoden anvender en lineær søgning, baseret på søgeskabelonen.

    public String findVipMedlem() {
        String vipMedlem = null;

        int i = 0;
        while (vipMedlem == null && i < getTilmeldinger().size()) {
            Tilmelding k = getTilmeldinger().get(i);
            if (k.isVIPmedlem()) {
                vipMedlem = k.getMedlem().getNavn();

            } else {
                i++;
            }
        }
        return vipMedlem;

    }

    public String toString() {
        return navn + " " + disciplin + ", max antal " + maxAntal;
    }

}
