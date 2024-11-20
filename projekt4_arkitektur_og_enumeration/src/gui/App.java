package gui;

import controller.Controller;
import javafx.application.Application;
import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        initStorage();
        testPrint();

    }

    public static void initStorage() {
        Forestilling Evita = Controller.createForestilling("Evita", LocalDate.of(2027, 8, 10), LocalDate.of(2027, 8, 20));
        Forestilling lykkePer = Controller.createForestilling("Lykke Per", LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 10));
        Forestilling chess = Controller.createForestilling("Chess", LocalDate.of(2023, 8, 21), LocalDate.of(2023, 8, 30));


        Kunde Anders = Controller.createKunde("Anders Hansen", "" + 11223344);
        Kunde Peter = Controller.createKunde("Peter Jensen", "" + 12345678);
        Kunde Niels = Controller.createKunde("Niels Madsen ", "" + 12341234);


        //---------------------------------------------------------------------

//        Pladser svarende til 15 rækker og 20 pladser i hver række:
//        De gule koster 500 kroner, de grønne koster 450 kroner og de blå pladser koster 400 kroner


        for (int række = 1; række <= 15; række++) { //oprætter 15 rækker
            for (int pladsnr = 1; pladsnr < 21; pladsnr++) { //oprætter 20 pladser i hver række

                String farve = "";
                int pris = 0;
                Pladstype pladstype = Pladstype.STANDARD;

                if (række <= 5 && pladsnr <= 2 || række <= 5 && pladsnr >= 19 || række <= 10 && række >= 6 && pladsnr >= 3 && pladsnr <= 18) {
                    farve = "grøn";
                    pris = 450;
                } else if (række <= 5 && pladsnr >= 3 && pladsnr <= 18) {
                    farve = "Gul";
                    pris = 500;
                } else {
                    farve = "Blå";
                    pris = 400;
                }
                if (række == 10 && pladsnr >= 8 && pladsnr <= 12) {
                    pladstype = Pladstype.KØRESTOL;
                } else if (række == 11 && pladsnr >= 8 && pladsnr <= 12) {
                    pladstype = Pladstype.EKSTRABEN;
                }
                Plads plads = Controller.createPlads(række, pladsnr, pris, pladstype);

            }

        }


        Bestilling b = Evita.CreateBestilling(LocalDate.of(2027,8,11), Anders);
        Plads p1 = Controller.createPlads(15,10,400, Pladstype.STANDARD);
        b.addPlads(p1); //bestilling for plads p1



        //vi tjekker om pladsen er ledig (det er den ikke)
        Bestilling nyBestilling = Evita.CreateBestilling(LocalDate.of(2027,8,11), Anders);
        Plads nyPladsAnders = Controller.createPlads(15,11,400,Pladstype.STANDARD);
        nyBestilling.addPlads(nyPladsAnders);

        //tjekker om metoden returnerer alle anders' pladser på datoen
        System.out.println("Anders' pladser til Evita (dato: 2027/08/11): " + Anders.bestiltePladserTilForestillingPådag(Evita,LocalDate.of(2027,8,11)));

        //tjekker om "bestiltePladserTilForestillingPådag"() mmetoden
        System.out.println("Pladsen er ledig: " + Evita.erPladsLedig(15,10,LocalDate.of(2027,8,11)));



        Plads p2 = Controller.createPlads(15,9,400,Pladstype.STANDARD);
        ArrayList<Plads> pladsListe = new ArrayList<>();

        pladsListe.add(p1);
        pladsListe.add(p2);

        Bestilling b2 = Controller.opretBestillingMedPladser(Evita, Peter, LocalDate.of(2027, 8, 12), pladsListe);
        System.out.println("Opretter en bestilling: " + b2);

        System.out.println("Success dato på Evita: " + Evita.succesDato());






    }
    public static void testPrint(){
        System.out.println(Storage.getForestillinger());
        System.out.println(Storage.getKunder());
        System.out.println(Storage.getPladser());


        //for at vise forestillinger i listview, kan man kalde gui'en som gjort her.
        Application.launch(Gui.class);

    }








}

