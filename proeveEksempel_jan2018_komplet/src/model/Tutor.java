package model;

import java.util.ArrayList;

public class Tutor {
    private String navn;
    private String email;

    // associering 0..* --> 0..1 Hold
    private Hold hold; // nullable

    // associering  0..* --> 0..* Arrangement
    private final ArrayList<Arrangement> arrangementer = new ArrayList<>();

    public Tutor(String navn, String email) {
        this.navn = navn;
        this.email = email;
    }

    @Override
    public String toString() {
        return navn + " " + email;
    }

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    //-----------------------------------------------------

    // TODO: metoder til linkattributten til Hold klassen

    /** Note: Nullable return value. */
    public Hold getHold() {
        return hold;
    }

    /** Note: Nullable param hold. */
    public void setHold(Hold hold) {
        if (this.hold != hold) {
            Hold oldHold = this.hold;
            if (oldHold != null) {
                oldHold.removeTutor(this);
            }
            this.hold = hold; // link Tutor -> Hold
            if (hold != null) {
                hold.addTutor(this); // link Hold -> Tutor
            }
        }
    }

    //-----------------------------------------------------

    public ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<>(arrangementer);
    }

    public void addArrangement(Arrangement arrangement) {
        if (!arrangementer.contains(arrangement)) {
            arrangementer.add(arrangement);
        }
    }

    public void removeArrangement(Arrangement arrangement) {
        if (arrangementer.contains(arrangement)) {
            arrangementer.remove(arrangement);
        }
    }

    //-----------------------------------------------------

    // S2
    public double arrangementsPris() {
        double samletPris = 0;
        for (Arrangement arrangement : arrangementer) {
            samletPris += arrangement.getPris();
        }
        return samletPris;
    }

    // S4 (se også Hold klassen) 24S med søgeskabelon med while
    public boolean harTidsOverlap(Arrangement arrangement) {
        boolean harTidsOverlap = false;
        int i = 0;
        while (!harTidsOverlap && i < arrangementer.size()) {
            Arrangement arr = arrangementer.get(i);
            if (arr.getDate().equals(arrangement.getDate()) &&
                    arr.getSlutTid().isAfter(arrangement.getStartTid()) &&
                    arr.getStartTid().isBefore(arrangement.getSlutTid())
            ) {
                harTidsOverlap = true;
            } else {
                i++;
            }
        }
        return harTidsOverlap;
    }

    // S4 (se også Hold klassen) 24T med 2 returns og for-each
    public boolean harTidsOverlap1(Arrangement arrangement) {
        for (Arrangement arr : arrangementer) {
            if (arr.getDate().equals(arrangement.getDate())) {
                if (arr.getSlutTid().isAfter(arrangement.getStartTid()) &&
                        arr.getStartTid().isBefore(arrangement.getSlutTid())
                ) {
                    return true;
                }
            }
        }
        return false;
    }
}
