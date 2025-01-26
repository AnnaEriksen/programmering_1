package application.model;

import java.util.ArrayList;

public class Forhindring {
    private int nummer;
    private String navn;


    public Forhindring(int nummer, String navn) {
        this.nummer = nummer;
        this.navn = navn;
    }

    public int getNummer() {
        return nummer;
    }

    public String getNavn() {
        return navn;
    }


    //-------til løb----------------------------------------------------

    private final ArrayList<Løb> løbs = new ArrayList<>();


    public ArrayList<Løb> getLøb() {
        return new ArrayList<>(løbs);
    }

    public void addLøbs(Løb løb) {
        if (!løbs.contains(løb)) {
            løbs.add(løb);
            løb.addForhindring(this);
        }
    }
    /**
     * Removes the group from this person and the person from the group,
     * if they are connected
     */
    public void removeLøb(Løb løb) {
        if (løbs.contains(løb)) {
            løbs.remove(løb);
            løb.removeForhindring(this);
        }
    }

}

