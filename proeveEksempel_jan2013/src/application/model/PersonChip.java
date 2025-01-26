package application.model;

import java.util.ArrayList;

public class PersonChip {
    private int nr;
    private String navn;
    private int maxSaldo;
    private int alder;

    private ArrayList<Facilitet> faciliteter = new ArrayList<>();

    public PersonChip(int nr, String navn, int maxSaldo, int alder, Gruppe gruppe) {
        this.nr = nr;
        this.navn = navn;
        this.maxSaldo = maxSaldo;
        this.alder = alder;
        gruppe.addPersonChip(this);
    }

    // set
    public void setNr(int nr) {
        this.nr = nr;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setMaxSaldo(int maxSaldo) {
        this.maxSaldo = maxSaldo;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    // get


    public int getNr() {
        return nr;
    }

    public String getNavn() {
        return navn;
    }

    public int getMaxSaldo() {
        return maxSaldo;
    }

    public int getAlder() {
        return alder;
    }

    public ArrayList<Facilitet> getFaciliteter() {
        return new ArrayList<>(faciliteter);
    }

    //
    public void addFacilitet(Facilitet facilitet) {
        if (!faciliteter.contains(facilitet)) {
            faciliteter.add(facilitet);
            facilitet.addPersonChip(this);
        }
    }

    public void removeFacilitet(Facilitet facilitet) {
        if (faciliteter.contains(facilitet)) {
            faciliteter.remove(facilitet);
            facilitet.removePersonChip(this);
        }
    }

    //

    // Opgave S2 (10 point)
    // returnerer et svar på om personen har penge til at bruge en ny facilitet.
    // Metoden skal finde den samlede pris for personens brugte faciliteter og
    // checke om der i forhold til maxSaldo er penge til at bruge en facilitet mere.
    // Er der penge nok returneres true, hvis ikke returneres false.
    public boolean checkSaldo(int prisFacilitet) {
        boolean harNokPenge = false;
        int samletForbrug = 0;
        for (Facilitet f : getFaciliteter()) {
            samletForbrug += f.getPris();
        }

        if ((maxSaldo-samletForbrug) >= prisFacilitet) {
            harNokPenge = true;
        }

        return harNokPenge;
    }

    @Override
    public String toString() {
        return "Nr. " + nr + " " + navn + " Alder: " + alder + " MaxSaldo: " + maxSaldo;
    }
}
