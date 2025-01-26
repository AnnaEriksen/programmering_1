package Application2020.model2020;

import java.util.ArrayList;

public class Frivillig {
    protected String navn;
    protected String mobil;
    protected int maksAntalTimer;

    public Frivillig(String navn, String mobil, int maksAntalTimer) {
        this.navn = navn;
        this.mobil = mobil;
        this.maksAntalTimer = maksAntalTimer;
        this.vagter = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public int getMaksAntalTimer() {
        return maksAntalTimer;
    }

    //----------------til vagt-----------------

    private ArrayList<Vagt> vagter = new ArrayList<>(); // link til vagt

    public ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    void addVagt(Vagt vagt){
        if (!vagter.contains(vagt)){
            vagter.add(vagt);
            vagt.setFrivillig(this);
        }

    }

    void removeVagt(Vagt vagt){
        if (vagter.contains(vagt)){
            vagter.remove(vagt);
            vagt.setFrivillig(null);

        }
    }

    public int antalGaver() {
        return 1;
    }
}





