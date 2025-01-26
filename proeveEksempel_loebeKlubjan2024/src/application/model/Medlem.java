package application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Medlem {

    private String navn;
    private  LocalDate fødselsDato;

    public Medlem(String navn, LocalDate fødselsDato) {
        this.navn = navn;
        this.fødselsDato = fødselsDato;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getFødselsDato() {
        return fødselsDato;
    }

    //-----metoder til deltagelse------------------------------

    private final ArrayList<Deltagelse> deltagelser = new ArrayList<>(); //link til deltagelse

    public ArrayList<Deltagelse> getDeltagelser() {
        return new ArrayList<>(deltagelser);
    }

    public void removeDeltagelse(Deltagelse deltagelse) {
        if (deltagelser.contains(deltagelse)){
            deltagelser.remove(deltagelse);
        }
    }

    public Deltagelse createDeltagelse(boolean isTræner, boolean isFremmødt, Træning træning){
        Deltagelse deltagelse = new Deltagelse(isTræner, isFremmødt, træning);
        deltagelser.add(deltagelse);
        return deltagelse;
    }

    //Opgave S6 (6 point)
    // Tilføj til klassen Medlem metoden fungeretSomTræner(LøbeGruppe løbegruppe):
    // boolean, der returnerer om det aktuelle medlem har været træner ved en
    // for den i parameterens angivne løbegruppe. Det er et krav at metoden implementeres,
    // under anvendelse af søgeskabelonen.

    public boolean fungeretSomTræner(LøbeGruppe løbegruppe){

        //starter med at antage, at medlemmet ikke har fungeret som træner
        boolean harVæretTræner = false;

        for (Deltagelse d : deltagelser) {

            //vi tjekker for hver deltagelse, om medlemmet har været træner, og om træningen tilhører den specifikke løbegruppe
            if (d.isTræner() && d.getTræning().getLøbeGruppe().equals(løbegruppe)){
                harVæretTræner = true; //hvis begge betingelser er opfyldt, sættes harVæretTræner til true
            }
        }

        return harVæretTræner;
    }


    //Opgave S7 (5 point)
    // Tilføj til klassen Medlem metoden antalLøbteKmIÅr(int år): double,
    // der returnerer, hvor mange kilometer det aktuelle medlem har løbet ved de træninger medlemmet
    // har været tilmeldt og er fremmødt til i det angivne år.

    public int antalLøbteKmIÅr(int år){

        int totalKmIÅr = 0;

        for (Deltagelse deltagelse : deltagelser) {
            Træning t = deltagelse.getTræning(); //For hver deltagelse får vi den tilknyttede træning.

            //Vi tjekker, om medlemmet var fremmødt ved hjælp af deltagelse.isFremmødt().
            //Vi tjekker også, om træningen fandt sted i det angivne år ved hjælp af træning.getTidspunkt().getYear() == år.
            if (deltagelse.isFremmødt() && t.getTidspunkt().getYear() == år){
                totalKmIÅr += t.getAntalKm(); //hvis begge betingelser er opfyldt, tilføjer vi antallet af km i totalKmIÅr
            }
        }
        return totalKmIÅr;
    }


    @Override public String toString() { return "Medlem{" + "navn='" + navn + '\'' + ", fødselsDato=" + fødselsDato + '}'; }
}
