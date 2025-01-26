package application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Bane {
    private int nummer;
    private String baneInfo;

    private ArrayList<Reservation> reservationer = new ArrayList<>();

    public Bane(int nummer, String baneInfo) {
        this.nummer = nummer;
        this.baneInfo = baneInfo;
    }

    public int getNummer() {
        return nummer;
    }

    public String getBaneInfo() {
        return baneInfo;
    }

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

//    public void addReservation(Reservation reservation) {
//        if (!reservationer.contains(reservation)) {
//            reservationer.add(reservation);
//            reservation.setBane(this);
//        }
//    }

    public void removeReservation(Reservation reservation) {
        if (reservationer.contains(reservation)) {
            reservationer.remove(reservation);
            reservation.setBane(null);
        }
    }

    // metoder

    // Opgave S2 (8 point)
    //Programmer en metode isLedig(LocalDate dato, LocalTime tid) på klassen Bane. Metoden skal returnere true såfremt der ikke er en reservation af banen på det i parameteren angivne tidspunkt.
    //Bemærk: Det er et krav, at metoden bruger lineær søgning (fra afsnittet i noten om Søgning).
    public boolean isLedig(LocalDate dato, LocalTime tid) {
        boolean baneErLedig = true;
        int i = 0;
        while (baneErLedig && i < getReservationer().size()) {
            Reservation k = getReservationer().get(i);
            if (k.getDato().equals(dato) && k.getStartTid().equals(tid)) {
                baneErLedig = false;
            } else {
                i++;
            }
        }
        return baneErLedig;
    }


    // Opgave S3 (8 point)
    //Idet det er muligt at reservere en bane med starttid fra kl 6.00 om morgenen til kl 22.00 om aftenen,
    // ønskes til klassen Bane tilføjet en metode der givet en dato,
    // returnerer en liste af starttidspunkter der er ledige på den pågældende dag.
    //public ArrayList<LocalTime> getLedigeTiderPaaDag(LocalDate dato)

    public ArrayList<LocalTime> getLedigeTiderPaaDag(LocalDate dato) {
        ArrayList<LocalTime> ledigeTiderPaaDag = new ArrayList<>();

        for (int i = 6; i <= 22; i++) {
            LocalTime l = LocalTime.of(i, 0);
            if (isLedig(dato, l)) {
                ledigeTiderPaaDag.add(l);
            }
        }

        return ledigeTiderPaaDag;
    }

    //Opgave S9 (10 point)
    //Fra opgave S1 har klassen Bane en link-metode addReservation(Reservation reservation)
    // der tilføjer en reservation til banens liste af reservationer.
    // Udkommentér denne metode og programmér en ny metode med samme signatur og funktionalitet.
    // I den nye implementation af metoden skal der sørges for, at link-attributten der indeholder reservationer,
    // altid er sorteret i henhold til reservationernes ordning.
    //Bemærk: Det er ikke tilladt at sortere hele listen ved hver indsættelse.

    public void addReservation(Reservation reservation) {
        if (!reservationer.contains(reservation)) {

            boolean found = false;
            int i = 0;

            while (!found && i < reservationer.size()) {
                if (reservation.getDato().isBefore(reservationer.get(i).getDato())) {
                    found = true;
                } else if (reservation.getDato().equals(reservationer.get(i).getDato()) && reservation.getStartTid().isBefore(reservationer.get(i).getStartTid())) {
                    found = true;
                } else if ((reservation.getDato().equals(reservationer.get(i).getDato()) && reservation.getStartTid().equals(reservationer.get(i).getStartTid())) && reservation.getBane().getNummer() < reservationer.get(i).getBane().getNummer()) {
                    found = true;
                } else {
                    i++;
                }
            }
            reservationer.add(i, reservation);
            reservation.setBane(this);

        }
    }

    @Override
    public String toString() {
        return nummer + "\nInfo: " + baneInfo;
    }
}
