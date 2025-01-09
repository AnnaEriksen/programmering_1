package gui;

import Storage.Storage;
import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Bane;
import model.Booking;
import model.Spiller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Juni23Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Bane bookings");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // column 0
    private final ListView<Bane> lvwBaner = new ListView<>();
    private final TextArea txaAntalBookinger = new TextArea();
    // column 1
    private final ListView<Spiller> lvwSpillere = new ListView<>();
    // column 2
    private final TextArea txaBookings = new TextArea();
    // column 3
    private final TextField txfDato = new TextField();
    private final TextField txfTid = new TextField();
    private final CheckBox cbxSingle = new CheckBox("Single");

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(5);

        // column 0
        Label lblBaner = new Label("Baner");
        pane.add(lblBaner, 0, 0);

        // Tilføj listener til lvwBaner
        lvwBaner.getSelectionModel().selectedItemProperty().addListener((ov, oldBane, newBane)
                -> this.baneSelected());
        pane.add(lvwBaner, 0, 1);

        Label lblAntalBookninger = new Label("Antal bookinger på banen");
        pane.add(lblAntalBookninger, 0, 2);

        pane.add(txaAntalBookinger, 0, 3);

        // column 1
        Label lblSpillere = new Label("Spillere");
        pane.add(lblSpillere, 1, 0);

        // Tilføj listener til lvwSpillere
        lvwSpillere.getSelectionModel().selectedItemProperty().addListener((ov, oldSpiller, newSpiller)
                -> this.spillerSelected());
        pane.add(lvwSpillere, 1, 1);

        // column 2
        Label lblBookings = new Label("Spillerens bookinger");
        pane.add(lblBookings, 2, 0, 2, 1);

        pane.add(txaBookings, 2, 1, 2, 1);

        Label lblOpretBooking = new Label("Opret booking:");
        pane.add(lblOpretBooking, 2, 2);

        Label lblDato = new Label("Dato:");
        pane.add(lblDato, 2, 3);

        Label lblTid = new Label("Tid:");
        pane.add(lblTid, 2, 4);

        pane.add(txfDato, 3, 3);

        pane.add(txfTid, 3, 4);

        pane.add(cbxSingle, 3, 5);

        Button bookBane = new Button("Book bane");
        bookBane.setOnAction(e -> bookAction());
        pane.add(bookBane, 3, 6);

        // Initialiser ListViews med data
        lvwBaner.getItems().addAll(Storage.getBaner());
        lvwSpillere.getItems().addAll(Storage.getSpillere());
    }

    private void baneSelected() {
        Bane selectedBane = lvwBaner.getSelectionModel().getSelectedItem();
        if (selectedBane != null) {
            ArrayList<Booking> bookinger = Storage.getBookinger();

            StringBuilder bookingText = new StringBuilder();
            for (Booking b : bookinger) {
                if (b.getBane().equals(selectedBane)) {
                    bookingText.append(b).append("\n");
                }
            }
            txaBookings.setText(bookingText.toString());
        } else {
            txaBookings.clear();
        }
    }

    private void spillerSelected() {
            Spiller selectedSpiller = lvwSpillere.getSelectionModel().getSelectedItem();
            if (selectedSpiller != null) {
                ArrayList<Booking> spillerBookinger = Storage.getBookingerBySpiller(selectedSpiller);

                // Opbyg en tekststreng for bookinger for den valgte spiller
                StringBuilder bookingsText = new StringBuilder();
                for (Booking b : spillerBookinger) {
                    bookingsText.append(b).append("\n");
                }

                txaBookings.setText(bookingsText.toString());
            } else {
                txaBookings.clear();
            }
        }
    }

    private void bookAction() {
            String datostr = txfDato.getText().trim();
            String tidstr = txfTid.getText().trim();
            boolean single = cbxSingle.isSelected();
            Spiller spiller = lvwSpillere.getSelectionModel().getSelectedItem();
            Bane bane = lvwBaner.getSelectionModel().getSelectedItem();
            if (spiller != null && bane != null && !datostr.isEmpty() && !tidstr.isEmpty()) {
                try {
                    LocalDate dato = LocalDate.parse(datostr);
                    LocalTime tid = LocalTime.parse(tidstr);

                    Controller.createBooking(dato, tid, single, spiller, bane);

                    bane
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Fejl");
                    alert.setHeaderText(null);
                    alert.setContentText("Der opstod en fejl ved oprettelse af booking: " + e.getMessage());
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Advarsel");
                alert.setHeaderText(null);
                alert.setContentText("Udfyld venligst alle felter og vælg både en spiller og en bane.");
                alert.showAndWait();
            }
        }
    }

    private void updateListViews() {
        lvwBaner.getItems().setAll(Storage.getBaner());
        lvwSpillere.getItems().setAll(Storage.getSpillere());
    }
