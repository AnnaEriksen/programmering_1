package gui;

import controller.Controller;
import javafx.application.Application;
import model.Arrangement;
import model.Hold;
import model.Tutor;
import model.Uddannelse;

import java.time.LocalDate;
import java.time.LocalTime;

public class Jan18App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(Jan18Gui.class);
    }

    public static void initStorage() {
        Uddannelse dmu = Controller.opretUddannelse("DMU");
        Uddannelse finø = Controller.opretUddannelse("FINØ");

        Hold e17S = Controller.opretHold("1dmE17S", "Margrethe Dybdahl", dmu);
        Controller.opretHold("1dmE17T", "Kristian Dorland", dmu);
        Hold e17U = Controller.opretHold("1dmE17U", "Kell Ørhøj", dmu);
        Hold e17B = Controller.opretHold("1fiE17B", "Karen Jensen", finø);

        Tutor anders = Controller.opretTutor("Anders Hansen", "aaa@Students.eaaa.dk");
        Tutor peter = Controller.opretTutor("Peter Jensen", "ppp@Students.eaaa.dk");
        Tutor niels = Controller.opretTutor("Niels Madsen", "nnn@Students.eaaa.dk");
        Tutor lone = Controller.opretTutor("Lone Andersen", "lll@Students.eaaa.dk");
        Tutor mads = Controller.opretTutor("Mads Miller", "mmm@Students.eaaa.dk");

        Arrangement rusfest = Controller.opretArrangement(
                "Rusfest", LocalDate.parse("2017-08-31"),
                LocalTime.parse("18:00"), LocalTime.parse("23:30"), 250
        );
        Arrangement fodbold = Controller.opretArrangement(
                "Fodbold", LocalDate.parse("2017-08-30"),
                LocalTime.parse("14:00"), LocalTime.parse("17:30"), 100
        );
        Arrangement brætspil = Controller.opretArrangement(
                "Brætspil", LocalDate.parse("2017-08-29"),
                LocalTime.parse("12:00"), LocalTime.parse("16:30"), 25
        );
        Arrangement mindeparken = Controller.opretArrangement(
                "Mindeparken", LocalDate.parse("2017-08-30"),
                LocalTime.parse("18:00"), LocalTime.parse("22:00"), 25
        );

        // S7
        Controller.addTutorTilHold(anders,e17S);
        Controller.addTutorTilHold(lone,e17S);
        // TODO: Yderligere 3 sammenknytninger af tutor og hold

        // S7
        Controller.addArrangementTilTutor(rusfest, anders);
        Controller.addArrangementTilTutor(rusfest, peter);
        Controller.addArrangementTilTutor(rusfest, mads);
        // TODO: Yderligere 5 sammenknytninger af arrangement og tutor


        // Test udskrifter
//        System.out.println("Alle udd.: " + Storage.getAlleUddannelser());
//        System.out.println("DMU hold: : " + dmu.getHoldListe());
//        System.out.println("FINØ hold: " + finø.getHoldListe());
//        System.out.println("Alle tut.: " + Storage.getAlleTutorer());
//        System.out.println("Alle arr.: " + Storage.getAlleArrangementer());
    }
}
