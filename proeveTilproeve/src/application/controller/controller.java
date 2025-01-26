package application.controller;

import application.model.Fag;
import application.model.Lektion;
import application.model.Studerende;
import storage.storage;
import java.time.LocalDate;
import java.time.LocalTime;

public class controller {

    public static Studerende createStuderende(String navn, String email){
        Studerende studerende = new Studerende(navn, email);
        storage.addStuderende(studerende);
        return studerende;
    }

    public static Fag createFag(String navn, String klasse){
        Fag fag = new Fag(navn, klasse);
        storage.addFag(fag);
        return fag;
    }

    public static Lektion createLektion(LocalDate dato, LocalTime startTid, String lokale){
        Lektion lektion = new Lektion(dato, startTid, lokale);
        storage.addLektioner(lektion);
        return lektion;
    }

    public static void initStorage(){

        Studerende s1 = createStuderende("Peter Hansen", "ph@stud.dk");
        Studerende s2 = createStuderende("Tina jensen", "tj@stud.dk");
        Studerende s3 = createStuderende("Sascha Petersen", "sp@stud.dk");

        Fag f1 = createFag("PRO1", "20S");
        Fag f2 = createFag("PRO1", "20T");
        Fag f3 = createFag("SU1", "20S");

        Lektion l1 = createLektion(2021-02-01, '08:30', "A1.32");
        Lektion l2 = createLektion(2021-02-01, '10:30',"A1.32");
        Lektion l3 = createLektion(2021-02-03, '08:30', "A1.32");
        Lektion l4 = createLektion(2021-02-03, '10:30', "A1.32");


    }


    //S7

    public static void opretDeltager(){



    }

}