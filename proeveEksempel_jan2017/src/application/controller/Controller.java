package application.controller;

// Opgave S6
//Tilføj klassen Controller i en pakke controller. Klassen skal indeholde metoder til at oprette
//arrangementer, reservationer og pladser, samt til at skabe sammenhænge imellem disse.
//Tilføj derudover en metode initStorage()

import application.model.Arrangement;
import application.model.Område;
import application.model.Plads;
import application.model.Reservation;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller {

    public static Arrangement createArrangement(String navn, boolean offentlig) {
        Arrangement arrangement = new Arrangement(navn, offentlig);
        Storage.addArrangement(arrangement);
        return arrangement;
    }

    public static Reservation createReservation(LocalDateTime start, LocalDateTime slut) {
        Reservation reservation = new Reservation(start, slut);
        Storage.addReservation(reservation);
        return reservation;
    }

    public static Plads createPlads(int nr, Område område) {
        Plads plads = new Plads(nr, område);
        Storage.addPlads(plads);
        return plads;
    }

    //--

    public static ArrayList<Plads> getPladser() {
        return Storage.getPladser();
    }

    //--

    public static void initStorage() {
        Plads p1 = createPlads(1, Område.TURNERING);
        Plads p2 = createPlads(2, Område.TURNERING);
        Plads p3 = createPlads(3, Område.STANDARD);
        Plads p4 = createPlads(4, Område.STANDARD);
        Plads p5 = createPlads(5, Område.BØRNE);
        Plads p6 = createPlads(6, Område.VIP);

        Arrangement a1 = createArrangement("Dota 2 tournament", true);
        Arrangement a2 = createArrangement("CS GO tournament", false);

        //Her oprettes en ny reservation r1 ved hjælp af createReservation metoden. Reservationen starter den 12. august 2019 kl. 20:00 og slutter samme dag kl. 23:00.
        Reservation r1 = createReservation(LocalDateTime.of(2019, 8, 12, 20, 0), LocalDateTime.of(2019, 8, 12, 23, 0));

        //Her tilføjes to pladser p1 og p2 til reservationen r1 ved hjælp af addPlads metoden.
        r1.addPlads(p1);
        r1.addPlads(p2);
        a1.addReservation(r1);

        Reservation r2 = createReservation(LocalDateTime.of(2019, 8, 13, 19, 0), LocalDateTime.of(2019, 8, 14, 6, 0));
        r2.addPlads(p3);
        r2.addPlads(p4);

        Reservation r3 = createReservation(LocalDateTime.of(2019, 8, 14, 19, 0), LocalDateTime.of(2019, 8, 15, 6, 0));
        r3.addPlads(p6);

    }

}
