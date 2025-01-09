package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private LocalDate dato;
    private LocalTime tid;
    private boolean single;



    // TODO: get metode for linket til Spiller
    // komposition 0..* --> 1 Spiller
    private Spiller spiller;

    // TODO: get og set metoder for linket til Bane
    // associering 0..* --- 1 Bane
    private Bane bane;
    // TODO

    // TODO: Tvunget forbindelse til Spiller og Bane
    public Booking(LocalDate dato, LocalTime tid, boolean single, Spiller spiller, Bane bane) { // OBS: package visible
        this.dato = dato;
        this.tid = tid;
        this.single = single;
        this.spiller = spiller;
        this.bane = bane;
        bane.addBooking(this);//opdaterer relationer

    }

    public void setBane(Bane bane){
        if (this.bane != bane){
            Bane oldBane = this.bane;
            if (oldBane != null){
                oldBane.addBooking(this);
            }
            this.bane = bane; //link booking -> bane
            if (bane != null){
                bane.addBooking(this); //link bane -> booking
            }
        }
    }

    public Bane getBane() {
        return bane;
    }

    public Spiller getSpiller() {
        return spiller;
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getTid() {
        return tid;
    }

    public boolean isSingle() {
        return single;
    }


    //TODO toString


    @Override
    public String toString() {
        return "Booking{" +
                "dato=" + dato +
                ", tid=" + tid +
                ", single=" + single +
                ", spiller=" + spiller +
                ", bane=" + bane +
                '}';
    }
}





