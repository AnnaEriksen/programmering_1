package Application.Model;

import java.util.ArrayList;

public class Hotel {
    private String navn;
    private int enkeltVærelsesPris;
    private int dobbeltværelsePris;
    private final ArrayList<Tilæg> tilægs = new ArrayList<>();
    private final ArrayList<Konference> konferencer = new ArrayList<>();
    private final ArrayList<Deltager> antalDeltager = new ArrayList<>(); //Måske bare deltagere???
    private final ArrayList<Tildmelding> tilmeldinger = new ArrayList<>();

    public Hotel(String navn, int enkeltVærelsesPris, int dobbeltværelsePris) {
        this.navn = navn;
        this.enkeltVærelsesPris = enkeltVærelsesPris;
        this.dobbeltværelsePris = dobbeltværelsePris;
    }

    public void addTilmelding(Tildmelding tilmelding) {
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
            tilmelding.setHotel(this);
        }
    }

    public void RemoveTilmelding(Tildmelding tildmelding) {
        if (tilmeldinger.contains(tildmelding)) {
            tilmeldinger.remove(tildmelding);
            tildmelding.setHotel(null);
        }

    }

    public ArrayList<Konference> getKonferencer() {
        return new ArrayList<>(konferencer);
    }

    public void addKonference(Konference konference) {
        if (!konferencer.contains(konference)) {
            konferencer.add(konference);
            konference.addHotel(this);
        }
    }

    public void removeKonferance(Konference konference) {
        if (konferencer.contains(konference)) {
            konferencer.remove(konference);
            konference.removeHotel(this);
        }
    }

    public Tilæg createTilæg(String tilægsType, int pris) {
        Tilæg tilæg = new Tilæg(tilægsType, pris, this);
        tilægs.add(tilæg);
        return tilæg;

    }

    public ArrayList<Tilæg> getTilægs() {
        return new ArrayList<>(tilægs);
    }

    public void removeTilæg(Tilæg tilæg) {
        if (tilægs.contains(tilæg)) {
            tilægs.remove(tilæg);
        }
    }

    public int getEnkeltVærelsesPris() {
        return enkeltVærelsesPris;
    }

    public int getDobbeltværelsePris() {
        return dobbeltværelsePris;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return navn + dobbeltværelsePris + " " + enkeltVærelsesPris;
    }
}


