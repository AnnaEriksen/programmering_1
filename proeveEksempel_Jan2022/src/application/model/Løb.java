package application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Løb {

    private LocalDate dato;
    private String sted;
    private int normalPris;
    private  LocalDate earlyBirdDate;
    private int earlyBirdPris;

    private final ArrayList<Tilmelding> tilmeldinger = new ArrayList<>(); //link til løb
    private final ArrayList<Forhindring> forhindringer = new ArrayList<>(); //lin til forhindring

    public Løb(LocalDate dato, String sted, int normalPris, LocalDate earlyBirdDate, int earlyBirdPris) {
        this.dato = dato;
        this.sted = sted;
        this.normalPris = normalPris;
        this.earlyBirdDate = earlyBirdDate;
        this.earlyBirdPris = earlyBirdPris;
    }




    public LocalDate getDato() {
        return dato;
    }

    public String getSted() {
        return sted;
    }

    public int getNormalPris() {
        return normalPris;
    }

    public LocalDate getEarlyBirdDate() {
        return earlyBirdDate;
    }

    public int getEarlyBirdPris() {
        return earlyBirdPris;
    }

    //---------------metoder til tilmelding--------------------------------------------------
    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public Tilmelding createTilmelding(String navn, boolean kvinde, LocalDate tildmeldingsDato, int løbeNummer, int løbsTid, Løb løb){
        Tilmelding tilmelding = new Tilmelding(navn, kvinde, tildmeldingsDato, løbeNummer, løbsTid, this);
        tilmeldinger.add(tilmelding);
        return tilmelding;
    }

    public void removeTilmelding(Tilmelding tilmelding){
        if (tilmeldinger.contains(tilmelding)){
            tilmeldinger.remove(tilmelding);
        }
    }

    //---------metoder forinhdring--------------------------------------------------------------------


    public ArrayList<Forhindring> getForhindringer() {
        return new ArrayList<>(forhindringer);
    }

    public void addForhindring(Forhindring forhindring){
        if (!forhindringer.contains(forhindring)){
            forhindringer.add(forhindring);
            forhindring.addLøbs(this);
        }
    }

    public void removeForhindring(Forhindring forhindring){
        if (forhindringer.contains(forhindring)){
            forhindringer.remove(forhindring);
            forhindring.removeLøb(this);
        }
    }

    // Returner ledige tidspunkter på en given dag
    public ArrayList<LocalTime> getLedigeTiderPaaDag(LocalDate dato) {
        if (!this.dato.equals(dato)) { // Ingen tidspunkter, hvis datoen ikke matcher
        }
        return new ArrayList<>(); // Returnerer alle tidspunkter (antager alle er ledige for simplicitet)
    }

    //Opgave S2 (6 point)
    //Tilføj til klassen Løb metoden earlyBirdIndtjening() : int,
    // der returnerer det samlede gebyr der er indbetalt som earlyBird pris for tilmeldinger
    // til løbet. Dvs. de tilmeldinger der er registreret før eller på earlyBirdDate skal regnes med.

    public int earlyBirdIndtjening() {
        int totalGebyr = 0; //til at holde styr på de totale gebyr

        for (Tilmelding t : tilmeldinger) {

            //Vi tjekker om tilmeldingsdatoen for "t"ilmeldingen, er efter earlybirdDato,
            // hvis datoen opdylder kravet, betyder det at deltageren kvalificerer sig til earlybirdPris
            if (!t.getTildmeldingsDato().isAfter(earlyBirdDate)){
                totalGebyr += earlyBirdPris;
            }

        }
        return totalGebyr;
    }
    
    //Opgave S5 (8 point)
    //Tilføj til klassen Løb metoden gennemsnitStrafSekunder(Forhindring forhindring) : double 
    // der returnerer den gennemsnitlige straftid uddelt på en forhindring.

    public double gennemsnitStrafSekunder(Forhindring forhindring){
        double totalStrafSek = 0; //til at holde styr på alle straf i sekunder
        int antalNoter = 0;
        double avg = 0;

        for (Tilmelding t : tilmeldinger) {
            for (Note n : t.getNoter()){
                if (n.getForhindring().equals(forhindring)){
                    totalStrafSek += n.getStrafkSekunder();
                    antalNoter++;

                }
            }
        }
        if (antalNoter > 0){
            avg = totalStrafSek / antalNoter;
        }
        return avg;
    }

    //Opgave S8 (7 point)
    //Tilføj til klassen Løb en metode, der returnerer en tekststreng med løbsnummer,
    // navn og resultattid for vinderen af løbet. Dvs. information om den deltager,
    // der har gennemført løbet hurtigst efter at strafsekunder er tillagt løbstiden.
    // (Bemærk: udgåede løbere har løbstid -1.)

    public String findVinder(){

        Tilmelding vinder = null;
        int bedsteTid = Integer.MAX_VALUE;

        for (Tilmelding t : tilmeldinger) {
            if (t.getLøbsTid() != -1){ //da tiden er -1, hvis køb ikke er gennemført, tjekker vi om løberne har gennemført løbet
                int resultatTid = t.resultatTid(); // vi beregner resultat tiden
                if (resultatTid > bedsteTid){
                    vinder = t;
                }
            }
        }
        String resultat = "Ingen deltagere har gennemført løbet";
        if (vinder != null){
            resultat = "Løbsnummer: " + vinder.getLøbeNummer() + "Navn: " + vinder.getNavn() + "Resultattid: " + bedsteTid;
        }

        return resultat;
    }


}

