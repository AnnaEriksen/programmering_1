package gui;

import application.controller.Controller;
import application.model.Hold;
import application.model.Tilmelding;
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
        stage.setTitle("");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane, 600, 400);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
    }

    private TextField txfHoldNavn = new TextField();
    private TextField txfDisciplin = new TextField();
    private TextField txfMaxAntal = new TextField();
    private ListView<Hold> lvwAlleHold = new ListView<>();
    private TextArea txaAntalTilmeldinger = new TextArea();
    private TextField txfAdresse = new TextField();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // opret et hold
        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 0, 0);
        pane.add(txfHoldNavn, 1, 0);

        Label lblDisciplin = new Label("Disciplin:");
        pane.add(lblDisciplin, 0, 1);
        pane.add(txfDisciplin, 1, 1);

        Label lblMaxAntal = new Label("Max antal:");
        pane.add(lblMaxAntal, 0, 2);
        pane.add(txfMaxAntal, 1, 2);

        Button btnOpretHold = new Button("Opret hold");
        pane.add(btnOpretHold, 4, 0);
        btnOpretHold.setOnAction(event -> opretHold());

        // viser en liste over alle hold
        Label lblAlleHold = new Label("Alle hold:");
        pane.add(lblAlleHold, 0, 3);
        pane.add(lvwAlleHold, 0, 4, 2, 1);
        lvwAlleHold.getItems().setAll(Controller.getAlleHold());

        // vælg og opdater et hold
        Button btnOpdaterHold = new Button("Opdater hold");
        pane.add(btnOpdaterHold, 5, 0);
        btnOpdaterHold.setOnAction(event -> opdaterHold());

        // vis antal tilmeldinger, der er kommet fra medlemmer med en bestemt adresse, på et hold, der er valgt i listen
        Label lblSøg = new Label("Søg på antal tilmeldinger med adresse:");
        pane.add(lblSøg, 4, 1, 2, 1);
        pane.add(txfAdresse, 4, 2, 2, 1);
        Button btnAntal = new Button("Antal tilmeldinger med adresse:");
        pane.add(btnAntal, 4, 3, 2, 1);
        pane.add(txaAntalTilmeldinger, 4, 4, 2, 1);
        txaAntalTilmeldinger.setPrefWidth(2);
        btnAntal.setOnAction(event -> visAntalTilmeldinger());


    }

    private void opretHold() {
        String navn = txfHoldNavn.getText().trim();
        String disciplin = txfDisciplin.getText().trim();
        String antal = txfMaxAntal.getText().trim();

        if (!navn.isEmpty() && !disciplin.isEmpty() && !antal.isEmpty()) {
            int antalParsed = Integer.parseInt(antal);

            lvwAlleHold.getItems().add(Controller.createHold(navn, disciplin, antalParsed));
            lvwAlleHold.refresh();
        }
    }

    private void opdaterHold() {
        String navn = txfHoldNavn.getText().trim();
        String disciplin = txfDisciplin.getText().trim();
        String antal = txfMaxAntal.getText().trim();

        Hold hold = lvwAlleHold.getSelectionModel().getSelectedItem();

        if (!navn.isEmpty() && !disciplin.isEmpty() && !antal.isEmpty()) {
            int antalParsed = Integer.parseInt(antal);
            Controller.updateHold(hold, navn, disciplin, antalParsed);
            lvwAlleHold.refresh();
        }

    }

    private void visAntalTilmeldinger() {
        Hold hold = lvwAlleHold.getSelectionModel().getSelectedItem();
        String adresse = txfAdresse.getText().trim();

        if (!adresse.isEmpty() && hold != null) {
            txaAntalTilmeldinger.setText(hold.getAntalTilmeldinger(adresse) + "");

        }
    }

}