package storage;

// Opgave S5
//Tilføj klassen Storage i en pakke storage. Klassen skal indeholde tre lister med systemets
//arrangementer, reservationer og pladser. Programmér klassen Storage med de tilhørende
//metoder til at tilføje objekter af klasserne Arrangement, Reservation og Plads til listerne.
//Programmér også metoder til at hente listerne.
//Bemærk: Du behøver ikke at lave metoder til at slette objekterne fra Storage.

import application.model.Arrangement;
import application.model.Plads;
import application.model.Reservation;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Storage {
    private static ArrayList<Reservation> reservationer = new ArrayList<>();
    private static ArrayList<Arrangement> arrangementer = new ArrayList<>();
    private static ArrayList<Plads> pladser = new ArrayList<>();

    //--

    public static ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    public static void addReservation(Reservation reservation) {
        reservationer.add(reservation);
    }

    public static ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<>(arrangementer);
    }

    public static void addArrangement(Arrangement arrangement) {
        arrangementer.add(arrangement);
    }

    public static ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    public static void addPlads(Plads plads) {
        pladser.add(plads);
    }

    //--

}
