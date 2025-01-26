package gui;

import application.controller.Controller;
import application.model.Deltagelse;
import application.model.DeltagerStatus;
import application.model.Fag;
import application.model.Lektion;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Gui extends Application {

    public void start(Stage stage) {
        stage.setTitle("Fraværssystem");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane, 800, 300);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
    }

    private ListView<Fag> lvwFag = new ListView<>();
    private ListView<Lektion> lvwLektion = new ListView<>();
    private ListView<Deltagelse> lvwDeltagelse = new ListView<>();

    private final ToggleGroup group = new ToggleGroup(); // sørger for at kun en btn kan vælges

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblFag = new Label("Fag");
        pane.add(lblFag, 0, 0);
        pane.add(lvwFag, 0, 1);
        lvwFag.getItems().setAll(Controller.getFag());
        lvwFag.setPrefWidth(200);

        Label lblLektion = new Label("Lektion");
        pane.add(lblLektion, 1, 0);
        pane.add(lvwLektion, 1, 1);
        lvwLektion.setPrefWidth(200);

        // viser lektioner for valgt fag
        ChangeListener<Fag> listener = (ov, oldFag, newFag) -> selectedFag();
        lvwFag.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblDeltagelse = new Label("Deltagelse");
        pane.add(lblDeltagelse, 2, 0);
        pane.add(lvwDeltagelse, 2, 1);
        lvwDeltagelse.setPrefWidth(200);

        // viser deltagelse for valgt lektion
        ChangeListener<Lektion> listener2 = (ov, oldLektion, newLektion) -> selectedLektion();
        lvwLektion.getSelectionModel().selectedItemProperty().addListener(listener2);

        Label lblFraværsårsager = new Label("Fraværsårsager");
        pane.add(lblFraværsårsager, 3, 0);

        // add v VBox to the pane
        VBox box = new VBox(5); // v = afstand mellem rbs
        pane.add(box, 3, 1);

        String[] statusString = {"Tilstede", "Fravær", "Syg", "Afbud"};
        DeltagerStatus[] status = {DeltagerStatus.TILSTEDE, DeltagerStatus.FRAVÆR, DeltagerStatus.SYG, DeltagerStatus.AFBUD};
        // tilføjer 4 radiobuttons til vbox
        for (int i = 0; i < status.length; i++) {
            RadioButton rb = new RadioButton();
            box.getChildren().add(rb); // tilføjer rb til Vbox
            rb.setToggleGroup(group);  // ensure that only one radio button is in selected state
            rb.setText(statusString[i]);
            rb.setUserData(status[i]);
        }

        Button btnFravær = new Button("Fravær");
        box.getChildren().add(btnFravær);
        btnFravær.setOnAction(event -> statusÆndring());


    }

    private void selectedFag() {
        Fag fag = lvwFag.getSelectionModel().getSelectedItem();
        if (fag != null && fag.getLektioner() != null) {
            lvwLektion.getItems().setAll(fag.getLektioner());
        }
    }

    private void selectedLektion() {
        Lektion lektion = lvwLektion.getSelectionModel().getSelectedItem();

        if (lektion != null && lektion.getDeltagelser() != null) {
            lvwDeltagelse.getItems().setAll(lektion.getDeltagelser());
        }
    }

    private void statusÆndring() {
        RadioButton rb = (RadioButton) group.getSelectedToggle();

        Deltagelse deltagelse = lvwDeltagelse.getSelectionModel().getSelectedItem();

        if (rb.isSelected() && deltagelse != null) {
            DeltagerStatus deltagerStatus = (DeltagerStatus) rb.getUserData();
            deltagelse.setStatus(deltagerStatus);
            deltagelse.setRegistreret(true);
            lvwDeltagelse.refresh();
        }


    }


}