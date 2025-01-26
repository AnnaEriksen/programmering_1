package application.model;

import java.util.ArrayList;

public class Studerende {
    private String navn;
    private String email;
    private ArrayList<Deltagelse> deltagelser = new ArrayList<>(); //link til deltagerklasse

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


    public void removeDeltagelse(Deltagelse deltagelse) {
        if (deltagelser.contains(deltagelse)){
            deltagelser.remove(deltagelse);
            deltagelse.setStuderende(this);
        }

    }

    public void addDeltagelse(Deltagelse deltagelse) {
        if (!deltagelser.contains(deltagelse)){
            deltagelser.add(deltagelse);
            deltagelse.setStuderende(this);
        }

    }


    //S3

    public static int antalFraværsLektioner(){
        int antalFravær = 0;

        return antalFravær;
    }
}
