package application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Lektion {
    private LocalDate dato;
    private LocalTime startTid;
    private String lokale;

    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Lektion(LocalDate dato, LocalTime startTid, String lokale, Fag fag) {
        this.dato = dato;
        this.startTid = startTid;
        this.lokale = lokale;
        fag.addLektion(this);
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


    //--


    public ArrayList<Deltagelse> getDeltagelser() {
        return new ArrayList<>(deltagelser);
    }

    public Deltagelse createDeltagelse(Studerende studerende) {
        Deltagelse deltagelse = new Deltagelse( this, studerende);
        deltagelser.add(deltagelse);
        return deltagelse;
    }

    public void removeDeltagelse(Deltagelse deltagelse) {
        if (deltagelser.contains(deltagelse)) {
            deltagelser.remove(deltagelse);
        }
    }


    @Override
    public String toString() {
        return dato + " " + startTid + " " + lokale;
    }
}
