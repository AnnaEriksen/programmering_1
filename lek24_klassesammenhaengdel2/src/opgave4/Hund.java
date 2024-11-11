package opgave4;

public class Hund {
    private String navn;
    private boolean stamtavle;
    private int pris;
    private Race race;


    public Hund(String navn, int pris, Race race, boolean stamtavle) {
        this.race = race;
        this.pris = pris;
        this.stamtavle = stamtavle;
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public boolean isStamtavle() {
        return stamtavle;
    }

    public int getPris() {
        return pris;
    }

    public Race getRace() {
        return race;
    }
}
