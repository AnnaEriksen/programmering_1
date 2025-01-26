package gui;

import application.controller.controller;
import application.model.*;
import javafx.application.Application;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class app {

    public static void main(String[] args) {
        initStorage();

        Application.launch(gui.class);

    }


    public static void initStorage() {

        //Opret Løbegrupper
        LøbeGruppe deHurtige = controller.createLøbegruppe("De hurtige", 3, Distance.MELLEM, 4.30);
        LøbeGruppe Seniorer = controller.createLøbegruppe("Seniorer", 2, Distance.LANG, 6.30);

        //Opret medlemmer
        Medlem emmaGlad = controller.createMedlem("Emma Glad", LocalDate.of(2001, 5, 12));
        Medlem astaLippert = controller.createMedlem("Asta Lippert", LocalDate.of(2003, 3, 16));
        Medlem ellenJensen = controller.createMedlem("Ellen Jensen", LocalDate.of(2002, 10, 20));
        Medlem marenFick = controller.createMedlem("Maren Fick", LocalDate.of(2002, 9, 18));
        Medlem finnMadsen = controller.createMedlem("Finn Madsen", LocalDate.of(1954, 1, 23));
        Medlem bentHansen = controller.createMedlem("Bent Hansen", LocalDate.of(1956, 6, 12));

        //Opret træninger
        LocalDateTime t1 = LocalDateTime.of(2023, 6, 4, 17, 30); // Seniorerne 24 km, De tre bakker
        LocalDateTime t2 = LocalDateTime.of(2023, 6, 6, 10, 30); // Seniorerne 12 km, Store søen rundt
        LocalDateTime t3 = LocalDateTime.of(2024, 1, 5, 17, 30); // De hurtige 8 km, Lille søen rundt
        LocalDateTime t4 = LocalDateTime.of(2024, 1, 7, 17, 30); // De hurtige 12 km, Store søen rundt
        LocalDateTime t5 = LocalDateTime.of(2024, 1, 6, 10, 30); // Seniorerne 24 km, De tre bakker
        LocalDateTime t6 = LocalDateTime.of(2024, 1, 25, 10, 30); // Seniorerne 12 km, Store søen rundt

        Træning S1 = controller.createTræning(t1, 24, "De tre bakker", Seniorer);
        Træning S2 = controller.createTræning(t2, 12, "Store søen rundt", Seniorer);
        Træning DH1 = controller.createTræning(t3, 8, "Lille søen rundt", deHurtige);
        Træning DH2 = controller.createTræning(t4, 12, "Store søen rundt", deHurtige);
        Træning S3 = controller.createTræning(t5, 24, "De tre bakker", Seniorer);
        Træning S4 = controller.createTræning(t6, 12, "Store søen rundt", Seniorer);

//        kan gøres sådan her
//        Træning S1 = controller.createTræning(LocalDateTime.of(2023, 6, 4, 17, 30), 24, "De tre bakker", Seniorer);
//        Træning S2 = controller.createTræning(LocalDateTime.of(2023, 6, 6, 10, 30), 12, "Store søen rundt", Seniorer);
//        Træning DH1 = controller.createTræning(LocalDateTime.of(2024, 5, 1, 17, 30), 8, "Lille søen rundt", deHurtige);
//        Træning DH2 = controller.createTræning(LocalDateTime.of(2024, 7, 1, 17, 30), 12, "Store søen rundt", deHurtige);
//        Træning S3 = controller.createTræning(LocalDateTime.of(2024, 6, 1, 10, 30), 24, "De tre bakker", Seniorer);
//        Træning S4 = controller.createTræning(LocalDateTime.of(2024, 1, 25, 10, 30), 12, "Store søen rundt", Seniorer);

        //Tilføj medlemmer til løbegrupper
        deHurtige.addMedlem(emmaGlad);
        deHurtige.addMedlem(ellenJensen);
        deHurtige.addMedlem(astaLippert);
        deHurtige.addMedlem(marenFick);
        Seniorer.addMedlem(finnMadsen);
        Seniorer.addMedlem(bentHansen);
        Seniorer.addMedlem(ellenJensen);

        //Opret deltagelser og tilføj træning på medlem
        //-----------------------
        //de hurtige

        //emma
        Deltagelse d1 = controller.createDeltagelse(emmaGlad, false, true, DH1);
        Deltagelse d2 = controller.createDeltagelse(emmaGlad, false, true, DH2);

        //asta
        Deltagelse d3 = controller.createDeltagelse(astaLippert, false, true, DH1);
        Deltagelse d4 = controller.createDeltagelse(astaLippert, false, true, DH2);

        //ellen
        Deltagelse d5 = controller.createDeltagelse(ellenJensen, false, true, DH1);
        Deltagelse d6 = controller.createDeltagelse(ellenJensen, false, true, DH2);

        //maren
        Deltagelse d7 = controller.createDeltagelse(marenFick, false, true, DH1);
        Deltagelse d8 = controller.createDeltagelse(marenFick, false, true, DH2);


        //senior--------------------------------------------------------------------------------------------------------
        Deltagelse d9 = controller.createDeltagelse(finnMadsen,false,true, S1);
        Deltagelse d10 = controller.createDeltagelse(finnMadsen,false,true, S2);
        Deltagelse d11 = controller.createDeltagelse(finnMadsen,false,true, S3);
        Deltagelse d12 = controller.createDeltagelse(finnMadsen,false,true, S4);

        //ellen
        Deltagelse d13 = controller.createDeltagelse(ellenJensen,false,true, S1);
        Deltagelse d14 = controller.createDeltagelse(ellenJensen,false,true, S2);
        Deltagelse d15 = controller.createDeltagelse(ellenJensen,false,true, S3);
        Deltagelse d16 = controller.createDeltagelse(ellenJensen,false,true, S4);

        //bent
        Deltagelse d17 = controller.createDeltagelse(bentHansen,false,true, S1);
        Deltagelse d18 = controller.createDeltagelse(bentHansen,false,true, S3);
        Deltagelse d19 = controller.createDeltagelse(bentHansen,false,true, S4);

        //finn
        Deltagelse d20 = controller.createDeltagelse(finnMadsen,false,false, S1);
        Deltagelse d21 = controller.createDeltagelse(finnMadsen,false,true, S2);
        Deltagelse d22 = controller.createDeltagelse(finnMadsen,false,true, S3);
        Deltagelse d23 = controller.createDeltagelse(finnMadsen,false,true, S4);






    }
}
