package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Bane {
    private int nummer;
    private boolean inde;
    private LocalTime åbningstid;
    private LocalTime lukketid;

    // associering --> 0..* Booking
    private ArrayList<Booking> bookinger = new ArrayList<>();
    // TODO: get, add og remove metoder for linket til Booking

    // associering 0..* --> 1 Kategori
    private Kategori kategori;
    // TODO: get og set metoder for linket til Kategori


    // TODO: Tvunget forbindelse til Kategori
    public Bane(int nummer, boolean inde, LocalTime åbningstid, LocalTime lukketid, Kategori kategori) {
        this.nummer = nummer;
        this.inde = inde;
        this.åbningstid = åbningstid;
        this.lukketid = lukketid;
        this.kategori = kategori;
    }

    public ArrayList<Booking> getBookinger() {
        return new ArrayList<>(bookinger);
    }

    public Kategori getKategori() {
        return kategori;
    }

    public int getNummer() {
        return nummer;
    }

    public boolean isInde() {
        return inde;
    }

    public LocalTime getÅbningstid() {
        return åbningstid;
    }

    public LocalTime getLukketid() {
        return lukketid;
    }



    public void addBooking(Booking booking){
        if (!bookinger.contains(booking)){
            bookinger.add(booking);
            booking.setBane(this);
        }
    }

    public void removeBooking(Booking booking){
        if (bookinger.contains(booking)){
            bookinger.remove(booking);
            booking.setBane(null);
        }
    }

    // S2 (5 p)
    public int bookedeTimerPåDato(LocalDate dato) {
        int bookedeTimer = 0;

        for (Booking b : bookinger){
            if (b.getDato().equals(dato)){ //vi tjekker om den specifikke bookings dato matcher,
                // datoen vi har i parameteren
                bookedeTimer++;
            }
        }
        return bookedeTimer;
    }

    // S4 (8 p)
    public int[] antalBookningerPrTime(LocalDate dato) {
 //find ud af om du kan bruge antalBookinger.length
        int timer = (int) ChronoUnit.HOURS.between(åbningstid, lukketid);
        int[] antalBookinger = new int[timer];


        for (Booking b : bookinger) {
            if (b.getDato().equals(dato)){
                long index = ChronoUnit.HOURS.between(åbningstid, b.getTid());
                if (index >= 0 && index < timer){
                    antalBookinger[(int) index]++;
                }
            }
        }
        return antalBookinger;
    }

    //-----------------------

    // S8 (5 p)
    public boolean erLedig(LocalDate dato, LocalTime tid) {
        boolean tidLedig = true;
        for (Booking b : bookinger) { // vi skal iterer gennem alle vores bookinger der er tilknyttet en bane
            if (b.getDato().equals(dato) && b.getTid().equals(tid)){ //tjekker om der findes en booking med samme dato og tid
                tidLedig = false; // hvis der gør, er tiden ikke ledig

            }
            //kandidatmængden splittes ved at fortsætte til næste element

        }
        return tidLedig;
    }

    public String getNavn() {
        return "";
    }

//    @Override
//    public String toString() {
//        String str = inde ? "inde" : "ude";
//        return String.format(
//                "Nr. %s %s (%s -> %s), %s",
//                nummer, str, førsteTid, sidsteTid, kategori.getNavn()
//        );
//    }
}
