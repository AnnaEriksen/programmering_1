package application.model;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Locale;

public class Lektion {

    private LocalDate dato;
    private LocalTime startTid;
    private String lokale;
    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Lektion(LocalDate dato, LocalTime startTid, String lokale) {
        this.dato = dato;
        this.startTid = startTid;
        this.lokale = lokale;
        //fag.addLektion(this);
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getStartTid() {
        return startTid;
    }

    public String getLokale() {
        return lokale;
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return new ArrayList<>(deltagelser);
    }

    public Deltagelse createDeltagelse(boolean registreret, DeltagerStatus status, Lektion lektion, Studerende studerende){
        Deltagelse deltagelse = new Deltagelse(registreret, status, lektion, studerende);
        deltagelser.add(deltagelse);
        return deltagelse;

    }

    public void removeDeltagelse(Deltagelse deltagelse){
        if (deltagelser.contains(deltagelse)){
            deltagelser.remove(deltagelse);
        }

    }
}
