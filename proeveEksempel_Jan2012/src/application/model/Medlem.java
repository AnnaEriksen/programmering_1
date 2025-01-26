package application.model;

import java.util.ArrayList;

public class Medlem {
    private String navn;
    private String adresse;
    private String email;
    private int mobiltlf;

    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Medlem(String navn, String adresse, String email, int mobiltlf) {
        this.navn = navn;
        this.adresse = adresse;
        this.email = email;
        this.mobiltlf = mobiltlf;
    }

    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public int getMobiltlf() {
        return mobiltlf;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobiltlf(int mobiltlf) {
        this.mobiltlf = mobiltlf;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public void addTilmelding(Tilmelding tilmelding) {
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
            tilmelding.setMedlem(this);
        }
    }

    public void removeTilmelding(Tilmelding tilmelding) {
        if (tilmeldinger.contains(tilmelding)) {
            tilmeldinger.remove(tilmelding);
            tilmelding.setMedlem(null);
        }
    }

    //
    // S6 (8 points) - LAVET I CONTROLLER





}
