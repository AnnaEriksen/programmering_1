package Application2020.controller2020;

import Application2020.model2020.*;
import Storage.Storage;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class controller2020 {

    public static Festival createFestival(String navn, LocalDate fraDato, LocalDate tilDato){
        Festival festival = createFestival(navn, fraDato, tilDato);
        Storage.addFestivaller(festival);
        return festival;
    }

    public static Frivillig createFrivillig(String navn, String mobil, int maksAntalTimer){
        Frivillig frivillig = new Frivillig(navn, mobil, maksAntalTimer);
        return frivillig;

    }

    public static FrivilligForening createFrivilligForening(String navn, String mobil, int maksAntalTimer, String foreningsNavn, int antalPersoner) {
        FrivilligForening forening = new FrivilligForening(navn, mobil, maksAntalTimer, foreningsNavn, antalPersoner);
        Storage.addFrivilligeForeninger(forening);
        return forening;
    }



    public static void initStorage(){

        //opret festival
        Festival Northside = createFestival("Northside", LocalDate.of(2020, 6,4), LocalDate.of(2020,6,6));

        //opret frivillige
        Frivillig janeJensen = createFrivillig("Jane Jensen", "12345677", 20);
        Frivillig loneHansen = createFrivillig("Lone Hansen", "78787878", 25);
        Frivillig andersMikkelsen = createFrivillig("Anders Mikkelsen", "55555555", 10);

        //opret frivilig forening
        FrivilligForening ff1 = createFrivilligForening("Christian Madsen", "23232323", 100, "Erhversakademi Aarhus", 40);






        // Opret og tilføj rengøringsjobs til festivalen
        Northside.createJob("T1", "Rengøring af toilet", LocalDate.of(2020,6,4), 100, 5);
        Northside.createJob("T2", "Rengøring af toilet", LocalDate.of(2020,6,4), 100, 5);
        Northside.createJob("T3", "Rengøring af toilet", LocalDate.of(2020,6,4), 100, 5);
        Northside.createJob("T4", "Rengøring af toilet", LocalDate.of(2020,4,5), 100, 5);
        Northside.createJob("T5", "Rengøring af toilet", LocalDate.of(2020,4,5), 100, 5);
        Northside.createJob("T6", "Rengøring af toilet", LocalDate.of(2020,4,5), 100, 5);
        Northside.createJob("T7", "Rengøring af toilet", LocalDate.of(2020,4,6), 100, 5);
        Northside.createJob("T8", "Rengøring af toilet", LocalDate.of(2020,4,6), 100, 5);
        Northside.createJob("T9", "Rengøring af toilet", LocalDate.of(2020,4,6), 100, 5);
    }

    //Opgave S7 (6 point)
    //Tilføj til klassen Controller en metode
    //public static Vagt tagVagt(Job job, Frivillig frivillig, int timer)
    //Metoden skal tilknytte jobbet til den frivillige med det angivne antal timer. Hvis den frivillige ikke
    //har ledige timer nok til at udføre vagten, eller jobbet ikke har så mange ledige timer tilbage, skal
    //metoden kaste en RuntimeException med en passende fejlbesked, og vagten skal ikke oprettes.

    public static Vagt tagVagt(Job job, Frivillig frivillig, int timer){
        if (timer > frivillig.getMaksAntalTimer()){
            throw new RuntimeException(frivillig.getNavn() + " har ikke nok tilgængelige timer");
        }
        if (timer > job.getAntalTimer()){
            throw new RuntimeException(job.getKode() + "har ikke nok tilgængelige timer");
        }
        // Træk timer fra både frivillig og job
        int frivilligeTimer = frivillig.getMaksAntalTimer() - timer;
        int jobTimer = job.getAntalTimer() - timer;
        return new Vagt(timer, job, frivillig);
    }

    //Opgave S9 (7 point)
    //Tilføj til klassen Controller en metode der afgør om en frivillig/kontaktperson med et bestemt
    //navn er på listen, der indeholder navne på de frivillige, der skal have gaver. (Listen fra opgave s8).
    //Metoden skal have følgende metode signatur:
    //public static boolean findFrivillig(Festival festival, String navn)
    //Det kan antages at listen er en sorteret liste af tekststrenge, hvor navn står først i strengen. Det er
    //et krav at metoden skal programmeres som en binærsøgning.


    public static boolean findFrivillig(Festival festival, String navn){

        //antager at gaverTilFrivillige(); returnerer en sorteret liste af navne, som bliver gemt i navnePåfrivillige
        ArrayList<String> navnePåfrivillige = festival.gaverTilFrivillige();
        boolean found = false; //sættes til false, som indikerer at vi ikke har fundet navnet
        int left = 0; //repræsenterer starten af listen
        int right = navnePåfrivillige.size() -1; //repræsenterer slutningen af listen

        //så længe vi ikke har fundet navnet, og start ikke er nået forbi slut
        while (left <= right && !found){
            int middle = (left + right) / 2; //vi finder midtpunktet, /gennemsnittet
            String midNavn = navnePåfrivillige.get(middle); //vi henter navnet ved midterpunktet
            int samlignResult = midNavn.compareTo(navn); //samligner midtpunktets navn med det eftersøgte navn

            if (samlignResult == 0){ //hvis navnene er ens, sættes vores boolean til true
                found = true;
            } else if (samlignResult < 0) { //hvis navnet er "mindre" end det eftersøgte navn
                left = middle + 1; //fortsætter vi søgningen i højre halvdel

            } else { //hvis navnet er større end det eftersøgte navn
                right = middle - 1; //fortsætter vi søgningen i den venstre halvdel
            }
        }
        return found;
    }



}
