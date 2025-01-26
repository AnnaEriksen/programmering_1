package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import model.Forestilling;
import model.Kunde;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Jan19Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Teater bestillinger");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<Forestilling> lvwForestillinger = new ListView<>();
    private final ListView<Kunde> lvwKunder = new ListView<>();
    private final TextArea txaBestiltePladser = new TextArea();
    private final TextField txfKundeNavn = new TextField();
    private final TextField txfKundeMobil = new TextField();
    private final TextField txfForestillingNavn = new TextField();
    private final DatePicker dpForestillingDato = new DatePicker();
    private final DatePicker dpReservationDato = new DatePicker();
    private final TextField txfReservationPladser = new TextField();
    private final TextField txfReservationPris = new TextField();
    private final ArrayList<Forestilling> forestillinger = new ArrayList<>();
    private final ArrayList<Kunde> kunder = new ArrayList<>();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20.0));
        pane.setHgap(20.0);
        pane.setVgap(20.0);

        // Forestillinger ListView
        Label lblForestillinger = new Label("Forestillinger");
        pane.add(lblForestillinger, 0, 0);
        pane.add(lvwForestillinger, 0, 1, 1, 8);
        forestillinger.add(new Forestilling("Evita", LocalDate.of(2019, 1, 10), LocalDate.of(2019, 1, 20)));
        forestillinger.add(new Forestilling("Lykke Per", LocalDate.of(2019, 2, 1), LocalDate.of(2019, 2, 10)));
        forestillinger.add(new Forestilling("Chess", LocalDate.of(2019, 1, 21), LocalDate.of(2019, 1, 30)));
        lvwForestillinger.getItems().addAll(forestillinger);

        // Kunder ListView
        Label lblKunder = new Label("Kunder");
        pane.add(lblKunder, 1, 0);
        pane.add(lvwKunder, 1, 1, 1, 8);
        kunder.add(new Kunde("Anders Hansen", "11223344"));
        kunder.add(new Kunde("Peter Jensen", "12345678"));
        kunder.add(new Kunde("Niels Madsen", "12341234"));
        lvwKunder.getItems().addAll(kunder);

        // Reservation Dato
        Label lblReservationDato = new Label("Reservation dato:");
        pane.add(lblReservationDato, 2, 0);
        pane.add(dpReservationDato, 2, 1);

        // Bestilte pladser TextArea
        Label lblBestiltePladser = new Label("Bestilte pladser");
        pane.add(lblBestiltePladser, 2, 2);
        pane.add(txaBestiltePladser, 2, 3, 2, 2);
        txaBestiltePladser.setEditable(false);

        Button btnVisBestilteSæder = new Button("Vis bestilte sæder");
        pane.add(btnVisBestilteSæder, 2, 5);
        btnVisBestilteSæder.setOnAction(event -> visBestiltePladser());

        // Kunde input
        Label lblKundeNavn = new Label("Kunde navn:");
        pane.add(lblKundeNavn, 0, 9);
        pane.add(txfKundeNavn, 1, 9);

        Label lblKundeMobil = new Label("Kunde mobil:");
        pane.add(lblKundeMobil, 0, 10);
        pane.add(txfKundeMobil, 1, 10);

        Button btnOpretKunde = new Button("Opret kunde");
        pane.add(btnOpretKunde, 1, 11);
        btnOpretKunde.setOnAction(event -> opretKunde());

        // Forestilling input
        Label lblForestillingNavn = new Label("Forestilling navn:");
        pane.add(lblForestillingNavn, 0, 12);
        pane.add(txfForestillingNavn, 1, 12);

        Label lblForestillingDato = new Label("Forestilling dato:");
        pane.add(lblForestillingDato, 0, 13);
        pane.add(dpForestillingDato, 1, 13);

        Button btnOpretForestilling = new Button("Opret forestilling");
        pane.add(btnOpretForestilling, 1, 14);
        btnOpretForestilling.setOnAction(event -> opretForestilling());

        // Reservation input
        Label lblReservationPladser = new Label("Pladser:");
        pane.add(lblReservationPladser, 2, 9);
        pane.add(txfReservationPladser, 3, 9);

        Label lblReservationPris = new Label("Pris:");
        pane.add(lblReservationPris, 2, 10);
        pane.add(txfReservationPris, 3, 10);

        Button btnOpretReservation = new Button("Opret reservation");
        pane.add(btnOpretReservation, 3, 11);
        btnOpretReservation.setOnAction(event -> opretReservation());
    }

    private void visBestiltePladser() {
        txaBestiltePladser.setText("Række: 10, nr: 10, kr 100\nRække: 11, nr: 11, kr 100");
    }

    private void opretKunde() {
        String navn = txfKundeNavn.getText();
        String mobil = txfKundeMobil.getText();

        if (navn.isEmpty() || mobil.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, "Udfyld venligst begge felter");
            a.showAndWait();
        } else {
            Kunde kunde = new Kunde(navn, mobil);
            kunder.add(kunde);
            lvwKunder.getItems().add(kunde);
            txfKundeNavn.clear();
            txfKundeMobil.clear();
        }
    }

    private void opretForestilling() {
        String navn = txfForestillingNavn.getText();
        LocalDate dato = dpForestillingDato.getValue();

        if (navn.isEmpty() || dato == null) {
            Alert a = new Alert(Alert.AlertType.WARNING, "Udfyld venligst begge felter");
            a.showAndWait();
        } else {
            Forestilling forestilling = new Forestilling(navn, dato, dato.plusDays(7)); // Eksempel på varighed
            forestillinger.add(forestilling);
            lvwForestillinger.getItems().add(forestilling);
            txfForestillingNavn.clear();
            dpForestillingDato.setValue(null);
        }
    }

    private void opretReservation() {
        String pladser = txfReservationPladser.getText();
        String pris = txfReservationPris.getText();
        Forestilling selectedForestilling = lvwForestillinger.getSelectionModel().getSelectedItem();

        if (selectedForestilling == null || pladser.isEmpty() || pris.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Vælg en forestilling og udfyld begge felter.");
            alert.showAndWait();
        } else {
            String reservation = "Plads: " + pladser + ", Pris: " + pris;
            txaBestiltePladser.appendText(reservation + "\n");
            txfReservationPladser.clear();
            txfReservationPris.clear();
        }
    }
}

