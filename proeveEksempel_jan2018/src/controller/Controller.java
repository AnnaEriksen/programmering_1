package controller;

import model.Arrangement;
import model.Hold;
import model.Tutor;
import model.Uddannelse;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    public static Uddannelse opretUddannelse(String navn) {
        Uddannelse uddannelse = new Uddannelse(navn);
        Storage.storeUddannelse(uddannelse);
        return uddannelse;
    }

    // TODO: Hold, Tutor, Arrangement

    public static Hold opretHold(String betegnelse, String holdleder, Uddannelse uddannelse) {
        Hold hold = uddannelse.createHold(betegnelse, holdleder); // link begge veje
        return hold;
    }

    public static Tutor opretTutor(String navn, String email) {
        var tutor = new Tutor(navn, email);
        Storage.storeTutor(tutor);
        return tutor;
    }

    public static Arrangement opretArrangement(
            String titel, LocalDate date,
            LocalTime startTid, LocalTime slutTid, double pris
    ) {
        Arrangement arrangement = new Arrangement(titel, date, startTid, slutTid, pris);
        Storage.storeArrangement(arrangement);
        return arrangement;
    }

    // S7
    public static void addTutorTilHold(Tutor tutor, Hold hold) {
        hold.addTutor(tutor);
        // tutor.setHold(hold); // alternativ
    }

    public static void addArrangementTilTutor(Arrangement arrangement, Tutor tutor) {
        // TODO: kast RuntimeException, hvis tutoren har et arrangement der overlapper
        tutor.addArrangement(arrangement);
    }

    // Bruges i GUI
    public static void removeArrangementFraTutor(Arrangement arrangement, Tutor tutor) {
        tutor.removeArrangement(arrangement);}

    // streng lagdeling
    public static ArrayList<Uddannelse> getUddannelser() {
        return Storage.getAlleUddannelser();
    }

    public static ArrayList<Arrangement> getAlleArrangementer() {
        return Storage.getAlleArrangementer();
    }


    // S8
    public static ArrayList<Hold> holdUdenTutorer() {
        //skab en tom hold-liste
        ArrayList<Hold> holdListe = new ArrayList<>();

        //gennemløb alle uddannelserne i Storage
        for (Uddannelse uddannelse : Storage.getAlleUddannelser()){

            //(her har vi fat i en uddannelse) gennemløb uddannelsens hold
            for (Hold hold : uddannelse.getHoldListe()) {

                //(her har vi fat i et hold)hvis holdet ikke har en tutor
                if (hold.getTutorer().isEmpty()){

                    //tilføj holdet til hold-listen
                    holdListe.add(hold);

                }
            }
        }

        return holdListe;
    }

    // S10
    public static void tutorOversigtTilFil(String filnavn) {
        File f = new File(filnavn);
        try (PrintWriter writer = new PrintWriter(f)) {
            // TODO
            // gennemløb alle uddannelser i Storage
            for (Uddannelse uddannelse : Storage.getAlleUddannelser()){

                //(her har vi fat i en uddannelse) udskriv navnet på uddannelsen
                writer.println("Uddanelse: " + uddannelse.getNavn());

                //gennemløb tutor-listen returneret fra opgave S9 (her har vi fat i en tekststreng)
                ArrayList<String> tutorOversigt = new ArrayList<>();
                for (String tutorInfo : tutorOversigt) {

                    //udskriv tekststrengen tutorInfo
                    writer.println(tutorInfo);
                }

                // Adskil hver uddannelse med en linje
                writer.println("---------------------------------------------------");
            }

        } catch (FileNotFoundException e) {
            // TODO
            //håndtér fejlen, hvis filen ikke findes
            System.out.println("Fejl ved oprettelse af fil: " + e.getMessage());
        }
    }
}
