package gui;

import application.controller.Controller;
import application.model.Område;
import application.model.Plads;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Gui extends Application {

    public void start(Stage stage) {
        stage.setTitle("Netcafe administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane, 300, 400);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
    }

    //Her initialiseres en ListView til at vise pladser, et TextField til at indtaste nummeret på en plads,
    // og en ToggleGroup for at sikre, at kun én radioknap kan vælges ad gangen.
    private ListView<Plads> lvwPladser = new ListView<>();
    private TextField txfNummer = new TextField();

    private final ToggleGroup group = new ToggleGroup(); // sørger for at kun en btn kan vælges



    //Her initialiseres GridPane med labels, tekstfelter, knapper og radioknapper.
    // lvwPladser fyldes med pladser fra Controller.getPladser().
    // En knap til at oprette en ny plads tilføjes, og dens onAction-hændelse sættes til at kalde opret metoden.
    // Radioknapper til forskellige områder tilføjes til en VBox.
    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblPladser = new Label("Pladser");
        pane.add(lblPladser, 0, 0);
        pane.add(lvwPladser, 0, 1, 2, 1);
        lvwPladser.getItems().setAll(Controller.getPladser());


        Label lblOmråde = new Label("Område");
        pane.add(lblOmråde, 0, 2);

        Label lblNummer = new Label("Nummer");
        pane.add(lblNummer, 0, 3);
        pane.add(txfNummer, 1, 3);

        Button btnOpret = new Button("Opret plads");
        pane.add(btnOpret, 1, 4);
        btnOpret.setOnAction(event -> opret());


        // add v VBox to the pane
        VBox box = new VBox(); // v = afstand mellem rbs
        pane.add(box, 1, 2);


        String[] områdeNavne = {"Standard", "VIP", "Børne", "Turnering"};
        Område[] områder = {Område.STANDARD, Område.VIP, Område.BØRNE, Område.TURNERING};
        // tilføjer 4 radiobuttons til vbox med områdeNavne
        for (int i = 0; i < områdeNavne.length; i++) {
            RadioButton rb = new RadioButton();
            box.getChildren().add(rb); // tilføjer rb til Vbox
            rb.setToggleGroup(group);  // ensure that only one radio button is in selected state
            rb.setText(områdeNavne[i]);
            rb.setUserData(områder[i]);
        }

    }

    private void opret() {

        //Her hentes teksten fra tekstfeltet txfNummer, og eventuelle førende og efterfølgende mellemrum fjernes.
        // Resultatet gemmes i variablen nummer.
        String nummer = txfNummer.getText().trim();

        //Her hentes den valgte radioknap fra ToggleGroup og gemmes i variablen rb.
        RadioButton rb = (RadioButton) group.getSelectedToggle();


        if (nummer.isEmpty() || !rb.isSelected()) { //tjekker om nummer er tomt, eller om radioknap er valgt.
            //hvis kun 1 af disse betingelser er opfyldt, udføres dialogen med fejlbesked

            Dialog<String> dialog1 = new Dialog<>();
            dialog1.setTitle("Fejl");
            dialog1.setHeaderText("Din plads kan ikke oprettes pga. en af følgende årsager mangler:");
            dialog1.setContentText("- Nummer\n- Område");

            ButtonType btnok1 = new ButtonType("Ok");
            dialog1.getDialogPane().getButtonTypes().addAll(btnok1);
            dialog1.setHeight(300);

            dialog1.showAndWait();

        } else { //opretter en ny plads med nummer og personinfo hvis alle oplysninger er korrekte
            int nummer2 = Integer.parseInt(nummer); // nummer2 konverteres til en int parser det herinde for at være sikker på at null ikke bliver parset
            Område område = (Område) rb.getUserData(); //Området hentes fra den valgte radioknap og gemmes i område.
            Plads plads = Controller.createPlads(nummer2, område); //En ny plads oprettes ved hjælp af Controller.createPlads og gemmes i plads.

            lvwPladser.getItems().add(plads); // tilføjer pladser til listview

            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Din plads er oprettet");
            dialog.setHeaderText("Plads oplysninger:");
            dialog.setContentText(String.valueOf(plads));


            //Her oprettes en dialogboks med titlen "Din plads er oprettet" og en besked,
            // der viser oplysninger om den nye plads. En "Ok" knap tilføjes til dialogen, og dialogen vises.
            ButtonType btnok = new ButtonType("Ok");
            dialog.getDialogPane().getButtonTypes().addAll(btnok);
            dialog.setHeight(300);

            dialog.showAndWait(); //viser dialogboksen på skærmen og venter på brugerinteraktion

            lvwPladser.refresh();
        }

    }
}




