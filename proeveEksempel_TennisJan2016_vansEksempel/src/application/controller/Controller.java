package application.controller;

import application.model.Bane;
import application.model.Medlem;
import application.model.Reservation;
import storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    public static Bane createBane(int nummer, String baneInfo) {
        Bane bane = new Bane(nummer, baneInfo);
        Storage.addBane(bane);
        return bane;
    }

    public static Medlem createMedlem(String navn, String mobil, String mail) {
        Medlem medlem = new Medlem(navn, mobil, mail);
        Storage.addMedlem(medlem);
        return medlem;
    }

    public static ArrayList<Bane> getBaner() {
        return Storage.getBaner();
    }


    public static void initStorage() {
        Medlem m1 = createMedlem("Lene Mikkelsen", "12345678", "lm@msn.com");
        Medlem m2 = createMedlem("Finn Jensen", "22331144", "fj@msn.com");

        Bane b1 = createBane(1, "Nord/syd vendt");
        Bane b2 = createBane(2, "Under Egetræet");
        Bane b3 = createBane(3, "Med tilskuerpladser");

        // test
        Reservation r1 = m1.createReservation(LocalDate.of(2022,12,12),LocalTime.of(8,0),b1,m2);
        b1.addReservation(r1);
    }


    //Opgave S7 (7 point)
    //Systemet skal også kunne oprette og returnerer en reservation.
    // Tilføj til klassen Service nedenstående metode der skal oprette en reservation,
    // såfremt det er muligt. Det vil sige såfremt banen er ledig og såvel ham der booker banen,
    // som makkeren han skal spille med, ikke har aktive bookinger registreret.
    // Hvis det ikke er muligt at booke, skal reservationen ikke oprettes, og metoden returnerer null.

    public static Reservation createReservation(Medlem booker, Medlem makker, Bane bane, LocalDate dato, LocalTime startTid) {
        Reservation reservation = null;
        if (bane.isLedig(dato, startTid) && !booker.hasAktivReservation() && !makker.hasAktivReservation()) {
            reservation = booker.createReservation(dato,startTid,bane, makker);
        }

        return reservation;
    }



    // Opgave S10 (7 point)
    //Tilføj en metode til Service-klassen, der til en tekstfil for alle baner udskriver tidspunkterne for hvornår banerne er ledige på den pågældende dato.
    //Metoden skal have følgende signatur:

    public static void writeLedigeTider(LocalDate dato, String filnavn) {
        try {
            PrintWriter printWriter = new PrintWriter(filnavn);
            for (Bane b : Storage.getBaner()) {
                for (LocalTime l : b.getLedigeTiderPaaDag(dato)) {
                    printWriter.println(b + "\nLedige tidspunkter:\n" + l);
                }
            }

            printWriter.close();



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }









}
