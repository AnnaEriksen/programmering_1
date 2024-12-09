package Application.Model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;

public class Tildmelding {

    private boolean fordragsholder;
    private LocalDate afrejseDato;
    private LocalDate ankomstDato;
    private Konference konference;
    private Hotel hotel;
    private Deltager deltager;
    private final ArrayList<Tilæg> tilægsListe = new ArrayList<>();
    private final ArrayList<Udflugt> udflugter = new ArrayList<>();
    private Ledsager ledsager;

    Tildmelding(boolean fordragsholder, LocalDate afrejseDato, LocalDate ankomstDato,
                Konference konference, Hotel hotel, Deltager deltager) {
        this.fordragsholder = fordragsholder;
        this.afrejseDato = afrejseDato;
        this.ankomstDato = ankomstDato;
        this.konference = konference;
        this.hotel = hotel;
        this.deltager = deltager;
    }

    public ArrayList<Tilæg> getTilægsListe() {
        return new ArrayList<>(tilægsListe);
    }

    public void addTilæg(Tilæg tilæg) {
        if (!tilægsListe.contains(tilæg)) {
            tilægsListe.add(tilæg);
        }
    }

    public void removeTilæg(Tilæg tilæg) {
        if (tilægsListe.contains(tilæg)) {
            tilægsListe.remove(tilæg);
        }
    }

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    public void addUdflugt(Udflugt udflugt) {
        if (!udflugter.contains(udflugt)) {
            udflugter.add(udflugt);
        }
    }

    public void removeUdflugt(Udflugt udflugt) {
        if (udflugter.contains(udflugt)) {
            udflugter.remove(udflugt);
        }
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        if (this.hotel != hotel) {
            Hotel oldHotel = this.hotel;
            if (oldHotel != null) {
                oldHotel.RemoveTilmelding(this);
            }
            this.hotel = hotel;
            if (hotel != null) {
                hotel.addTilmelding(this);
            }
        }

        this.hotel = hotel;
        hotel.addTilmelding(this);

    }

    public Deltager getDeltager() {
        return deltager;
    }

    public Konference getKonference() {
        return konference;
    }

    public Ledsager createLedsager(String navn) {
        Ledsager ledsager = new Ledsager(navn, this);
        this.ledsager = ledsager;
        return ledsager;
    }


    public void removeLedsager(Ledsager ledsager) {
        if (ledsager != null) {
            this.ledsager = null;
        }
    }

    public Ledsager getLedsager() {
        return ledsager;
    }

    public int samletPris() {
        int samletpris = 0;
        int antalDage = (int) ChronoUnit.DAYS.between(ankomstDato, afrejseDato) + 1;

        if (hotel != null) {
            if (ledsager != null) {
                samletpris = (antalDage - 1) * hotel.getDobbeltværelsePris();
            } else {
                samletpris = (antalDage - 1) * hotel.getEnkeltVærelsesPris();
            }
            for (int i = 0; i < tilægsListe.size(); i++) {
                samletpris += tilægsListe.get(i).getPris() * (antalDage - 1);
            }
        }

        if (!fordragsholder) {
            samletpris += antalDage * konference.getKonferenceAfgift();
        }

        for (int i = 0; i < udflugter.size(); i++) {
            samletpris += udflugter.get(i).getPris();
        }

        return samletpris;
    }

    public LocalDate getAfrejseDato() {
        return afrejseDato;
    }

    public LocalDate getAnkomstDato() {
        return ankomstDato;
    }

    @Override
    public String toString() {
        return deltager.getNavn();
    }
}
