package gui;

import application.controller.controller;
import application.model.Bane;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;


public class Gui extends Application {

    public void start(Stage stage) {
        stage.setTitle("Booking af tennisbaner");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane, 800, 400);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);

        baneWindow = new OpretBaneWindow("Opret bane", stage);
    }


//    private ListView<> lvw = new ListView<>();
//    private final ToggleGroup group = new ToggleGroup(); // sørger for at kun en btn kan vælges
//    private TextField txf;
//    private TextField txf = new TextField();
//    private CheckBox chk = new CheckBox("");

    private TextField txfDato = new TextField();
    private ListView<Bane> lvwBaner = new ListView<>();
    private ListView<LocalTime> lvwLedigeTider = new ListView<>();

    private OpretBaneWindow baneWindow;

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);


        Label lblDato = new Label("Dato:");
        pane.add(lblDato, 0, 0);
        pane.add(txfDato, 0, 1, 2, 1);
        txfDato.setPromptText("yyyy-MM-dd");

        Label lblBaner = new Label("Baner");
        pane.add(lblBaner, 0, 2);
        pane.add(lvwBaner, 0, 3, 2, 1);
        lvwBaner.getItems().setAll(controller.getBaner());

        Label lblLedigeTider = new Label("Ledige tider");
        pane.add(lblLedigeTider, 3, 0);
        pane.add(lvwLedigeTider, 3, 1, 2, 3);
        // viser en banes ledige tider
        ChangeListener<Bane> listener = (ov, oldBane, newBane) -> selectedBane();
        lvwBaner.getSelectionModel().selectedItemProperty().addListener(listener);

        Button btnOpretBane = new Button("Opret bane");
        pane.add(btnOpretBane, 0, 4);
        btnOpretBane.setOnAction(event -> opretBane());

    }

    private void selectedBane() {
        Bane bane = lvwBaner.getSelectionModel().getSelectedItem();
        String dato = txfDato.getText().trim();

        if (bane != null && bane.getLedigeTiderPaaDag(LocalDate.parse(dato)) != null) {
            lvwLedigeTider.getItems().setAll(bane.getLedigeTiderPaaDag(LocalDate.parse(dato)));
        }

    }

    private void opretBane() {
        baneWindow.showAndWait();
        lvwBaner.getItems().add(baneWindow.getOprettetBane()); // tilføjer til listview
        lvwBaner.refresh();

    }


}