package gui;
import application.controller.controller2022;
import application.model.Løb;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import application.model.Tilmelding;
import application.model.Forhindring;
import application.model.Note;

import javafx.scene.control.ListView;
import javafx.scene.control.*;

import static application.controller.controller2022.initStorage;


public class gui extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        initStorage();
        stage.setTitle("OCR Administrationssystem");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    //------------------------------------------------------------------------

    private ListView<Løb> lvwLøb;
    private ListView<Tilmelding> lvwTilmeldinger;
    private ListView<Note> lvwNoter;
    private TextField txfForhindringNavn, txfStrafSekunder;


    private void initContent(GridPane pane) {

        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        //Løb section
        Label lblLøb = new Label("Løb:");
        pane.add(lblLøb, 0, 0);

        lvwLøb = new ListView<>();
        pane.add(lvwLøb, 0, 1);
        lvwLøb.setPrefHeight(200);
        lvwLøb.setPrefWidth(200);
        lvwLøb.getItems().setAll(controller2022.getLøbs()); // Kald af statisk metode
        Button btnShowWinner = new Button("Vis Vinder");
        pane.add(btnShowWinner, 1, 1);
        btnShowWinner.setOnAction(event -> showWinner());

        // Tilmeldinger section
        Label lblTilmeldinger = new Label("Tilmeldinger:");
        pane.add(lblTilmeldinger, 2, 0);
        lvwTilmeldinger = new ListView<>();
        pane.add(lvwTilmeldinger, 2, 1);
        lvwTilmeldinger.setPrefHeight(200);
        lvwTilmeldinger.setPrefWidth(200);

        Button btnShowRegistrations = new Button("Vis Tilmeldinger");
        pane.add(btnShowRegistrations, 3, 1);
        btnShowRegistrations.setOnAction(event -> showRegistrations());

        // Noter sektion
        Label lblNoter = new Label("Noter:");
        pane.add(lblNoter, 4, 0);
        lvwNoter = new ListView<>();
        pane.add(lvwNoter, 4, 1);
        lvwNoter.setPrefHeight(200);
        lvwNoter.setPrefWidth(200);

        // Inputfelter for at registrere noter
        Label lblForhindringNavn = new Label("Forhindring");
        pane.add(lblForhindringNavn,0,3);

        TextField txfForhindringNavn = new TextField();
        pane.add(txfForhindringNavn, 1, 3);

        Label lblStrafSekunder = new Label("Straf sekunder");
        pane.add(lblStrafSekunder,0,4);

        TextField txfStafSekunder = new TextField();
        pane.add(txfStafSekunder,1,4);

        Button btnRegistrerNote = new Button("Registrer note");
        pane.add(btnRegistrerNote,0,5);

        btnRegistrerNote.setOnAction(event -> registerNote());


    }


    private void showWinner(){

        Løb selectedLøb = lvwLøb.getSelectionModel().getSelectedItem();
        if (selectedLøb != null){
            String winner = selectedLøb.findVinder();
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Vinder");
            a.setHeaderText(null);
            a.setContentText(winner);
            a.show();
        }

    }

    private void showRegistrations() {

        Løb selectedLøb = lvwLøb.getSelectionModel().getSelectedItem();
        if (selectedLøb != null){
            lvwTilmeldinger.getItems().setAll(selectedLøb.getTilmeldinger());
        }

    }

    private void registerNote() {
        Tilmelding tilmelding = lvwTilmeldinger.getSelectionModel().getSelectedItem();
        if (tilmelding == null) return;

        String forhindringNavn = txfForhindringNavn.getText().trim();
        int strafSekunder = parseStrafSekunder(txfStrafSekunder.getText().trim());

        Forhindring fundetForhindring = null;
        for (Forhindring forhindring : tilmelding.getLøb().getForhindringer()) {
            if (forhindring.getNavn().equalsIgnoreCase(forhindringNavn)) {
                fundetForhindring = forhindring;
            }
        }

        if (strafSekunder >= 0 && fundetForhindring != null) {
            tilmelding.registrerStrafPåForhindring(fundetForhindring, strafSekunder);
            lvwNoter.getItems().setAll(tilmelding.getNoter());
        } else if (strafSekunder < 0) {
            showAlert("Fejl", "Ugyldigt strafsekund tal", "Indtast venligst et gyldigt heltal for strafsekunder.");
        } else {
            showAlert("Fejl", "Forhindring ikke fundet", "Ingen forhindring med navnet " + forhindringNavn + " blev fundet.");
        }
    }

    private int parseStrafSekunder(String text) {
        int strafSekunder = -1; // Standard værdi, der indikerer fejl
        try {
            strafSekunder = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            // Håndter undtagelse, men ingen return her
        }
        return strafSekunder;
    }




    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title); alert.setHeaderText(header);
        alert.setContentText(content); alert.show();
    }

}
