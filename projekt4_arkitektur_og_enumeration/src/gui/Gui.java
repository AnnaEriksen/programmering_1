package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Bestilling;
import model.Forestilling;
import model.Kunde;
import model.Plads;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Gui extends Application {
  
    @Override
    public void start(Stage stage) {
        stage.setTitle("Teater Bestillinger");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private TextField txfNavn, txfStartDato, txfSlutDato, txfKundeNavn, txfKundeMobil, txfDato;
    private ListView<Forestilling> lvwForestillinger;
    private ListView<Plads> lvwPladser;
    private ListView<Kunde> lvwKunder;
    private ArrayList<String> kunder, forestillinger, pladser, bestillinger;

    private void initContent(GridPane pane) {
//        this.init Names();

        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblForestillinger = new Label("Forestillinger:");
        pane.add(lblForestillinger, 0, 0);

        // add a label to the pane (at col=0, row=1)
        Label lblKunder = new Label("Kunder:");
        pane.add(lblKunder, 4, 0);
        // GridPane.setValignment(lblKunder, VPos.TOP);

        Label lblPladser = new Label("Pladser:");
        pane.add(lblPladser, 6, 0);

        lvwForestillinger = new ListView<Forestilling>();
        pane.add(lvwForestillinger, 0, 1,2,1);
        lvwForestillinger.getItems().addAll(Controller.getForestillinger());
        lvwForestillinger.setPrefHeight(200);
        lvwForestillinger.setPrefWidth(200);

        lvwKunder = new ListView<Kunde>();
        pane.add(lvwKunder, 4, 1,2,1);
        lvwKunder.getItems().addAll(Controller.getKunder());
        lvwKunder.setPrefHeight(200);
        lvwKunder.setPrefWidth(200);

        lvwPladser = new ListView<Plads>();
        pane.add(lvwPladser, 6,1,2,1);
        lvwPladser.setPrefHeight(200);
        lvwPladser.setPrefWidth(200);
        lvwPladser.getItems().setAll(Controller.getPladser());
        lvwPladser.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 0, 3);
        txfNavn = new TextField();
        pane.add(txfNavn, 1, 3,1,1);

        Label lblStartDato = new Label("Start Dato:");
        pane.add(lblStartDato, 0, 4);
        txfStartDato = new TextField();
        pane.add(txfStartDato,1,4,1,1);


        Label lblSlutDato = new Label("Slut Dato:");
        pane.add(lblSlutDato, 0, 5);
        txfSlutDato = new TextField();
        pane.add(txfSlutDato,1,5,1,1);


        Label lblKundeNavn = new Label("Kunde navn:");
        pane.add(lblKundeNavn, 4, 3);
        txfKundeNavn = new TextField();
        pane.add(txfKundeNavn,5,3,1,1);


        Label lblKundeMobil = new Label("Kunde mobil:");
        pane.add(lblKundeMobil, 4, 4);
        txfKundeMobil = new TextField();
        pane.add(txfKundeMobil,5,4,1,1);

        Button opretForestilling = new Button("Opret Forestilling");
        pane.add(opretForestilling,1,6);
        opretForestilling.setOnAction(event -> opretForestilling());

        Button opretKunde = new Button("Opret Kunde");
        pane.add(opretKunde, 5,5);
        opretKunde.setOnAction(event -> opretKunde());

        Label lblDato = new Label("Dato:");
        pane.add(lblDato,6,3,1,1);
        txfDato = new TextField();
        pane.add(txfDato, 7,3,1,1);

        Button opretBestilling = new Button("Opret Bestilling");
        pane.add(opretBestilling, 7,4,1,1);
        opretBestilling.setOnAction(event -> opretBestilling());


    }

    private void opretForestilling(){
        String navn = txfNavn.getText().trim();
        String startDato = txfStartDato.getText().trim();
        String slutDato = txfSlutDato.getText().trim();

        LocalDate start = LocalDate.parse(startDato);
        LocalDate slut = LocalDate.parse(slutDato);

        if (navn.length() > 0 && startDato.length() > 0 && slutDato.length() > 0){
            Forestilling nyForestilling = Controller.createForestilling(navn, start, slut); //lav ny forestilling fra controller
            lvwForestillinger.getItems().add(nyForestilling); //hvis det ikke funger
            forestillinger.add(nyForestilling + "");
            lvwForestillinger.getItems().setAll(Controller.getForestillinger());

            txfNavn.clear();
            txfStartDato.clear();
            txfSlutDato.clear();
        }
    }

    public void opretKunde(){
        String navn = txfKundeNavn.getText().trim();
        String mobil = txfKundeMobil.getText().trim();

        if (navn.length() > 0 && mobil.length() > 0){
            Kunde nyKunde = Controller.createKunde(navn, mobil); //lav ny kunde fra controller
            lvwKunder.getItems().add(nyKunde); //hvis det ikke funger
            kunder.add(nyKunde + "");
            lvwKunder.getItems().setAll(Controller.getKunder());

            txfKundeNavn.clear();
            txfKundeMobil.clear();
        }

    }

    //Tilføj i pakken gui kode der gør det muligt at vælge en forestilling, en kunde og en dato
//samt en antal pladser, hvorefter der oprettes en bestilling til kunden med de angivne
//pladser. Hvis datoen ikke er i forestillingens spilleperiode, eller hvis ikke alle pladser er
//ledige, skal bestillingen ikke oprettes. Det er et krav, at programmet åbner et dialogvindue

//med besked om, hvad der er oprettet (eller ikke oprettet).

    private void opretBestilling(){
        Forestilling forestilling = lvwForestillinger.getSelectionModel().getSelectedItem();
        Kunde kunde = lvwKunder.getSelectionModel().getSelectedItem();
        List<Plads> pladser = lvwPladser.getSelectionModel().getSelectedItems();

        String dato = txfDato.getText().trim();
        LocalDate datelocal = LocalDate.parse(dato);

        boolean alleErLedige = true;
        for (Plads p: pladser){
            if (!forestilling.erPladsLedig(p.getRække(), p.getNr(),datelocal)){
                alleErLedige = false;
            }
        }
        if (alleErLedige && dato.length() > 0 &&
                datelocal.isAfter(forestilling.getStartDato()) && datelocal.isBefore(forestilling.getSlutDato())){
            Bestilling bestilling = Controller.opretBestillingMedPladser(forestilling, kunde,datelocal, new ArrayList<>(pladser));
            bestillingOprettet();
        }
        else {
            ikkeOprettet();
        }
    
    }

    private void bestillingOprettet(){
        Forestilling forestilling = lvwForestillinger.getSelectionModel().getSelectedItem();
        Kunde kunde = lvwKunder.getSelectionModel().getSelectedItem();
        List<Plads> pladser = lvwPladser.getSelectionModel().getSelectedItems();

        String dato = txfDato.getText().trim();
        LocalDate datelocal = LocalDate.parse(dato);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeight(500);
        alert.setWidth(500);
        alert.setTitle("Success");
        alert.setHeaderText("Din bestilling er klar!: " );
        alert.setContentText(forestilling.getNavn() +
                "\n" + kunde.getNavn() +
                "\n" + dato +
                "\n" + pladser);
        alert.show();

    }

    public void ikkeOprettet(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Din bestilling kan ikke oprettes: ");
        alert.show();
    }
}





