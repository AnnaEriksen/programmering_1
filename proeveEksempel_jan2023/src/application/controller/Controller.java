package application.controller;

import application.model.*;
import storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Controller {
    public static Saelger createSaelger(String navn, int studiekortNummer, String mobil) {
        Saelger saelger = new Saelger(navn, studiekortNummer, mobil);
        Storage.addSaelger(saelger);
        return saelger;
    }

    public static Salg createSalg(String købersNavn, int aftaltSamletPris, ArrayList<Vare> varer) {
        Salg salg = new Salg(købersNavn, aftaltSamletPris, varer);
        for (Vare v : varer) {
            v.getSalgsannonce().skalSalgsannonceVæreAktiv();
        }
        Storage.addSalg(salg);
        return salg;
    }

    public static Vare createVare(String navn, int udbudspris, Varekategori kategori) {
        Vare vare = new Vare(navn, udbudspris, kategori);
        Storage.addVare(vare);
        return vare;
    }


    public static Salgsannonce createSalgsannonce(Saelger saelger) {
        Salgsannonce salgsannonce = new Salgsannonce(saelger);
        Storage.addSalgsannonce(salgsannonce);
        return salgsannonce;
    }

    //--

    public static void initStorage() {
        Saelger s1 = createSaelger("Viktor", 23, "45344247");
        Saelger s2 = createSaelger("Gustav", 35, "56124522");

        Vare v1 = createVare("Samsung mobil", 1200, Varekategori.MOBILTELEFON);
        Vare v2 = createVare("IPhone", 2000, Varekategori.MOBILTELEFON);
        Vare v3 = createVare("Java", 400, Varekategori.STUDIEBOG);
        Vare v4 = createVare("Android", 300, Varekategori.STUDIEBOG);
        Vare v5 = createVare("Python", 200, Varekategori.STUDIEBOG);
        Vare v6 = createVare("Regnjakke", 100, Varekategori.TØJ);
        Vare v7 = createVare("Regnbukser", 80, Varekategori.TØJ);

        Salgsannonce salgsannonce1 = createSalgsannonce(s1);
        salgsannonce1.addVare(v1);

        Salgsannonce salgsannonce2 = createSalgsannonce(s1);
        salgsannonce2.addVare(v3);
        salgsannonce2.addVare(v4);
        salgsannonce2.addVare(v5);

        Salgsannonce salgsannonce3 = createSalgsannonce(s2);
        salgsannonce3.addVare(v2);

        Salgsannonce salgsannonce4 = createSalgsannonce(s2);
        salgsannonce4.addVare(v6);
        salgsannonce4.addVare(v7);

        ArrayList<Vare> stinesKøb = new ArrayList<>();
        stinesKøb.add(v4);
        stinesKøb.add(v5);
        Salg salg1 = createSalg("Stine", 450, stinesKøb);

        ArrayList<Vare> laurasKøb = new ArrayList<>();
        laurasKøb.add(v6);
        laurasKøb.add(v7);
        Salg salg2 = createSalg("Laura", 120, laurasKøb);

        System.out.println( s1.alleIkkeSolgteVarerIKategori(Varekategori.STUDIEBOG));

    }


    //TODO hjælpemetode til S8 SORTERING
    public static void insertionSort(ArrayList<Salg> list) {
        for (int i = 1; i < list.size(); i++) { // starter i = 1, da i = 0 betragtes sorteret ved at samligne elementer fra 1 og frem
            Salg next = list.get(i); // gemmer det element vi kigger på i øjeblikket. Det aktuelle element
            int j = i; // den position hvor next skal indsættes
            boolean found = false; // til at stoppe while, når den rigtige position er fundet
            while (!found && j > 0) { // så længe !found  er false og har flere elementer tilbage at tjekke j er større end 0 dvs., når hen til starten af listen og har mere at tjekke igennem
                if (next.getKøbersNavn().compareTo(list.get(j - 1).getKøbersNavn()) >= 0) { // hvis next købers fornavn er alfabetisk >= end fornavnet på kunden før (j-1),
                    found = true; //, så er den på den rigtige position og løkken stoppes ved found = true;
                } else {
                    list.set(j, list.get(j - 1)); //Hvis ikke, flyttes elementet på position j-1 til position j, og j reduceres med 1 for at sammenligne næste element.
                    j--; // går en position tilbage for at sammenligne næste element
                }
            }
            list.set(j, next); // når den rigtige position findes (eller løkken stopper), sættes next på j's position
        }
    }

    //TODO S8
    // Tilføj til klassen Controller en metode der i en tekstfil udskriver alle salg.
    // I filen skal salgene være sorteret efter navnet på køberen og for alle salg det fremgå,
    // hvilke varer der indgik i salget, hvad den aftalte samlede pris blev og hvad rabatten blev.
    public static void salgTilFil(String fileName) throws FileNotFoundException {
        //String filename = "C:\Users\annae\IdeaProjects\projekt 1\proeveEksempel_jan2023\src\Rabat.txt";

        PrintWriter printWriter = new PrintWriter(fileName); //printwriter objekt til at skrive tekst til en fil

        // sorterer først en kopi af salgslisten af storage og gemmes i den nye liste,
        // derefter sorteres den vha InsertionSort();
        ArrayList<Salg> sorteretSalgsListe = new ArrayList<>(Storage.getSalgs());
        insertionSort(sorteretSalgsListe);


        for (Salg s : sorteretSalgsListe) { //hvor hver salg i listen den sorteretsalgsListe
            printWriter.println(s.getKøbersNavn()); //skrives køberens navn i filen
            printWriter.println(":\n"); //linjeskift

            int samletUdbudspris = 0;

            for (Vare v : s.getVarer()) { //for hver vare i salget

                printWriter.println(v + " " + v.getUdbudspris()); //skrives udbudsprisen ned i filen
                samletUdbudspris += v.getUdbudspris(); //samletUdbudsPris bliver opdateret
                // ved at tilfæje varens udbudspris
            }
            int rabat = samletUdbudspris - s.getAftaltSamletPris(); //rabatten udregnes som forskellen mellem
            // samletUdbudsPris og aftaltSamletpris

            printWriter.println("Aftalt pris: " + s.getAftaltSamletPris() + " rabat er: " + rabat);
            //den afralte pris og rabat bliver skrevet ned i filen
        }
        // skriv filen
        printWriter.close();

    }


    // TODO hjælpemetode til S9 SORTERING
    public static void insertionSort2(ArrayList<Saelger> list) {
        for (int i = 1; i < list.size(); i++) { // starter i = 1, da i = 0 betragtes sorteret
            Saelger next = list.get(i); // gemmer det element vi kigger på i øjeblikket, altså det aktuelle element
            int j = i; // den position hvor next skal indsættes
            boolean found = false; // til at stoppe while, når den rigtige position er fundet
            while (!found && j > 0) { // så længe !found og har flere elementer tilbage at tjekke at j er større end 0 dvs., når hen til starten af listen
                if (next.getNavn().compareTo(list.get(j - 1).getNavn()) >= 0) { // hvis next kæbers fornavn i next er alfabetisk >= end fornavnet på kunden før (j-1),
                    found = true; //, så er den på den rigtige position og løkken stoppes ved at found bliver sat til true
                } else {
                    list.set(j, list.get(j - 1)); // j-1 sættes på j's plads
                    j--; // går en position tilbage for at sammenligne næste element, dbs j reduceres med 1
                }
            }
            list.set(j, next); // når den rigtige position findes (eller løkken stopper), sættes next på j's position
        }
    }

    //TODO  S9
    // Tilføj til klassen Controller en metode der returnerer en liste med de sælger objekter der også har foretaget køb af vare.
    // Det kan antages at hvis navn på sælger og købersNavn er ens, da er der tale om den samme studerende.
    //Bemærk: Denne opgave kan løses under anvendelse af fletteskabelonen.

    public ArrayList<Saelger> saelgereDerHarForetagetKøb(ArrayList<Saelger> s1, ArrayList<Salg> s2) {

        //opretter en kopi af listen s1 og derefter sorteres den vha insertionSort2
        ArrayList<Saelger> s1Sorteret = new ArrayList<>(s1);
        insertionSort2(s1Sorteret);

        //oprettes en ny tom liste som skal indholde sælgere der har foretaget køb
        ArrayList<Salg> s2Sorteret = new ArrayList<>(s2);
        insertionSort(s2); //sorteres

        // fletning
        ArrayList<Saelger> saelgereMedKøb = new ArrayList<>();
        int i1 = 0; //bruges til at gennengå den sortede liste s1
        int i2 = 0; //bruges til at gennengå den sortede liste s2

        while (i1 < s1Sorteret.size() && i2 < s2Sorteret.size()) { //Dette loop fortsætter, så længe der er elementer tilbage i begge lister.

            //hvis navnet på sælgeren i s1 er alfabetisk mindre end købers navn i s2,// tælles i1 op
            if (s1Sorteret.get(i1).getNavn().compareTo(s2Sorteret.get(i2).getKøbersNavn()) < 0) {
                i1++;

                //hvis navnet på sælgeren i s1 er alfabetisk større end købers navn i s2,// tælles i2 op
            } else if (s1Sorteret.get(i1).getNavn().compareTo(s2Sorteret.get(i2).getKøbersNavn()) > 0) {
                i2++;
            } else {
                saelgereMedKøb.add(s1Sorteret.get(i1)); //hvis navnene er ens, tilføjes sælgeren til listen, både i1, og i2 tælles op
                i1++;
                i2++;
            }
        }
        return saelgereMedKøb; //returnerer listen med sælgere der har foretaget et køb
    }

    //--

    public static ArrayList<Salgsannonce> getAktiveSalgsannoncer() {
        ArrayList<Salgsannonce> aktiveSalgsAnnoncer = new ArrayList<>();
        for (Salgsannonce s : Storage.getSalgsannoncer()) {
            s.skalSalgsannonceVæreAktiv();
            if (s.isAktiv()) {
                aktiveSalgsAnnoncer.add(s);
            }
        }

        return aktiveSalgsAnnoncer;
    }


    //--


}
