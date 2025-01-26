package application.model;

import java.util.ArrayList;

public class Plads {
    private int nr;
    private Område område;
    private static int standardTimePris;

    private ArrayList<Reservation> reservationer = new ArrayList<>();

    public Plads(int nr, Område område) {
        this.nr = nr;
        this.område = område;
        standardTimePris = 50;
    }

    public int getNr() {
        return nr;
    }

    public Område getOmråde() {
        return område;
    }

    //--

    //TODO Opgave S3
    //Alle pladser har som udgangspunkt den samme standard time pris på 50 kr. Tilføj til klassen Plads
    //en klassevariabel (statisk attribut) standardTimePris, samt tilhørende get() og set()-metoder.

    public static int getStandardTimePris() {
        return standardTimePris;
    }

    public static void setStandardTimePris(int standardTimePris) {
        Plads.standardTimePris = standardTimePris;
    }
    //--

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    public void addReservation(Reservation reservation) {
        if (!reservationer.contains(reservation)) {
            reservationer.add(reservation);
            reservation.addPlads(this);
        }
    }

    public void removeReservation(Reservation reservation) {
        if (reservationer.contains(reservation)) {
            reservationer.remove(reservation);
            reservation.removePlads(this);
        }
    }

    //--

    //Opgave S4
    //Prisen for en Plads er afhængig af, hvor lang tid pladsen er reserveret.
    //Metoden skal returnere prisen for pladsen i det angivne antal timer. Prisen er afhængig af, hvilket
    //område pladsen er i. I VIP-området er timeprisen 25% dyrere end en standard time. I
    //børneområdet er der en rabat på 20% i forhold til en standard time. I tuneringsområdet er prisen
    //10% dyrere end en standard time.

    public double pris(int antalTimer) {
        double timePris = 0;

        //her tjekkes området ved hjælp af getOmråde();, prisen beregnes baseret på området og antallet af timer
        if (getOmråde().equals(Område.VIP)) {
            timePris = antalTimer * (standardTimePris + (standardTimePris * 0.25)); //standard gange 25%
        } else if (getOmråde().equals(Område.BØRNE)) {
            timePris = antalTimer * (standardTimePris - (standardTimePris * 0.2)); //standard gange 20%
        } else if (getOmråde().equals(Område.TURNERING)) {
            timePris = antalTimer * (standardTimePris + (standardTimePris * 0.1)); //standard gange 10%
        } else if (getOmråde().equals(Område.STANDARD)) {
            timePris = antalTimer * standardTimePris; //standard timepris gange antaltimer
        }

        return timePris;
    }

    //--


    @Override
    public String toString() {
        return "Plads " +
                nr +
                ", " + område;
    }
}


