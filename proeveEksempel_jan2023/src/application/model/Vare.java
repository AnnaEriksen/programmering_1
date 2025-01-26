package application.model;

import java.util.ArrayList;

public class Vare {
    private String navn;
    private int udbudspris;
    private boolean solgt;
    private Varekategori kategori;

    private Salgsannonce salgsannonce;


    public Vare(String navn, int udbudspris, Varekategori kategori) {
        this.navn = navn;
        this.udbudspris = udbudspris;
        this.solgt = false;
        this.kategori = kategori;
    }

    public String getNavn() {
        return navn;
    }

    public boolean isSolgt() {
        return solgt;
    }

    // til gui
    public String solgtEllerTilSalg() {
        String solgtEllerTilSalg = "";
        if (isSolgt()) {
            solgtEllerTilSalg = "solgt";
        } else {
            solgtEllerTilSalg = "til salg";
        }
        return solgtEllerTilSalg;
    }

    public int getUdbudspris() {
        return udbudspris;
    }

    public Varekategori getKategori() {
        return kategori;
    }

    //--

    public void setSolgt(boolean solgt) {
        this.solgt = solgt;
    }

    //--

    public Salgsannonce getSalgsannonce() {
        return salgsannonce;
    }

    public void setSalgsannonce(Salgsannonce salgsannonce) {
        if (this.salgsannonce != salgsannonce) {
            Salgsannonce oldSalgsannonce = this.salgsannonce;
            if (oldSalgsannonce != null) {
                oldSalgsannonce.removeVare(this);
            }
            this.salgsannonce = salgsannonce;
            if (salgsannonce != null) {
                salgsannonce.addVare(this);
            }
        }
    }


    @Override
    public String toString() {
        return navn +
                " " + udbudspris + " " + solgtEllerTilSalg();
    }
}
