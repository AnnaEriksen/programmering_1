package application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Medlem {
    private String navn;
    private String mobil;
    private String mail;
    private final ArrayList<Reservation> reservationer = new ArrayList<>();

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public String getMail() {
        return mail;
    }

    public Medlem(String navn, String mobil, String mail) {
        this.navn = navn;
        this.mobil = mobil;
        this.mail = mail;
    }

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>();
    }

    public void addReservation(Reservation reservation){
        if (!reservationer.contains(reservation)){
            reservationer.add(reservation);
            reservation.setMedlem(this);
        }
    }

    public void removeReservation
            (Reservation reservation) {
        if (reservationer.contains(reservation)){
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

    //til makker
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


    //Opgave S6 (8 point)
    //Programmer en metode hasAktivReservation() på klassen Medlem.
    // Metoden skal returnere true såfremt der er en aktiv reservation for det pågældende medlem.
    // Et medlem har en aktiv reservation såfremt medlemmet enten har lavet en reservation
    // eller er makker på en reservation der endnu ikke er passeret.

    public boolean hasAktivReservation(){
        boolean isAktiv = false;

        //LocalDateTime.now(): giver os det aktuelle tidspunkt kombineret som dato og tid.
        //vi bruger den til at sammenligne reservationstiden med dato og tid
        LocalDateTime nuværendeTid = LocalDateTime.now();

        //iterer gennem liste af reservationer
        for (Reservation r : reservationer) {

            //kombinerer getDato og getStartTid for reservationen, da det et lettere at gøre det samlet end separat.
            LocalDateTime resTidspunkt = LocalDateTime.of(r.getDato(), r.getStartTid());

            if (resTidspunkt.isAfter(nuværendeTid)  //tjekker om resTidspunkt er efter det aktuelle tidspunkt

                    //tjekker om det aktuelle medlem er opretter eller makker
                    && (r.getMedlem().equals(this) || r.getMakker().equals(this))) {
            }
        }
        return isAktiv;
    }
}



