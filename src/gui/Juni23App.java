package gui;

import controller.Controller;
import javafx.application.Application;
import model.Bane;
import model.Booking;
import model.Kategori;
import model.Spiller;

import java.time.LocalDate;
import java.time.LocalTime;

public class Juni23App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(Juni23Gui.class);
    }

    // S7
    private static void initStorage() {
        // Bemærk: Resten af objekterne er oprettet nederst som kommentar
        // lav TODOs her FØR du ser på kommentaren nederst

        // TODO: opret Kategori Luksus
        Kategori luksus = Controller.createKategori("Luksus", 100, 200);
        Kategori Mellem = Controller.createKategori("Mellem", 50, 100);
        Kategori Begynder = Controller.createKategori("Begynder", 25, 50);

        // TODO: opret Bane 1
        Bane bane1 = Controller.createBane(1, true, LocalTime.of(9, 0), LocalTime.of(17, 0), luksus);
        Bane bane2 = Controller.createBane(2, true, LocalTime.of(9, 0), LocalTime.of(17, 0), luksus);
        Bane bane3 = Controller.createBane(3, true, LocalTime.of(9, 0), LocalTime.of(17, 0), Mellem);
        Bane bane4 = Controller.createBane(4, false, LocalTime.of(9, 0), LocalTime.of(17, 0), Mellem);
        Bane bane5 = Controller.createBane(5, false, LocalTime.of(9, 0), LocalTime.of(17, 0), Begynder);
        Bane bane6 = Controller.createBane(6, false, LocalTime.of(9, 0), LocalTime.of(17, 0), Begynder);


        // TODO: opret Spiller Andreas
        Spiller Andreas = Controller.createSpiller("Andreas", "DMU");
        Spiller Petra = Controller.createSpiller("Petra", "DMU");
        Spiller henrik = Controller.createSpiller("Henrik", "ITA");
        Spiller ulla = Controller.createSpiller("Ulla", "ITA");


        // TODO: opret Booking lavet af Andreas af bane 3 den 20/6-23 kl. 10 til single spil
Controller.createBooking(LocalDate.of(2023, 6, 20), LocalTime.of(10,0), true, Andreas, bane3);
        Controller.createBooking(LocalDate.of(2023, 6, 22), LocalTime.of(10, 0), false, Andreas, bane2);
        Controller.createBooking(LocalDate.of(2023, 6, 20), LocalTime.of(11, 0), false, henrik, bane3);
        Controller.createBooking(LocalDate.of(2023, 6, 20), LocalTime.of(16, 0), false, ulla, bane3);
        Controller.createBooking(LocalDate.of(2023, 6, 23), LocalTime.of(17, 0), true, ulla, bane5);



        //S10
        //TODO lav booking objekter i initstorage i controller
        Controller.createBooking(LocalDate.of(2023, 6, 20), LocalTime.of(10, 00, 00, 00), true, Andreas, bane3);
        Controller.createBooking(LocalDate.of(2023, 6, 22), LocalTime.of(10, 00, 00, 00), false, Andreas, bane2);
        Controller.createBooking(LocalDate.of(2023, 6, 20), LocalTime.of(11, 00, 00, 00), false, henrik, bane3);
        Controller.createBooking(LocalDate.of(2023, 6, 20), LocalTime.of(16, 00, 00, 00), false, ulla, bane3);
        Controller.createBooking(LocalDate.of(2023, 6, 23), LocalTime.of(17, 00, 00, 00), true, ulla, bane5);


    }
}
