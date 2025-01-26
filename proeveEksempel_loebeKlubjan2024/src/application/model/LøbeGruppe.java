package application.model;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class LøbeGruppe {

    private String betegnelse;
    private int antalTræningPrUge;
    private Distance distance;
    private  double minutterPrKm;

    public LøbeGruppe(String betegnelse, int antalTræningPrUge, Distance distance, double minutterPrKm) {
        this.betegnelse = betegnelse;
        this.antalTræningPrUge = antalTræningPrUge;
        this.distance = distance;
        this.minutterPrKm = minutterPrKm;
    }

    public String getBetegnelse() {
        return betegnelse;
    }

    public int getAntalTræningPrUge() {
        return antalTræningPrUge;
    }

    public Distance getDistance() {
        return distance;
    }

    public double getMinutterPrKm() {
        return minutterPrKm;
    }

    //-------------------Metode til medlemmer------------------------------------------------

    private final ArrayList<Medlem> medlemmer = new ArrayList<>();


    public ArrayList<Medlem> getMedlemmer() {
        return new ArrayList<>(medlemmer);

    }

    public void addMedlem(Medlem medlem) {
        if (!medlemmer.contains(medlem)) {
            medlemmer.add(medlem);
        }
    }
    /**
     * Removes the person from this group,
     * if they are connected.
     */
    public void removeMedlem(Medlem medlem) {
        if (medlemmer.contains(medlem)) {
            medlemmer.remove(medlem);

        }
    }

    //---------Til træning-----------------------------------------

    private final ArrayList<Træning> træninger = new ArrayList<>();

    public ArrayList<Træning> getTræninger() {
        return new ArrayList<>(træninger);
    }

    public Træning createTræning(LocalDateTime tidspunkt, double antalKm, String rute){
        Træning træning = new Træning(tidspunkt, antalKm, rute, this);
        træninger.add(træning);
        return træning;
    }

    public void removeTræning(Træning træning){
        if (træninger.contains(træning)){
            træninger.remove(træning);
        }
    }



    //Opgave S4 (4 point) - ngoet med søgeskabelonen
    //Tilføj til klassen LøbeGruppe metoden yngsteMedlem() : String, der returnerer navnet
    //på det yngste medlem i løbegruppen. Det kan antages at der er mindst ét medlem i løbegruppen.


    public String yngsteMedlem(){

        //vi antager det førstemedlem i listen er det yngste og initialiserer derfor en varibael med det første medlem i liste
        Medlem yngste = medlemmer.get(0);
        for (Medlem m : medlemmer) {

            //samligner fødselsdatoer
            if (m.getFødselsDato().isAfter(yngste.getFødselsDato())){
                yngste = m;
            }
        }
        return yngste.getNavn(); //da vi skal hvae navnet på det yngste medlem
    }


    //Opgave S5 (4 point)
    //Tilføj til klassen LøbeGruppe metoden gennemsnitligKmPrTræning() : double,
    // der returnerer hvor mange kilometer der i gennemsnit løbes ved de træninger
    // der hører til denne løbegruppe.

    public double gennemsnitligKmPrTræning(){

        double totalKm = 0; // holder styr på samlede antal km

       for (Træning t : træninger){ //gennemgår alle træninger i løbegruppe
           // for hver træning tilføjer vi antallet af km
           totalKm += t.getAntalKm();
       }

        return totalKm / træninger.size(); //dividerer antallet af km med antal trænineger
    }

    @Override public String toString() {
        return "LøbeGruppe{" + "betegnelse='" + betegnelse + '\'' + ", antalTræningPrUge=" + antalTræningPrUge + ", distance=" + distance + ", minutterPrKm=" + minutterPrKm + '}';
    }
}