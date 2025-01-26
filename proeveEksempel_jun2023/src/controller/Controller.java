package controller;

import Storage.Storage;
import javafx.collections.ObservableList;
import model.Bane;
import model.Booking;
import model.Kategori;
import model.Spiller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static Storage.Storage.bookinger;

public class Controller {

    // TODO S6: opret() metoder til Spiller, Booking, Bane og Kategori

    public static Spiller createSpiller(String navn, String uddannelse){
        Spiller spiller = new Spiller(navn, uddannelse);
        Storage.addSpiller(spiller);
        return spiller;
    }

    public static Booking createBooking(LocalDate dato, LocalTime tid, boolean single, Spiller spiller, Bane bane) {
        Booking booking = new Booking(dato, tid, single, spiller, bane);
        Storage.addBooking(booking); // Tilføj booking til listen i Storage
        return booking;
    }


    public static Bane createBane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid, Kategori kategori){
        Bane bane = new Bane(nummer, inde, førsteTid, sidsteTid, kategori);
        Storage.addBane(bane);
        return bane;
    }

    public static Kategori createKategori(String navn, int prisKrSingle, int prisKrDouble){
        Kategori kategori = new Kategori(navn, prisKrSingle, prisKrDouble);
        Storage.addKategori(kategori);
        return kategori;
    }


    // S7 (8 p)
    public static int samletBooketDoubleTid(String uddannelse, Kategori kategori) {
        int samletTid = 0;

        // Hent alle spillere som ArrayList
        ArrayList<Spiller> spillere = new ArrayList<>(Storage.getSpillere());

        for (Spiller s : spillere) { //går gennem alle spillere baseret på uddannelse
            if (s.getUddannelse().equalsIgnoreCase(uddannelse)){
                // Gennemgå spillerens bookinger
                ArrayList<Booking> bookinger = new ArrayList<>(s.getBooking());
                for (Booking b : bookinger) {

                    // Tjek om det er double-spil og om banen matcher kategorien
                    if (!b.isSingle() && b.getBane().getKategori().equals(kategori)){
                        samletTid += 1; // Tilføj en time pr. double booking
                    }

                }
            }

        }
        return samletTid;
    }

    // S9 (5 p)
    public static Bane findLedigBane(LocalDate dato, LocalTime tid, Kategori kategori) {
        ArrayList<Bane> baner = new ArrayList<>(Storage.getBaner());

        Bane resultat = null; // vi initialiserer resultat til ikke-fundet
        int i = 0;
        while (resultat == null && i < baner.size()) { // iterer gennem listen af baner til vi har været gennem hele listen
            Bane b = baner.get(i); // henter kandidatelement fra listen barest på index, "i"
            if (b.getKategori().equals(kategori) && b.erLedig(dato, tid)){

            }
            i++; //hvis banen ik opfylder kriterierne, opdaterer vi index/i, ved at tælle 1 op
            //vi opdaterer kandidatmængden
        }
        return resultat;
    }

    // S10 (7 p)
    public static void udskrivBookings(String filnavn) {
        ArrayList<Booking> bookings = new ArrayList<>(Storage.getBookinger());


        File f = new File(filnavn);
        try (PrintWriter writer = new PrintWriter(f)) {

            for (Booking b : bookinger) { //iterer gennem liste af bookinger

                // Opretter en midlertidig String line til den formaterede booking
                String line = String.format("Bane: %d, Dato: %s, Spil: %s, Spiller: %s\n",
                        b.getBane().getNummer(), b.getDato(), b.isSingle() ? "Single" : "Double", b.getSpiller().getNavn());


                // Skriver hver linje til filen
                writer.write(line);
            }
            System.out.println("Bookinger er skrevet til " + filnavn);

        } catch (FileNotFoundException ex) {
            System.out.println("Fejj af skrivning til fil: " + ex.getMessage());
        }
    }




//    // streng lagdeling
//    public static ArrayList<Spiller> getAlleSpillere() {
//        return Storage.getAlleSpillere();
//    }
//
//    public static ArrayList<Bane> getAlleBaner() {
//        return Storage.getAlleBaner();
//    }


}
