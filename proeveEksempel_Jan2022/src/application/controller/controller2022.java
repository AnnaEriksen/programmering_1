package application.controller;

import application.model.Forhindring;
import application.model.Tilmelding;
import storage.storage;
import application.model.Løb;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class controller2022 {

    //Opgave S7 (10 point)
    //Tilføj klassen Controller. Klassen skal indeholde metoder til at oprette de objekter, der indgår i modellen,
    // og skabe sammenhæng mellem dem.
    //Tilføj derudover en metode initStorage(), der opretter og gemmer data svarende til nedenstående:

    public static Løb createLøbs(LocalDate dato, String sted, int normalPris, LocalDate earlyBirdDate, int earlyBirdPris){
        Løb løb = createLøbs(dato, sted, normalPris, earlyBirdDate, earlyBirdPris);
        storage.addLøb(løb);
        return løb;
    }


    public static Forhindring createForhindring(int nummer, String navn){
        Forhindring forhindring = createForhindring(nummer, navn);
        storage.addForhindringer(forhindring);
        return forhindring;

    }

    // den ser sådan ud fordi vi opretter en tilmelding til det specifikke løb, og ikke en alenestående tilmelding.
    public static Tilmelding tilmelding(String navn, boolean kvinde, LocalDate tildmeldingsDato, int løbeNummer, int løbsTid, Løb løb) {
        Tilmelding tilmelding = løb.createTilmelding(navn, kvinde, tildmeldingsDato, løbeNummer, løbsTid, løb);
        return tilmelding;
    }

    public static ArrayList<Løb> getLøbs() {
        return new ArrayList<>(storage.getLøbs());
    }

    public static void initStorage(){

        //opret løb
        Løb løb = createLøbs(LocalDate.of(2023, 8, 23), "Hasle Bakker", 500, LocalDate.of(2021, 6, 23), 350);


        //opret forhindringer
        Forhindring stejlBakke = createForhindring(1, "Stejl Bakke");
        Forhindring megetStejlBakke = createForhindring(2, "Meget stejl bakke");
        Forhindring mudderpøl = createForhindring(3, "Mudderpøl");
        Forhindring overMur = createForhindring(4, "Mudderpøl");
        Forhindring underGitter = createForhindring(5, "Over mur");


        //opret tilmelding

        Tilmelding sune = løb.createTilmelding("Sune", false, LocalDate.of(2021, 4, 12), 1, 8733, løb);
        Tilmelding anne = løb.createTilmelding("Anne", true, LocalDate.of(2021, 7, 12), 2, 9132, løb);
        Tilmelding bent = løb.createTilmelding("Bent", false, LocalDate.of(2021, 7, 14), 3, -1, løb);
        Tilmelding ole = løb.createTilmelding("Ole", false, LocalDate.of(2021, 5, 10), 4, 8280, løb);
        Tilmelding lars = løb.createTilmelding("Lars", false, LocalDate.of(2021, 4, 8), 5, 9126, løb);
        Tilmelding mette = løb.createTilmelding("Mette", true, LocalDate.of(2021, 8, 20), 5, 12732, løb);


        //registrer straf på løber
        anne.registrerStrafPåForhindring(overMur, 90);
        ole.registrerStrafPåForhindring(overMur, 220);
        lars.registrerStrafPåForhindring(overMur, 180);
        lars.registrerStrafPåForhindring(underGitter, 410);

    }



    //Opgave S10 (10 point)
    //Tilføj til klassen Controller en metode der i en tekstfil udskriver resultatet for de løbere der har gennemført løbet.
    //Resultaterne skal være sorteret primært på køn (kvinder først) og sekundært på resultattid.
    // Data i filen skal se ud som nedenstående:

    public static void writeLedigeTider(LocalDate dato, String filnavn) {
        try { //opre
            PrintWriter printWriter = new PrintWriter(filnavn);
            for (Løb lb : storage.getLøbs()) {
                for (LocalTime l : lb.getLedigeTiderPaaDag(dato)) {
                    printWriter.println(lb + "\nLedige tidspunkter:\n" + l);
                }
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }









}
