package application.model;

import java.util.ArrayList;

public class Studerende {
    private String navn;
    private String email;

    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Studerende(String navn, String email) {
        this.navn = navn;
        this.email = email;
    }

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    //--


    public ArrayList<Deltagelse> getDeltagelser() {
        return new ArrayList<>(deltagelser);
    }

    public void addDeltagelse(Deltagelse deltagelse) {
        if (!deltagelser.contains(deltagelse)) {
            deltagelser.add(deltagelse);
            deltagelse.setStuderende(this);
        }
    }

    public void removeDeltagelse(Deltagelse deltagelse) {
        if (deltagelser.contains(deltagelse)) {
            deltagelser.remove(deltagelse);
            deltagelse.setStuderende(null);
        }
    }

    //--

    public int antalFraværsLektioner() {
        int antalLektioner = 0;

        for (Deltagelse d : getDeltagelser()) {
            if (d.erRegistreretFraværende()) {
                antalLektioner++;
            }
        }
        return antalLektioner;
    }

    @Override
    public String toString() {
        return navn;
    }
}
