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


//    public void removeBooking(Booking booking){
//        if (bookinger.contains(bookinger)){
//            bookinger.remove(booking);
//        }
//
//    }

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
        for (Booking b : bookinger) { //vi går gennem alle bookinger i spillerens booking-liste
           if (b.getSpiller() == this && b.getBane().getKategori().equals(kategori)){
               samletPris += kategori.getPrisKrSingle();
           }else {
           samletPris += kategori.getPrisKrDouble();
        }

    }
        return samletPris;

    }

//    public double samletPris(Kategori kategori) {
//        double samletPris = 0;
//        for (int i = 0; i < bookinger.size(); i++) {
//            Booking booking = bookinger.get(i);
//            if (booking.getBane().getKategori().equals(kategori)) {
//                samletPris += booking.getPris();
//            }
//        }
//        return samletPris;
//    }


    @Override
    public String toString() {
        return "Spiller{" +
                "navn='" + navn + '\'' +
                ", uddannelse='" + uddannelse + '\'' +
                ", bookinger=" + bookinger +
                '}';
    }
}