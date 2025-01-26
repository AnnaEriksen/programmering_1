package application.model;

import java.time.LocalDateTime;

public class Træning {

    private LocalDateTime tidspunkt;
    private double antalKm;
    private String rute;

    Træning(LocalDateTime tidspunkt, double antalKm, String rute, LøbeGruppe løbeGruppe) {
        if (tidspunkt == null || rute == null || løbeGruppe == null) {
            throw new IllegalArgumentException("Argumenter må ikke være null");
        }
        if (antalKm <= 0) {
            throw new IllegalArgumentException("Antal km skal være større end 0");
        }
        this.tidspunkt = tidspunkt;
        this.antalKm = antalKm;
        this.rute = rute;
        this.løbeGruppe = løbeGruppe;
    }

    public LøbeGruppe getLøbeGruppe() {
        return løbeGruppe;
    }

    public LocalDateTime getTidspunkt() {
        return tidspunkt;
    }

    public double getAntalKm() {
        return antalKm;
    }

    public String getRute() {
        return rute;
    }

    //--------til løbeGruppe---------------------------------------

    private LøbeGruppe løbeGruppe; //link til løbegruppe


    @Override public String toString() { return "Træning{" + "tidspunkt=" + tidspunkt + ", antalKm=" + antalKm + ", rute='" + rute + '\'' + '}'; }
}
