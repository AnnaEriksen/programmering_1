package model;

import java.util.ArrayList;

public class Hold {
    private String betegnelse;
    private String holdleder;
    private String navn;

    // aggregering 0..* --- 1 Uddannelse
    private Uddannelse uddannelse;

    // associering 0..1 --- 0..* Tutor
    private final ArrayList<Tutor> tutorer = new ArrayList<>();

    public Hold(String betegnelse, String holdleder, Uddannelse uddannelse) {
        this.betegnelse = betegnelse;
        this.holdleder = holdleder;

        this.uddannelse = uddannelse; // link Hold -> Uddannelse
        uddannelse.addHold(this);   // link Uddannelse -> Hold
        // setUddannelse(uddannelse); // alternativ
    }

    @Override
    public String toString() {
        return betegnelse + " " + holdleder;
    }

    public String getBetegnelse() {
        return betegnelse;
    }

    public String getHoldleder() {
        return holdleder;
    }

    public String getNavn() {
        return navn;
    }

    //-----------------------------------------------------

    // TODO: metoder til linkattributten til Uddannelse klassen

    public Uddannelse getUddannelse() {
        return uddannelse;
    }

    public void setUddannelse(Uddannelse uddannelse) {
        if (this.uddannelse != uddannelse) {
            Uddannelse oldUddannelse = this.uddannelse;
            if (oldUddannelse != null) {
                oldUddannelse.removeHold(this);
            }
            this.uddannelse = uddannelse;
            if (uddannelse != null) {
                uddannelse.addHold(this);
            }
        }
    }

    //-----------------------------------------------------

    // TODO: metoder til linkattributten til Tutor klassen

    public ArrayList<Tutor> getTutorer() {
        return new ArrayList<>(tutorer);
    }

    public void addTutor(Tutor tutor) {
        if (!tutorer.contains(tutor)) {
            tutorer.add(tutor); // link Hold -> Tutor
            tutor.setHold(this); // link Tutor -> Hold
        }
    }

    public void removeTutor(Tutor tutor) {
        if (tutorer.contains(tutor)) {
            tutorer.remove(tutor);
            tutor.setHold(null);
        }
    }

    //-----------------------------------------------------

    // S3
    public double arrangementspris() {
        double samletPris = 0;
        for (Tutor tutor : tutorer) {
            samletPris += tutor.arrangementsPris();
        }
        return samletPris;
    }

    // S4 (se også Tutor klassen) 24S med søgeskabelon med while
    public boolean harTidsOverlap(Arrangement arrangement) {
        boolean harTidsOverlap = false;
        int i = 0;
        while (!harTidsOverlap && i < tutorer.size()) {
            Tutor tutor = tutorer.get(i);
            if (tutor.harTidsOverlap(arrangement)) {
                harTidsOverlap = true;
            } else {
                i++;
            }
        }
        return harTidsOverlap;
    }

    // S4 (se også Tutor klassen) 24T med 2 returns og for-each
    public boolean harTidsOverlap1(Arrangement arrangement) {
        boolean harTidsOverlap = false;
        for (Tutor tutor : tutorer) {
            if (tutor.harTidsOverlap(arrangement)) {
                return true;
            }
        }
        return false;
    }
}
