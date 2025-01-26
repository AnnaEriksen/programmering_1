package Storage;

import model.Bane;
import model.Booking;
import model.Kategori;
import model.Spiller;

import java.util.ArrayList;

public class Storage {
    // TODO: lister til Spiller, Bane og Kategori
    public static final ArrayList<Spiller> spillere = new ArrayList<>();
    public static final ArrayList<Bane> baner = new ArrayList<>();
    public static final ArrayList<Kategori> kategorier = new ArrayList<>();
    public static final ArrayList<Booking> bookinger = new ArrayList<>();

    // TODO: get() metoder til listerne

    public static ArrayList<Spiller> getSpillere() {
        return new ArrayList<>(spillere);
    }

    public static ArrayList<Bane> getBaner() {
        return new ArrayList<>(baner);
    }

    public static ArrayList<Kategori> getKategorier() {
        return new ArrayList<>(kategorier);

    }

    public static ArrayList<Booking> getBookinger() {
        return new ArrayList<>(bookinger); // Returnér en kopi af listen
    }

    // TODO: store() (gem) metoder
    public static void addSpiller(Spiller spiller){
        spillere.add(spiller);
    }

    public static void addBane(Bane bane){
        baner.add(bane);
    }

    public static void addKategori(Kategori kategori){
        kategorier.add(kategori);
    }

    public static void addBooking(Booking booking) {
        bookinger.add(booking);
    }

//TODO ved ikke om jeg må have dem, men det er den eneste måde jeg kan få dettil at fungere
    public static ArrayList<Booking> getBookingerByBane(Bane bane) {
        ArrayList<Booking> result = new ArrayList<>();
        for (Booking b : bookinger) {
            if (b.getBane().equals(bane)) {
                result.add(b);
            }
        }
        return result;
    }

    public static ArrayList<Booking> getBookingerBySpiller(Spiller spiller) {
        ArrayList<Booking> spillerBookinger = new ArrayList<>();
        for (Booking booking : bookinger) { // 'bookinger' skal være en liste over alle booking-objekter
            if (booking.getSpiller().equals(spiller)) {
                spillerBookinger.add(booking);
            }
        }
        return spillerBookinger;
    }

}




