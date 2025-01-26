package application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Medlem {
    private String navn;
    private String mobil;
    private String mail;

    private ArrayList<Reservation> reservationer   = new ArrayList<>();

    public Medlem(String navn, String mobil, String mail) {
        this.navn = navn;
        this.mobil = mobil;
        this.mail = mail;
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public String getMail() {
        return mail;
    }

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    public void addReservation(Reservation reservation) {
        if (!reservationer.contains(reservation)) {
            reservationer.add(reservation);
            reservation.setMedlem(this);
        }
    }

    public void removeReservation(Reservation reservation) {
        if (reservationer.contains(reservation)) {
            reservationer.remove(reservation);
            reservation.setMedlem(null);
        }
    }

    public Reservation createReservation(LocalDate dato, LocalTime startTid, Bane bane, Medlem makker) {
        Reservation reservation = new Reservation(dato, startTid, bane, this, makker);
        reservationer.add(reservation);
        makker.addReservation(reservation);
        return reservation;
    }

    // makker
    public ArrayList<Reservation> getReservationerMakker() {
        return new ArrayList<>(reservationer);
    }

    public void addReservationMakker(Reservation reservation) {
        if (!reservationer.contains(reservation)) {
            reservationer.add(reservation);
            reservation.setMedlem(this);
        }
    }

    public void removeReservationMakker(Reservation reservation) {
        if (reservationer.contains(reservation)) {
            reservationer.remove(reservation);
            reservation.setMedlem(null);
        }
    }

    // metoder


    //Opgave S6 (8 point)
    //Programmer en metode hasAktivReservation() på klassen Medlem.
    // Metoden skal returnere true såfremt der er en aktiv reservation for det pågældende medlem.
    // Et medlem har en aktiv reservation såfremt medlemmet enten har lavet en reservation
    // eller er makker på en reservation der endnu ikke er passeret.

    public boolean hasAktivReservation() {
        boolean harAktivReservation = false;
        for (Reservation r : reservationer) {
            if ((r.getDato().isAfter(LocalDate.now()) || (r.getDato().equals(LocalDate.now()) && (r.getStartTid().isAfter(LocalTime.now()))) && (r.getMedlem().equals(this) || r.getMakker().equals(this)))) {
                harAktivReservation = true;
            }
        }
        return harAktivReservation;
    }


}
