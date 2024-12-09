package Application.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;
    private String sted;
    private int konferenceAfgift;
    private final ArrayList<Tildmelding> tilmeldinger = new ArrayList<>();
    private final ArrayList<Udflugt> udflugter = new ArrayList<>();
    private final ArrayList<Hotel> hoteler = new ArrayList<>();

    public Konference(String navn, LocalDate startDato, LocalDate slutDato, String sted, int konferenceAfgift) {
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.sted = sted;
        this.konferenceAfgift = konferenceAfgift;
    }

    public void addHotel(Hotel hotel) {
        if (!hoteler.contains(hotel)) {
            hoteler.add(hotel);
            hotel.addKonference(this);
        }
    }

    public void removeHotel(Hotel hotel) {
        if (hoteler.contains(hotel)) {
            hoteler.remove(hotel);
            hotel.removeKonferance(this);
        }
    }

    public ArrayList<Hotel> getHoteler() {
        return new ArrayList<>(hoteler);
    }

    public ArrayList<Tildmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public Tildmelding createTilmelding(boolean fordragsholder, LocalDate ankomstDato, LocalDate afrejseDato,
                                        Konference konference, Hotel hotel, Deltager deltager) {
        Tildmelding tildmelding = new Tildmelding(fordragsholder, afrejseDato, ankomstDato, this, hotel, deltager);
        tilmeldinger.add(tildmelding);
        return tildmelding;
    }

    public void removeTilmeldoing(Tildmelding tildmelding) {
        if (tilmeldinger.contains(tildmelding)) {
            tilmeldinger.remove(tildmelding);
        }
    }

    public Udflugt createUdflugt(LocalDate dato, int pris, String sted, boolean forplejning, String navn) {
        Udflugt udflugt = new Udflugt(dato, pris, sted, forplejning, navn, this);
        udflugter.add(udflugt);
        return udflugt;
    }

    public int getKonferenceAfgift() {
        return konferenceAfgift;
    }

    public void removeUdflugt(Udflugt udflugt) {
        if (udflugter.contains(udflugt)) {
            udflugter.remove(udflugt);
        }


    }

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    @Override
    public String toString() {
        return navn + konferenceAfgift;
    }
}
