package application.model;

import java.util.ArrayList;

public class Facilitet {
    private String navn;
    private int minimumsalder;
    private String åbningstid;
    private int pris;

    private ArrayList<PersonChip> personchips = new ArrayList<>();

    public Facilitet(String navn, int minimumsalder, String åbningstid, int pris) {
        this.navn = navn;
        this.minimumsalder = minimumsalder;
        this.åbningstid = åbningstid;
        this.pris = pris;
    }

    // set
    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setMinimumsalder(int minimumsalder) {
        this.minimumsalder = minimumsalder;
    }

    public void setÅbningstid(String åbningstid) {
        this.åbningstid = åbningstid;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    // get

    public String getNavn() {
        return navn;
    }

    public int getMinimumsalder() {
        return minimumsalder;
    }

    public String getÅbningstid() {
        return åbningstid;
    }

    public int getPris() {
        return pris;
    }


    public ArrayList<PersonChip> getPersonchips() {
        return new ArrayList<>(personchips);
    }

    //

    public void addPersonChip(PersonChip personChip) {
        if (!personchips.contains(personChip)) {
            personchips.add(personChip);
            personChip.addFacilitet(this);
        }
    }

    public void removePersonChip(PersonChip personChip) {
        if (personchips.contains(personChip)) {
            personchips.remove(personChip);
            personChip.removeFacilitet(this);
        }
    }


    @Override
    public String toString() {
        return navn + " Pris " + pris;
    }
}



