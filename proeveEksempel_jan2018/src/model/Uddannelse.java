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

    //TODO S9
    public ArrayList<String> tutorOversigt() {
        // skab en tom tutor-liste
        ArrayList<String> tutorListe = new ArrayList<>();

        // Gennemløb uddannelsens hold (antaget at der findes en liste af hold)
        for (Hold hold: holdListe) {

            //Her har vi fat i et hold og gennemløber holdets tutorer
            for (Tutor tutor : hold.getTutorer()) {// antaget at Hold har metoden getTutorer()

                // skab en tekststreng med info om en tutor
                String tutorInfo = "Tutor: " + tutor.getNavn() + ", Hold: " + hold.getNavn();

                //vi tilføjer tekststrengen til tutorlisten
                tutorListe.add(tutorInfo);


            }

        }
        return tutorListe;
    }
}
