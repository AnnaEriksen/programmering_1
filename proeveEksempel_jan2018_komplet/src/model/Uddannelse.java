package model;

import java.util.ArrayList;

public class Uddannelse {
    private String navn;

    // aggregering 1 --- 0..* Hold
    private final ArrayList<Hold> holdListe = new ArrayList<>();

    public Uddannelse(String navn) {
        this.navn = navn;
    }

    @Override
    public String toString() {
        return navn;
    }

    public String getNavn() {
        return navn;
    }

    //-----------------------------------------------------

    // TODO: metoder til linkattributten til Hold klassen

    public ArrayList<Hold> getHoldListe() {
        return new ArrayList<>(holdListe);
    }

    public void addHold(Hold hold) {
        if (!holdListe.contains(hold)) {
            holdListe.add(hold); // link Uddannelse -> Hold
            hold.setUddannelse(this); // link Hold -> Uddannelse
        }
    }

    public void removeHold(Hold hold) {
        if (holdListe.contains(hold)) {
            holdListe.remove(hold);
            hold.setUddannelse(null);
        }
    }

    public Hold createHold(String betegnelse, String holdleder) {
        Hold hold = new Hold(betegnelse, holdleder, this); // link begge veje
        return hold;
    }

    //-----------------------------------------------------

    // S9
    public ArrayList<String> tutorOversigt() {
        ArrayList<String> tutorInfoer = new ArrayList<>();
        // gennemløb uddannelsens hold
        //     (her har vi fat i et hold)
        //     gennemløb holdets tutorer
        //         (her har vi fat i en tutor)
        //         String info = info om tutor m.m.
        //         tilføj info til tutorInfoer
        for (Hold hold : holdListe) {
            for (Tutor tutor : hold.getTutorer()) {
                String info = String.format("%14s", tutor.getNavn()) +
                        String.format("%5s", this.getNavn()) +
                        String.format("%9s", hold.getBetegnelse()) +
                        String.format("%22s", tutor.getEmail()) +
                        hold.getHoldleder();
                tutorInfoer.add(info);
            }
        }
        return tutorInfoer;
    }
}
