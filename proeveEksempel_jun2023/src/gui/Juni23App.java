package gui;

import Storage.Storage;
import controller.Controller;
import javafx.application.Application;
import model.Bane;
import model.Kategori;
import model.Spiller;

import java.time.LocalDate;
import java.time.LocalTime;

public class Juni23App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(Juni23Gui.class);
    }

    private static void initStorage() { opretKategorier(); opretBaner(); opretSpillere(); opretBookinger(); }

    private static void opretKategorier() {
        Controller.createKategori("Luksus", 100, 200);
        Controller.createKategori("Mellem", 50, 100);
        Controller.createKategori("Begynder", 25, 50); }

    private static void opretBaner() {
        Kategori luksus = Storage.getKategorier().get(0);
        Kategori mellem = Storage.getKategorier().get(1);
        Kategori begynder = Storage.getKategorier().get(2);

        Controller.createBane(1, true, LocalTime.of(9, 0), LocalTime.of(17, 0), luksus);
        Controller.createBane(2, true, LocalTime.of(9, 0), LocalTime.of(17, 0), luksus);
        Controller.createBane(3, true, LocalTime.of(9, 0), LocalTime.of(17, 0), mellem);
        Controller.createBane(4, false, LocalTime.of(9, 0), LocalTime.of(17, 0), mellem);
        Controller.createBane(5, false, LocalTime.of(9, 0), LocalTime.of(17, 0), begynder);
        Controller.createBane(6, false, LocalTime.of(9, 0), LocalTime.of(17, 0), begynder);
    }

    private static void opretSpillere() {
        Controller.createSpiller("Andreas", "DMU");
        Controller.createSpiller("Petra", "DMU");
        Controller.createSpiller("Henrik", "ITA");
        Controller.createSpiller("Ulla", "ITA");
    }


    private static void opretBookinger(){
        Spiller andreas = Storage.getSpillere().get(0);
        Spiller henrik = Storage.getSpillere().get(2);
        Spiller ulla = Storage.getSpillere().get(3);

        Bane bane2 = Storage.getBaner().get(1);
        Bane bane3 = Storage.getBaner().get(2);
        Bane bane5 = Storage.getBaner().get(4);

        Controller.createBooking(LocalDate.of(2023, 6, 20), LocalTime.of(10, 0), true, andreas, bane3);
        Controller.createBooking(LocalDate.of(2023, 6, 22), LocalTime.of(10, 0), false, andreas, bane2);
        Controller.createBooking(LocalDate.of(2023, 6, 20), LocalTime.of(11, 0), false, henrik, bane3);
        Controller.createBooking(LocalDate.of(2023, 6, 20), LocalTime.of(16, 0), false, ulla, bane3);
        Controller.createBooking(LocalDate.of(2023, 6, 23), LocalTime.of(17, 0), true,ulla, bane5);

    }


}



