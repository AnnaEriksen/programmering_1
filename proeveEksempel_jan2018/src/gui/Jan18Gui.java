package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Arrangement;
import model.Tutor;
import storage.Storage;

public class Jan18Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Administration af tutorer og arrangementer");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // column 0
    private final ListView<Tutor> lvwTutor = new ListView<>();
    // column 2
    private final TextField txfNavn = new TextField();
    private final TextField txfEmail = new TextField();
    private final ListView<Arrangement> lvwArrangement = new ListView<>();
    // column 3
    private final ListView<Arrangement> lvwAlleArrangementer = new ListView<>();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20.0));
        pane.setHgap(20.0);
        pane.setVgap(10.0);

        // column 0
        Label lblTutorer = new Label("Tutorer");
        pane.add(lblTutorer, 0, 0);

        // TODO: ListView med tutorer
        pane.add(lvwTutor, 0, 1, 1, 3);
        lvwTutor.setPrefHeight(200);
        lvwTutor.getItems().addAll(Storage.getAlleTutorer());
        ChangeListener<Tutor> listener = (ObservableValue<? extends Tutor> ov, Tutor o, Tutor n) -> this.selectedTutorChanged();
        lvwTutor.getSelectionModel().selectedItemProperty().addListener(listener);

        // column 1
        Label lblNavn = new Label("Navn");
        pane.add(lblNavn, 1, 0);

        // TODO: 2 labels
        Label lblEmail = new Label("Email");
        pane.add(lblEmail, 1, 1);
        Label lblArrangementer = new Label("Arrangementer");
        pane.add(lblArrangementer, 1, 2);
        GridPane.setValignment(lblArrangementer, VPos.TOP);

        // column 2
        pane.add(txfNavn, 2, 0);

        // TODO: TextField
        pane.add(txfEmail, 2, 1);

        // TODO: Listview med en tutors arrangementer
        pane.add(lvwArrangement, 2, 2);
        lvwArrangement.setPrefHeight(120);

        //  TODO: Fjern-knap
        Button btnFjern = new Button("Fjern");
        pane.add(btnFjern, 2, 3);
        btnFjern.setOnAction(event -> fjernAction());

        // column 3
        Label lblAlleArrangementer = new Label("Alle mulige arrangementer");
        pane.add(lblAlleArrangementer, 3, 1);

        // TODO: ListView med alle arrangementer
        pane.add(lvwAlleArrangementer, 3, 2);
        lvwAlleArrangementer.setPrefHeight(120);
        lvwAlleArrangementer.getItems().setAll(Controller.getAlleArrangementer());

        // TODO: Tilføj-knap
        Button btnTilføj = new Button("Tilføj");
        pane.add(btnTilføj, 3, 3);
        btnTilføj.setOnAction(event -> tilføjAction());


    }

    private void tilføjAction() {
        Tutor tutor = lvwTutor.getSelectionModel().getSelectedItem();
        Arrangement arrangement = lvwAlleArrangementer.getSelectionModel().getSelectedItem();
        if (tutor != null && arrangement != null) {
            // TODO: fang evt. exception kastet af Controller.addArrangement() og vis Alert-vindue
            Controller.addArrangementTilTutor(arrangement, tutor);
            lvwArrangement.getItems().setAll(tutor.getArrangementer());
        }
    }

    private void fjernAction() {
        Tutor tutor = lvwTutor.getSelectionModel().getSelectedItem();
        Arrangement arrangement = lvwArrangement.getSelectionModel().getSelectedItem();
        if (tutor != null && arrangement != null) {
            Controller.removeArrangementFraTutor(arrangement, tutor);
            lvwArrangement.getItems().setAll(tutor.getArrangementer());
        }
    }

    private void selectedTutorChanged() {
        Tutor selected = lvwTutor.getSelectionModel().getSelectedItem();
        if (selected != null) {
            //System.out.println(selected);
            txfNavn.setText(selected.getNavn());
            txfEmail.setText(selected.getEmail());
            lvwArrangement.getItems().setAll(selected.getArrangementer());
        }


    }
}
