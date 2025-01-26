package controller;
import model.Bestilling;
import model.Forestilling;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Kunde;
import model.Plads;
import storage.Storage;




public class Controller {

    public static Forestilling createForestilling(String navn, LocalDate startDato, LocalDate slutDato){
        Forestilling forestilling = new Forestilling(navn, startDato, slutDato);
        Storage.addForestilling(forestilling);

        return forestilling;
    }

    public static Kunde createKunde(String navn, String mobil){
        Kunde kunde = new Kunde(navn, mobil);
        Storage.addKunde(kunde);

        return  kunde;
    }

    public static void initStorage(){

        createForestilling("Evita", LocalDate.of(2019, 1, 10), LocalDate.of(2019, 1, 20));

        createForestilling("Lykke Per", LocalDate.of(2019, 2, 1), LocalDate.of(2019, 2, 10));

        createForestilling("Chess", LocalDate.of(2019, 1, 21), LocalDate.of(2019, 1, 30));

        //-----------------------------------------------------------------------------------

        createKunde("Anders Hansen", "11223344");

        createKunde("Peter Jensen", "12345678");

        createKunde("Niels Madsen", "12341234");

        //---------------------------------------------------------------------------------------------

        Forestilling Evita = createForestilling("Evita", LocalDate.of(2019, 1, 10), LocalDate.of(2019, 1, 20));

        Kunde andersHansen = createKunde("Anders Hansen", "11223344");

        //-----------------------------------------------------------------------------------------------------

        //S10
        Plads plads1 = new Plads(10, 10, 100);
        Plads plads2 = new Plads(10, 11, 100);

        ArrayList<Plads> pladser = new ArrayList<>();

        pladser.add(plads1);
        pladser.add(plads2);

        Bestilling bestilling = opretBestillingMedPladser(Evita, andersHansen, LocalDate.of(2019, 1, 15), pladser);

        //--------------------------------------------------------------------------------------------------------
    }


    //S9
    public static Bestilling opretBestillingMedPladser(Forestilling forestilling, Kunde kunde, LocalDate dato, ArrayList<Plads> pladser) {

        //vi tjekker om den ønskede dato er udenfor tidsrammen for forestillingens slut og startDato, hvis ikke, bliver en exception kastet
        if (dato.isBefore(forestilling.getStartDato()) || dato.isAfter(forestilling.getSlutDato())) {
            throw new RuntimeException("Forestillingen spilles ikke på den ønskede dato");
        }

            //gennemgår alle pladser, som kunden ønsker at bestille. VI tjekker om pladserne er ledige på ønskede datp, hvis ikke, bliver en exception kastet
        for (Plads plads : pladser) {
            if (!forestilling.erPladsLedig(plads.getRække(), plads.getNr(), dato)){
                throw new RuntimeException("Plads" + plads.getRække() + "-" + plads.getNr() + " Er ikke ledig på den ønskede dato");
            }

        } //hvis alle betingelser er opfylst, bliver en ny bestilling oprettet. Pladserne bliver tilføjet til bestillingen og listen returneres
        Bestilling bestilling = new Bestilling(dato, kunde, forestilling);
        for (Plads p : pladser){
            bestilling.addPlads(p);
        }


        return bestilling;
    }



    //S11

    private static ArrayList<Forestilling> forestillinger = new ArrayList<>();

    public static void oversigtOverForestillinger(String filnavn){
        try {
           PrintWriter pr = new PrintWriter(filnavn); //opretter printwriter objekt

            for (Forestilling f : forestillinger) {
                pr.println(f.getNavn()); // Skriver navnene på forestillinger til filen
            }

            pr.close(); //lukker printtwriter
            System.out.println("Forestillinger er skrevet til filen: " + filnavn);

        } catch (IOException e){
            System.out.println("Fejl opstod ved skrivningen af filen:" + e.getMessage());

        }




    }






    }






