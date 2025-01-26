package application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bane {
    private int nummer;
    private String baneInfo;

    private ArrayList<Reservation> reservationer = new ArrayList<>();

    public Bane(int nummer, String baneInfo) {
        this.nummer = nummer;
        this.baneInfo = baneInfo;
    }

    public int getNummer() {
        return nummer;
    }

    public String getBaneInfo() {
        return baneInfo;
    }

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

//    public void addReservation(Reservation reservation) {
//        if (!reservationer.contains(reservation)) {
//            reservationer.add(reservation);
//            reservation.setBane(this);
//        }
//    }


    //Opgave S9 (10 point)
    //Fra opgave S1 har klassen Bane en link-metode addReservation(Reservation reservation)
    //der tilføjer en reservation til banens liste af reservationer. Udkommentér denne metode og
    //programmér en ny metode med samme signatur og funktionalitet. I den nye implementation af
    //metoden skal der sørges for, at link-attributten der indeholder reservationer, altid er sorteret i
    //metoden skal der sørges for, at link-attributten der indeholder reservationer, altid er sorteret i

    //Bemærk: Det er ikke tilladt at sortere hele listen ved hver indsættelse.


    public void addReservation(Reservation reservation) {
        // Tjek om reservationen allerede findes i listen
        if (reservationer.contains(reservation)) {
            return;
        }

        // Find den korrekte position at indsætte reservationen
        int i = 0;
        while (i < reservationer.size()) {
            Reservation current = reservationer.get(i);
            // Primær sammenligning på dato
            if (reservation.getDato().isBefore(current.getDato())) {
                break;
            }
            // Sekundær sammenligning på starttid, hvis datoerne er ens
            if (reservation.getDato().equals(current.getDato())) {
                if (reservation.getStartTid().isBefore(current.getStartTid())) {
                    break;
                }
                // Tertiær sammenligning på banenumre, hvis dato og tid er ens
                if (reservation.getStartTid().equals(current.getStartTid()) &&
                        reservation.getBane().getNummer() < current.getBane().getNummer()) {
                    break;
                }
            }
            i++;
        }

        // Indsæt reservationen på den korrekte position
        reservationer.add(i, reservation);
        reservation.setBane(this);
    }


    public void removeReservation(Reservation reservation) {
        if (reservationer.contains(reservation)) {
            reservationer.remove(reservation);
            reservation.setBane(null);
        }
    }

    // metoder

    // Opgave S2 (8 point)
    //Programmer en metode isLedig(LocalDate dato, LocalTime tid) på klassen Bane.
    // Metoden skal returnere true såfremt der ikke er en reservation af banen på det i parameteren angivne tidspunkt.
    //Bemærk: Det er et krav, at metoden bruger lineær søgning (fra afsnittet i noten om Søgning).

    public boolean isLedig(LocalDate dato, LocalTime tid) {
        boolean erLedig = true;
        int i = 0;
        while (erLedig && i < reservationer.size()){
            Reservation r = reservationer.get(i); // henter res for at tjekke tid og dato
            if (r.getDato().equals(dato) && r.getStartTid().equals(tid)){ //vi tjekker om dato og tid matcher ønskede dato
                erLedig = false; //hvis den gør, betyder det er banen ikke er ledig på det ønskede tidspunkt
            }
            i++; //vi tæller op udenfor if-sætningen, da vi gerne vil hele listen igennem,
            //uanset om udsagnet er sandt eller falsk. Hvis i++, var i sætningen, ville vi kun komme videre, hvis betingelsen var false, og skabe en uendelig løkke
        }
        return erLedig;
    }


    //Opgave S3 (8 point)
    //Idet det er muligt at reservere en bane med starttid fra kl 6.00 om morgenen til kl 22.00 om aftenen,
    // ønskes til klassen Bane tilføjet en metode der givet en dato,
    // returnerer en liste af starttidspunkter der er ledige på den pågældende dag.

    public ArrayList<LocalTime> getLedigeTiderPaaDag(LocalDate dato){
        ArrayList<LocalTime> ledigeTiderPaaDag = new ArrayList<>();

        //kører gennem klokkeslæt fra 06:00 til 22:00
        for (int i = 6; i <= 22; i++){

            // opretter localTime objekt, t, der repræsenterer det aktuelle tidspunk
            LocalTime t = LocalTime.of(i, 0);
            if (isLedig(dato, t)){ //tjekker om banen er ledig på den angivne dat0

                //tilføjes til liste hvis bane er ledig på angivne dato
                ledigeTiderPaaDag.add(t);
            }
        }

        //returnerer vores liste af ledige baner
        return ledigeTiderPaaDag;
    }




    @Override
    public String toString() {
        return nummer + "\nInfo: " + baneInfo;
    }
}
