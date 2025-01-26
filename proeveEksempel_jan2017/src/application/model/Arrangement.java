package application.model;

import java.util.ArrayList;

public class Arrangement {
    private String navn;
    private boolean offentlig;

    private ArrayList<Reservation> reservationer = new ArrayList<>();

    public Arrangement(String navn, boolean offentlig) {
        this.navn = navn;
        this.offentlig = offentlig;
    }

    public String getNavn() {
        return navn;
    }

    public boolean isOffentlig() {
        return offentlig;
    }

    //--

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    public void addReservation(Reservation reservation) {
        if (!reservationer.contains(reservation)) {
            reservationer.add(reservation);
        }
    }

    public void removeReservation(Reservation reservation) {
        if (reservationer.contains(reservation)) {
            reservationer.remove(reservation);
        }
    }


    //--

    // Opgave S2
    //Programmér metoden antalReserveredePladser() på Arrangement. Metoden skal returnere
    //antallet af pladser, der er tilknyttet det pågældende arrangement.

    public int antalReserveredePladser() {
        int antal = 0;

        //Dette loop gennemgår alle reservationer, der returneres af metoden getReservationer().
        for (Reservation r : getReservationer()) { //
            antal += r.getPladser().size(); //for hver resrevation r,
            // hentes listen af pladser ved hjælp af r.getPladser();
        }
        return antal;
    }


}


