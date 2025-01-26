package gui;

import application.controller.Controller;
import application.model.Facilitet;
import application.model.Gruppe;
import application.model.PersonChip;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Gui extends Application {

    public void start(Stage stage) {
        stage.setTitle("Holiday Paradise");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane, 800, 400);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
    }


    private TextField txfGruppeNr = new TextField();
    private TextField txfNavn = new TextField();
    private TextField txfAlder = new TextField();
    private TextField txfMaxSaldo = new TextField();
    private ListView<PersonChip> lvwPersoner = new ListView<>();
    private ListView<Facilitet> lvwFaciliteter = new ListView<>();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // oprette en gruppe
        Label lblGruppe = new Label("Gruppe:");
        pane.add(lblGruppe, 0, 0);
        Label lblNr = new Label("Nr:");
        pane.add(lblNr, 0, 1);
        pane.add(txfGruppeNr, 1, 1);
        Button btnOpretGruppe = new Button("Opret gruppe");
        pane.add(btnOpretGruppe, 0, 2);
        btnOpretGruppe.setOnAction(event -> opretGruppe());

        // oprette og tilføje en person til gruppen
        Label lblPerson = new Label("Person:");
        pane.add(lblPerson, 0, 3);
        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 0, 4);
        pane.add(txfNavn, 1, 4);
        Label lblAlder = new Label("Alder:");
        pane.add(lblAlder, 0, 5);
        pane.add(txfAlder, 1, 5);
        Label lblMaxSaldo = new Label("Max saldo:");
        pane.add(lblMaxSaldo, 0, 6);
        pane.add(txfMaxSaldo, 1, 6);
        Button btnTilføjPersonTilGruppe = new Button("Tilføj person til gruppe");
        pane.add(btnTilføjPersonTilGruppe, 0, 7);
        btnTilføjPersonTilGruppe.setOnAction(event -> tilføjTilGruppe());

        Label lblPersoner = new Label("Personer:");
        pane.add(lblPersoner, 2, 0);
        pane.add(lvwPersoner, 2, 1);

        Label lblFaciliteter = new Label("Faciliteter:");
        pane.add(lblFaciliteter, 2, 2);
        pane.add(lvwFaciliteter, 2, 3);
        lvwFaciliteter.getItems().setAll(Controller.getFaciliteter());
        Button btnPersonBrugerFacilitet = new Button("Person bruger facilitet");
        pane.add(btnPersonBrugerFacilitet, 2, 4);
        btnPersonBrugerFacilitet.setOnAction(event -> personBrugerFacilitet());


    }

    private void opretGruppe() {
        String nr = txfGruppeNr.getText().trim();

        if (!nr.isEmpty()) {
            int nrParse = Integer.parseInt(nr);
            Controller.createGruppe(nrParse);
        }

    }

    private void tilføjTilGruppe() {
        String navn = txfNavn.getText().trim();
        String alder = txfAlder.getText().trim();
        String maxSaldo = txfMaxSaldo.getText().trim();
        String gruppeNr = txfGruppeNr.getText().trim();

        if (!navn.isEmpty() && !alder.isEmpty() && !maxSaldo.isEmpty() && !gruppeNr.isEmpty()) {
            int alderParse = Integer.parseInt(alder);
            int maxSaldoParse = Integer.parseInt(maxSaldo);
            int gruppeNrParse = Integer.parseInt(gruppeNr);

            for (Gruppe g : Controller.getGrupper()) {
                if (g.getNr() == gruppeNrParse) {
                    int personChipNr = g.getPersonchips().size();
                    personChipNr++; //tæller personChipNr op efter antallet af personChips i gruppen
                    PersonChip person = Controller.createPersonChip(personChipNr, navn, maxSaldoParse, alderParse, g);
                    lvwPersoner.getItems().setAll(g.getPersonchips());
                    lvwPersoner.refresh();
                }
            }


        }
    }

    private void personBrugerFacilitet() {
        PersonChip personChip = lvwPersoner.getSelectionModel().getSelectedItem();
        Facilitet facilitet = lvwFaciliteter.getSelectionModel().getSelectedItem();

        if (personChip != null && facilitet != null) {
            personChip.addFacilitet(facilitet);
        }

    }


}