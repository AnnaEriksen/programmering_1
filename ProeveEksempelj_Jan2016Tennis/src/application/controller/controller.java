package application.controller;
import application.model.Reservation;
import storage.storage;
import application.model.Bane;
import application.model.Medlem;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class controller {
    //Opgave S5 (4 point)
    //Tilføj klassen Service.
    // Klassen skal indeholde metoder til at oprette baner og medlemmer.
    //Tilføj derudover en metode initStorage, der opretter og gemmer data svarende til nedenstående:

    public static Bane createBane(int nummer, String baneInfo) {
        Bane bane = new Bane(nummer, baneInfo);
        storage.addBane(bane);
        return bane;
    }

    public static Medlem createMedlem(String navn, String mobil, String mail) {
        Medlem medlem = new Medlem(navn, mobil, mail);
        storage.addMedlem(medlem);
        return medlem;
    }

    public static ArrayList<Bane> getBaner() {
        return storage.getBaner();
    }

    public static void initStorage() {
        Medlem m1 = createMedlem("Lene Mikkelsen", "12345678", "lm@msn.com");
        Medlem m2 = createMedlem("Finn", "22331144", "fj@nsm");


        Bane b1 = createBane(1, "Nord/sydvendt");
        Bane b2 = createBane(2, "Under egetræet");
        Bane b3 = createBane(1, "Med tilskuerpladser");

        // test
        Reservation r1 = m1.createReservation(LocalDate.of(2022,12,12), LocalTime.of(8,0),b1,m2);
        b1.addReservation(r1);


    }



   // Opgave S7 (7 point)
    // Systemet skal også kunne oprette og returnerer en reservation.
    // Tilføj til klassen Service nedenstående metode der skal oprette en reservation, såfremt det er muligt.
    // Det vil sige såfremt banen er ledig og såvel ham der booker banen,
    // som makkeren han skal spille med, ikke har aktive bookinger registreret.
    // Hvis det ikke er muligt at booke, skal reservationen ikke oprettes, og metoden returnerer null.

    public static Reservation createReservation(Medlem booker, Medlem makker, Bane bane, LocalDate dato, LocalTime startTid){

        Reservation res = null;

        //vi tjekker om banen er ledig på ønskedde tidspunkt,
        // om bookeren har en aktiv reservation,
        // og om makkeren ikke har en aktiv reservation
        if (bane.isLedig(dato, startTid) && !booker.hasAktivReservation() && !makker.hasAktivReservation()) {

            //hvis alle betingelser er opfylst, creater vi en booking
            res = booker.createReservation(dato, startTid, bane, makker);


        }

        return res;
    }


    //Opgave S10 (7 point)
    //Tilføj en metode til Service-klassen, der til en tekstfil for alle baner udskriver tidspunkterne for
    //hvornår banerne er ledige på den pågældende dato.
    //Metoden skal have følgende signatur:
    //public static void writeLedigeTider(LocalDate dato, String filnavn)


    public static void writeLedigeTider(LocalDate dato, String filnavn) {
        // Brug try-with-resources for at sikre korrekt lukning af PrintWriter
        try (PrintWriter printWriter = new PrintWriter(filnavn)) {
            for (Bane b : storage.getBaner()) {
                printWriter.println("Bane: " + b.getNummer()); // Antag at Bane har en getNummer metode
                printWriter.println("Ledige tidspunkter:");
                for (LocalTime l : b.getLedigeTiderPaaDag(dato)) {
                    printWriter.println(" - " + l);
                }
                printWriter.println(); // Tilføj en tom linje mellem baner for bedre læsbarhed
            }
        } catch (FileNotFoundException e) {
            // Log fejlen eller vis en informativ besked
            System.err.println("Fejl ved åbning af filen: " + filnavn);
            e.printStackTrace();
            // Overvej at kaste en ny undtagelse eller håndtere fejlen på en passende måde
        }
    }


}
