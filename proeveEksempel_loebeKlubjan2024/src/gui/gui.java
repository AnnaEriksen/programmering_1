package gui;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.stage.Stage;
import application.controller.controller;
import application.model.Medlem;
import application.model.Deltagelse;
import application.model.LøbeGruppe;
import application.model.Træning;

public class gui extends Application {

    public void start(Stage stage) {
        stage.setTitle("Sønderhøj Løbeklub");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane, 800, 500);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
    }

    private ListView<LøbeGruppe> lvwLøbegruppe = new ListView<>();
    private TextArea txaMedlemmer = new TextArea();
    private ListView<Træning> lvwTræninger = new ListView<>();
    private ListView<Medlem> lvwAlleMedlemmer = new ListView<>();
    private ListView<Træning> lvwTilmeldteTræninger = new ListView<>();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblLøbeGruppe = new Label("Løbegrupper");
        pane.add(lblLøbeGruppe, 0, 0);
        pane.add(lvwLøbegruppe, 0, 1, 2, 2);
        lvwLøbegruppe.getItems().setAll(controller.getLøbeGrupper());

        Label lblTræninger = new Label("Træninger");
        pane.add(lblTræninger, 0, 3);
        pane.add(lvwTræninger, 0, 4);
        lvwTræninger.setPrefHeight(300);
        ChangeListener<LøbeGruppe> listener = (ov, oldGroup, newGroup) -> visTræninger();
        lvwLøbegruppe.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblMedlemmer = new Label("Medlemmer");
        pane.add(lblMedlemmer, 1, 3);
        pane.add(txaMedlemmer, 1, 4);
        txaMedlemmer.setPrefWidth(200);
        ChangeListener<LøbeGruppe> listener2 = (ov, oldGroup, newGroup) -> visMedlemmer();
        lvwLøbegruppe.getSelectionModel().selectedItemProperty().addListener(listener2);

        Label lblAlleMedlemmer = new Label("Alle medlemmer");
        pane.add(lblAlleMedlemmer, 2, 0);
        pane.add(lvwAlleMedlemmer, 2, 1);
        lvwAlleMedlemmer.getItems().setAll(controller.getMedlemmer());

        Label lblTilmeldteTræninger = new Label("Tilmeldte træninger");
        pane.add(lblTilmeldteTræninger, 3, 0);
        pane.add(lvwTilmeldteTræninger, 3, 1);
        ChangeListener<Medlem> listener3 = (ov, oldMedlem, newMedlem) -> visTilmeldteTræninger();
        lvwAlleMedlemmer.getSelectionModel().selectedItemProperty().addListener(listener3);

        Button btnTilmeld = new Button("Tilmeld træning");
        pane.add(btnTilmeld, 3, 4);
        btnTilmeld.setOnAction(event -> tilmeld());

        Button btnAflys = new Button("Aflys træning");
        pane.add(btnAflys, 2, 4);
        btnAflys.setOnAction(event -> aflys());
    }


    private void visTræninger() {
        LøbeGruppe løbegruppe = lvwLøbegruppe.getSelectionModel().getSelectedItem();
        if (løbegruppe != null) {
            lvwTræninger.getItems().setAll(løbegruppe.getTræninger());
        } else {
            lvwTræninger.getItems().clear();
        }
    }


    private void visMedlemmer() {
        LøbeGruppe løbegruppe = lvwLøbegruppe.getSelectionModel().getSelectedItem();
        StringBuilder sb = new StringBuilder(); if (løbegruppe != null) {
            for (Medlem m : løbegruppe.getMedlemmer()) {
                sb.append(m.getNavn()).append("\n");
            }
        } txaMedlemmer.setText(sb.toString());
    }

    private void visTilmeldteTræninger() {
        lvwTilmeldteTræninger.getItems().clear();

        Medlem medlem = lvwAlleMedlemmer.getSelectionModel().getSelectedItem();
        if (medlem != null) {
            for (Deltagelse d : medlem.getDeltagelser()) {
                if (d.getTræning() != null) {
                    lvwTilmeldteTræninger.getItems().add(d.getTræning());
                }
            }
        }
    }

    private void tilmeld() {
        Træning træning = lvwTræninger.getSelectionModel().getSelectedItem();
        Medlem medlem = lvwAlleMedlemmer.getSelectionModel().getSelectedItem();

        if (træning != null && medlem != null) {
            medlem.createDeltagelse(false, true, træning);
            visTilmeldteTræninger();
        }
    }

    private void aflys() {
        Træning træning = lvwTræninger.getSelectionModel().getSelectedItem();

        if (træning != null) {
            try {
                controller.aflysTræning(træning);
                visTræninger();
                visTilmeldteTræninger();
            } catch (RuntimeException e) {
                Dialog<String> dialog = new Dialog<>();
                dialog.setTitle("Fejl");
                dialog.setHeaderText("Træningen kan ikke aflyses");
                dialog.setContentText("Træningen er allerede afholdt");
                ButtonType btnOk = new ButtonType("Ok");
                dialog.getDialogPane().getButtonTypes().addAll(btnOk);
                dialog.showAndWait();
            }
        }
    }
}
