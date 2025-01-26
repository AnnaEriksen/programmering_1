package application.controller;
import application.model.*;
import storage.storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.SplittableRandom;

public class controller {

    public static LøbeGruppe createLøbegruppe(String betegnelse, int antalTræningPrUge, Distance distance, double minutterPrKm){
        LøbeGruppe løbeGruppe = new LøbeGruppe(betegnelse, antalTræningPrUge, distance, minutterPrKm);
        storage.addLøbegrupper(løbeGruppe);
        return løbeGruppe;

    }

    public static Medlem createMedlem(String navn, LocalDate fødselsDato) {
        Medlem medlem = new Medlem(navn, fødselsDato);
        storage.addMedlemmer(medlem);
        return medlem;
    }

    public static Træning createTræning(LocalDateTime tidspunkt, double antalKm, String rute, LøbeGruppe løbeGruppe){
        return løbeGruppe.createTræning(tidspunkt, antalKm, rute);
    }

    public static Deltagelse createDeltagelse(Medlem medlem, boolean isTræner, boolean isFremmødt, Træning træning){
        return medlem.createDeltagelse(isTræner, isFremmødt, træning);

    } //jeg sikrer mig at medlemmet håndterer deltagelsen, ved at propple medlem ind som parametre selvom det ikke er i
    //Deltagelses constructoren. Medlem klassen har en metode til at oprette deltagelse,


    public static ArrayList<LøbeGruppe> getLøbeGrupper() {
        return storage.getLøbeGrupper();

    }

    public static ArrayList<Medlem> getMedlemmer() {
        return storage.getMedlemmer();
    }


    //Opgave S8 (10point)
    //Tilføj til klassen Controller en metode der aflyser en træning.
    // Metoden skal som parameter tage den træning der skal aflyses.
    // Hvis datoen for den træning der forsøges aflyst, er overskredet
    // (før dags dato) skal metoden ikke aflyse men kaste en passende RuntimeException.
    // Hvis tidspunktet for træningen er i fremtiden,
    // skal metoden udover at fjerne træningen fra løbegruppen sikre,
    // at ingen medlemmer længere er deltagere på den træning der aflyses.

    public static void aflysTræning(Træning træning){
        // Trin 1: Kontroller, om datoen for træningen er overskredet
        if (træning.getTidspunkt().isBefore(LocalDateTime.now())){
            throw new RuntimeException("Datoen er overskredet, træningen kan ikke aflyses"); //Hvis ja, kastes en undtagelse.
       }

        // Trin 2: Fjern træningen fra løbegruppen, og da vi allerede har en getLøbegruppe i storage, kalder vi den
        for (LøbeGruppe l : storage.getLøbeGrupper()){
            l.removeTræning(træning);
        }

        // Trin 3: Fjern træningen (deltagelsen) fra medlemmerne
        for (Medlem m : storage.getMedlemmer()){
            for (int i = 0; i < m.getDeltagelser().size(); i++){ //går gennem alle deltagelser der tilhører "m"
                Deltagelse d = m.getDeltagelser().get(i); //vi enter den enkelte deltager "d" ved indeks "I",
                // fra den listen af det nuværende objekt "m"
                if (d.getTræning().equals(træning)){ //tjekker om træningen for "d", er den samme som den vi vil aflyse
                    m.removeDeltagelse(d); //fjerner træningen hvis den passer
                    i--; // justerer indekset ved at side i--, for at undgå at springe det næste element over
                }
            }

        }
    }

    //Opgave S9 (12 point)
    //Tilføj til klassen Controller en metode der i en tekstfil udskriver en oversigt over hvor mange kilometer de enkelte medlemmer har løbet i forskellige år. Oversigten skal være sorteret på år, så der vises et årstal og for hvert årstal vises hvor mange kilometer medlemmet har løbet det pågældende år. For hvert år skal navnet på den løber der har løbet mest fremhæves.
    // Metoden i Controlleren skal have følgende signatur:
    // public static void oversigtLøbteKmIÅr(String filnavn,int fraÅr, int tilÅr)
    // Data i filen skal se ud som nedenstående

    public static void oversigtLøbteKmIÅr(String filnavn,int fraÅr, int tilÅr){
        try {
            PrintWriter pr = new PrintWriter(filnavn);

            //looper fra "fraÅr" til "tilÅr" og skriver hvert år til filen
            for (int i = fraÅr; i <= tilÅr; i++){
                pr.println("År: " + i);

                double flestKm = 0;
                String flittigsteLøber = "";

                for (Medlem m : storage.getMedlemmer()){ //for hvert medlem i storage.getMedllemer()
                    if (m.antalLøbteKmIÅr(i) > 0){ //vi tjekker om medlemmet har løbet nogen km i pågælndende år "i",
                        //hvis antallet af km er større end 0, betyder det at medlemmet har løbet i år
                        pr.println(m.getNavn() + " " + m.antalLøbteKmIÅr(i));
                    }
                    if (m.antalLøbteKmIÅr(i) > flestKm){
                        flestKm = m.antalLøbteKmIÅr(i);
                        flittigsteLøber = m.getNavn();
                    }
                }
                pr.println("\n");
                pr.println("Flittigste løber: " + flittigsteLøber + " med " + flestKm + " kilometer.");
                pr.println("\n");

            }
            pr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}



