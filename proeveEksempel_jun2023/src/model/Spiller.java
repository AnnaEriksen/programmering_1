package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Spiller {
    private String navn;
    private String uddannelse;


    // TODO: get og create metoder for linket til Booking
    // komposition 1 --> 0..* Booking
    private final ArrayList<Booking> bookinger = new ArrayList<>();
    // TODO


    public ArrayList<Booking> getBooking() {
        return new ArrayList<>(bookinger);
    }

    public Booking createBooking(LocalDate dato, LocalTime tid, boolean single, Bane bane){
        Booking booking = new Booking(dato, tid, single, this, bane);
        bookinger.add(booking);
        return booking;
    }


    public Spiller(String navn, String uddannelse) {
        this.navn = navn;
        this.uddannelse = uddannelse;

    }

    public String getNavn() {
        return navn;
    }

    public String getUddannelse() {
        return uddannelse;
    }

    //-------------------------------------------------

    // S3 (7 p)
    public int samletPris(Kategori kategori) {
        int samletPris = 0;
        for (Booking b : bookinger) {
            if (b.getBane().getKategori().equals(kategori)) {
                if (b.isSingle()) {
                    samletPris += kategori.getPrisKrSingle();
                } else {
                    samletPris += kategori.getPrisKrDouble();
                }
            }
        }
        return samletPris;
    }




    @Override
    public String toString() {
        return "Spiller: " +
                "navn='" + navn + '\'' +
                ", uddannelse: '" + uddannelse + '\'' +
                ", bookinger: " + bookinger;
    }
}