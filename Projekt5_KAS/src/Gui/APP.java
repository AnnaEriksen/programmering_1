package Gui;

import Application.Controller.Controller;
import Application.Model.*;
import javafx.application.Application;

import java.time.LocalDate;
import java.util.ArrayList;

public class APP {

    public static void main(String[] args) {

        initStorage();

        Application.launch(GuiTilmelding.class);

    }


    public static void initStorage() {
        // Konferencer

        Konference k1 = Controller.createKonference("Hav og Himmel", LocalDate.of(2024, 12, 18), LocalDate.of(2024, 12, 20), "Odense Universitet", 1500);


        //Udflugter

        Udflugt u1 = Controller.createUdflugt(LocalDate.of(2024, 12, 19), 75, "Egeskov", false, "Egeskov", k1);
        Udflugt u2 = Controller.createUdflugt(LocalDate.of(2024, 12, 20), 200, "Kolding", true, "Trapholt Museum", k1);
        Udflugt u3 = Controller.createUdflugt(LocalDate.of(2024, 12, 18), 125, "Odense", true, "Byrundtur", k1);

        //Hoteller + tillæg
        Hotel h1 = Controller.createHotel("Den Hvide Svane", 1050, 1250);
        Tilæg h11 = Controller.createTillæg("Wifi", 50, h1);

        Hotel h2 = Controller.createHotel("Hotel Phønix", 700, 800);
        Tilæg h21 = Controller.createTillæg("Bad", 200, h2);
        Tilæg h22 = Controller.createTillæg("Wifi", 75, h2);

        Hotel h3 = Controller.createHotel("Pension TusindFryd", 500, 600);
        Tilæg h31 = Controller.createTillæg("Morgenmad", 100, h3);

        Controller.addHotel(k1, h1);
        Controller.addHotel(k1, h2);
        Controller.addHotel(k1, h3);

        //Deltagere
        Deltager d1 = Controller.createDeltager("Finn Madsen", "Vibyvej 28", "Danmark", "Aarhus", "34764311");
        Deltager d2 = Controller.createDeltager("Niels Petersen", "Sommershus 23", "Danmark", "Randers", "57432678");
        Deltager d3 = Controller.createDeltager("Peter Sommer", "Skoleland 44", "Danmark", "Odense", "96845021");
        Deltager d4 = Controller.createDeltager("Lone Jensen", "Finderupballe 1", "Danmark", "Køge", "12345643");

//        Tilmeldinger

        Tildmelding t1 = Controller.createTildmelding(false, LocalDate.of(2024, 12,
                18), LocalDate.of(2024, 12, 20), k1, null, d1);

        Tildmelding t2 = Controller.createTildmelding(false, LocalDate.of(2024, 12,
                18), LocalDate.of(2024, 12, 20), k1, h1, d2);

        Tildmelding t3 = Controller.createTildmelding(false, LocalDate.of(2024, 12,
                18), LocalDate.of(2024, 12, 20), k1, h1, d3);

        Ledsager mie = Controller.createLedsager(t3, "Mie");
        Controller.addUdflugt(t3, u1);
        Controller.addUdflugt(t3, u2);
        Controller.addTillæg(t3, h11);


        Tildmelding t4 = Controller.createTildmelding(true, LocalDate.of(2024, 12,
                18), LocalDate.of(2024, 12, 20), k1, h1, d4);
        Ledsager jan = Controller.createLedsager(t4, "Jan");
        t4.createLedsager("Jan");
        Controller.addUdflugt(t4, u1);
        Controller.addUdflugt(t4, u3);
        Controller.addTillæg(t4, h11);

//        System.out.println(t1.samletPris());
//        System.out.println(t2.samletPris());
//        System.out.println(t3.samletPris());
//        System.out.println(t4.samletPris());
//
//        Controller.hotelgæster(k1);
//        Controller.udflugtGæster(k1);


    }

}
