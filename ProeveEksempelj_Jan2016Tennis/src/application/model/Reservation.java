package application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Reservation {
    private LocalDate dato;
    private LocalTime startTid;

    private Bane bane; //link til bane
    private Medlem medlem;
    private Medlem makker;

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getStartTid() {
        return startTid;
    }

    public Reservation(LocalDate dato, LocalTime startTid, Bane bane, Medlem medlem, Medlem makker) {
        this.dato = dato;
        this.startTid = startTid;
        this.bane = bane;
        setBane(bane);
        setMedlem(medlem);
        setMedlem(makker);

    }

    public Bane getBane() {
        return bane;
    }

    public void setBane(Bane bane){
        if (this.bane != bane){
            Bane oldBane = this.bane;
            if (oldBane != null){
                oldBane.removeReservation(this);
            }
            this.bane = bane; //lin til reservation -> bane
            if (bane != null){
                bane.addReservation(this); //link til Bane -> reservation
            }
        }
    }

    public Medlem getMedlem() {
        return medlem;
    }

    public void setMedlem(Medlem medlem){
        if (this.medlem != medlem){
            Medlem oldMedlem = this.medlem;
            if (oldMedlem != null){
                oldMedlem.removeReservation(this);
            }
            this.medlem = medlem;
            if (medlem != null){
                medlem.addReservation(this);
            }
        }

    }

    //til makker
    public Medlem getMakker() {
        return makker;
    }

    public void setMakker(Medlem makker) {
        if (this.makker != makker) {
            Medlem oldMakker = this.makker;
            if (oldMakker != null) {
                oldMakker.removeReservation(this);
            }
            this.makker = makker;
            if (makker != null) {
                makker.addReservation(this);
            }
        }
    }

    // opgave S8 (5 point)
    //Lad klassen Reservation implementere Comparable interfacet.
    // Ordningen på reservationer er defineret i stigende orden ved primært datoen for reservationen,
    // sekundært tidspunktet for reservationen. Hvis to reservationer har præcis samme dato og klokkeslæt,
    // er det banens nummer der afgør hvilken reservation der kommer før en anden.
    // Den reservation med lavest banenummer, kommer først i ordningen


    public void sortereReservationer(ArrayList<Reservation> reservationer) {
        for (int i = 1; i < reservationer.size(); i++) { // starter i = 1, da i = 0 betragtes sorteret
            Reservation next = reservationer.get(i); // gemmer det element vi kigger på i øjeblikket
            int j = i; // den position hvor next skal indsættes
            boolean found = false; // til at stoppe while, når den rigtige position er fundet

            while (!found && j > 0) { // så længe !found og har flere elementer tilbage at tjekke j > 0 dvs., når hen til starten af listen
                // primær. Dvs samligning af datoer
                if (next.getDato().isBefore(reservationer.get(j - 1).getDato())) {
                    found = true; // så er den på den rigtige position og løkken stoppes ved found = true
                    // sekundær. Samligning af tid
                } else if (next.getDato().equals(reservationer.get(j - 1).getDato()) && next.getStartTid().isBefore(reservationer.get(j - 1).getStartTid())) {
                    found = true;
                }
                // hvis samme dato og tidspunkt, så sammenlignes banenr
                else if (next.getDato().equals(reservationer.get(j-1).getDato()) && next.getStartTid().equals(reservationer.get(j-1).getStartTid())
                        && next.getBane().getNummer() < reservationer.get(j - 1).getBane().getNummer()) {
                    found = true;
                } else {
                    reservationer.set(j, reservationer.get(j - 1));  // j-1 sættes på j's plads
                    j--;  // går en position tilbage for at sammenligne næste element
                }
            }
            reservationer.set(j, next); // når den rigtige position findes (eller løkken stopper), sættes next på j's position
        }
    }




}
