package gui;

import application.controller.Controller;
import application.model.Salg;
import application.model.Salgsannonce;
import application.model.Vare;
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
        stage.setTitle("Handelsplatform");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane, 1200, 600);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
    }

    private ListView<Salgsannonce> lvwsalgsannoncer = new ListView<>();
    private ListView<Vare> lvwvarer = new ListView<>();
    private TextField txfKøber, txfAftaltpris, txfFilNavn;

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);


        Label lblAktiveAnnoncer = new Label("Aktive annoncer");
        pane.add(lblAktiveAnnoncer, 0, 0);
        pane.add(lvwsalgsannoncer, 0, 1, 2, 8);
        lvwsalgsannoncer.getItems().setAll(Controller.getAktiveSalgsannoncer());
        lvwvarer.setPrefHeight(50);

        Label lblVarer = new Label("Varer");
        pane.add(lblVarer, 3, 0);
        pane.add(lvwvarer, 3, 1, 2, 8);

        // viser varer for valgt annonce
        ChangeListener<Salgsannonce> listener = (ov, oldVare, newVare) -> selected();
        lvwsalgsannoncer.getSelectionModel().selectedItemProperty().addListener(listener);
        lvwvarer.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // flere varer i lvw kan vælges


        Label lblKøber = new Label("Køber");
        pane.add(lblKøber, 6, 1);
        txfKøber = new TextField();
        pane.add(txfKøber, 7, 1);

        Label lblAftaltPris = new Label("Aftalt pris");
        pane.add(lblAftaltPris, 6, 2);
        txfAftaltpris = new TextField();
        pane.add(txfAftaltpris, 7, 2);

        Button btnOpretSalg = new Button("Opret Salg");
        pane.add(btnOpretSalg, 6, 3);
        btnOpretSalg.setOnAction(event -> opretSalg());

        Label lblFilNavn = new Label("Fil navn");
        pane.add(lblFilNavn, 6, 4);
        txfFilNavn = new TextField();
        pane.add(txfFilNavn, 7, 4);

        Button btnSalgsfil = new Button("Salgs fil");
        pane.add(btnSalgsfil, 6, 5);
        btnSalgsfil.setOnAction(event -> opretFil());


    }

    // viser varer for valgt salgsannonce
    private void selected() {
        Salgsannonce salgsannonce = lvwsalgsannoncer.getSelectionModel().getSelectedItem();
        if (salgsannonce != null) {
            lvwvarer.getItems().setAll(salgsannonce.getVarer());
        }
    }

    //TODO S9
    // Oprette et salg med en aftalt salgspris for de valgte varer
    // (hvis den valgte varer allerede er solgt eller der ikke er angivet aftalt pris
    // eller navn på køber skal salget ikke oprettes.
    // Da skal der i stedet komme en dialog med en passende fejltekst)
    private void opretSalg() {

        //henter teksten fra tekstfelterne txfkøber og txfaftaltpris
        String navn = txfKøber.getText().trim();
        String aftaltPris = txfAftaltpris.getText().trim();


        ArrayList<Vare> selectedVarer = new ArrayList<>(lvwvarer.getSelectionModel().getSelectedItems()); //ændrer List til ArrayList, da createSalg kun tager en ArrayList som parameter

        //boolean initialiseres til false til start. Vi gennemgår valgte varer, og hvis en vare allerede er solgt, sættes solgt til true
        boolean solgt = false;
        for (Vare v : selectedVarer) {
            if (v.isSolgt()) {
                solgt = true;
            }
        }

        //hvis det kun er nogle af betingelserne der er opfyldte, vises en dialogboks med en af flere fejlmeddelelser
        if (navn.isEmpty() || aftaltPris.isEmpty() || selectedVarer.isEmpty() || solgt) {
            Dialog<String> dialog1 = new Dialog<>();
            dialog1.setTitle("Salget kan ikke oprettes");
            dialog1.setHeaderText("Du kan ikke oprette et salg pga. en af følgende årsager:");
            dialog1.setContentText("- En valgt vare er allerede solgt\n- Aftalt pris mangler\n- Navn på køber mangler\n- Du mangler at vælge en salgsannonce/vare");
            ButtonType btnok1 = new ButtonType("Ok");
            dialog1.getDialogPane().getButtonTypes().addAll(btnok1);
            dialog1.setHeight(500);
            dialog1.showAndWait();

        } else { //vi opretter et salg, hvis alle oplysninger er korrekte
            int aftalPris2 = Integer.parseInt(aftaltPris); //aftalt pris konverteres til en integer
            Salg salg = Controller.createSalg(navn, aftalPris2, selectedVarer); //nyt salg oprettes
            Dialog<String> dialog2 = new Dialog<>(); //En dialogboks vises med en bekræftelse på salget.
            dialog2.setTitle("Dit salg");
            dialog2.setHeaderText("Tillykke med dit salg");
            dialog2.setContentText("Købers navn: " + navn + "\nAftalt pris: " + aftaltPris + "\nVare(r): " + selectedVarer);

            ButtonType btnok2 = new ButtonType("Ok");
            dialog2.getDialogPane().getButtonTypes().addAll(btnok2);
            dialog2.setHeight(500);

            dialog2.showAndWait();

            lvwvarer.refresh(); // Listevisningen lvwvarer opdateres for at vise, at varerne er solgt.
        }

    }

    private void opretFil() {

        //henter teksten fra txfFilnavn og eventuelle mellemrum bliver fjernet
        String filnavn = txfFilNavn.getText().trim();
        try {
            Controller.salgTilFil(filnavn); //forsøger at kalde metoden Controller.salgTilFil med filnavn som parameter.
            // Hvis der opstår en FileNotFoundException, kastes en RunTimeException med den oprindelige undatagelse som årsag
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //opretter dialog med titlen "Fil er oprettet" og en headertekst,
        //der informerer brugeren om, at en fil med alle salg er blevet oprettet.
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Fil er oprettet");
        dialog.setHeaderText("Du har oprettet en fil med alle salg");

        //En ButtonType med teksten "Ok" tilføjes til dialogen.
        ButtonType btnok = new ButtonType("Ok");
        dialog.getDialogPane().getButtonTypes().addAll(btnok);
        dialog.setHeight(500);

        dialog.showAndWait();

    }


}