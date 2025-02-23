package application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reservation {
    private LocalDateTime start;
    private LocalDateTime slut;

    private ArrayList<Plads> pladser = new ArrayList<>();

    public Reservation(LocalDateTime start, LocalDateTime slut) {
        this.start = start;
        this.slut = slut;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getSlut() {
        return slut;
    }

    //--

    public ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }


    public void addPlads(Plads plads) {
        if (!pladser.contains(plads)) {
            pladser.add(plads);
            plads.addReservation(this);
        }
    }

    public void removePlads(Plads plads) {
        if (pladser.contains(plads)) ;
        plads.removeReservation(this);
    }
}

