package Application.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {

    private LocalDate dato;
    private int pris;
    private String sted;
    private boolean forplejning;
    private String navn;
    private Konference konference;
    private final ArrayList<Ledsager> ledsagere = new ArrayList<>();

    Udflugt(LocalDate dato, int pris, String sted, boolean forplejning, String navn, Konference konference) {
        this.dato = dato;
        this.pris = pris;
        this.sted = sted;
        this.forplejning = forplejning;
        this.navn = navn;
    }

    public ArrayList<Ledsager> getLedsager() {
        return new ArrayList<>(ledsagere);
    }

    public void addLedsager(Ledsager ledsager) {
        if (!ledsagere.contains(ledsager)) {
            ledsagere.add(ledsager);
        }
    }

    public void removeLedsager(Ledsager ledsager) {
        if (ledsagere.contains(ledsager)) {
            ledsagere.remove(ledsager);
        }
    }

    public Konference getKonference() {
        return konference;
    }

    public int getPris() {
        return pris;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return navn + pris;
    }
}
