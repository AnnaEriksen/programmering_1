package model;

import java.util.ArrayList;

public class Plads {
    private int række;
    private int nr;
    private int pris;
    private Pladstype pladstype;


    //0..*   0..* til bestilling
    private ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Plads(int række, int nr, int pris, Pladstype pladstype) {
        this.række = række;
        this.nr = nr;
        this.pris = pris;
        this.pladstype = pladstype;
    }

    public Pladstype getPladstype() {
        return pladstype;
    }

    public void setPladstype(Pladstype pladstype) {
        this.pladstype = pladstype;
    }

    public int getRække() {
        return række;
    }

    public int getNr() {
        return nr;
    }

    public int getPris() {
        return pris;
    }


    @Override
    public String toString() {
        return "Række: " + række + ", nr: " + nr + ", kr " + pris + " Pladstype " + pladstype;
    }

    public ArrayList<Bestilling> getBestillinger() {
        return new ArrayList<>(bestillinger);
    }

    public void addBestilling(Bestilling bestilling) {
        if (!bestillinger.contains(bestilling)) {
            bestillinger.add(bestilling);
        }
    }

//    public void removeBestilling(Bestilling bestilling) {
//        if (bestillinger.contains(bestilling)) {
//            bestillinger.remove(bestilling);
//        }
//    }



}


