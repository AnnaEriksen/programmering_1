package Gui;

import Application.Controller.Controller;
import Application.Model.Konference;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ArrangørWindow extends Stage {

    public ArrangørWindow(String title) {

        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);


    }

    private ListView<Konference> lwlKonferencer;
    private Button btnOpretDeltager;
    private Button btnOpretHotel;
    private Button btnOpretUdflugt;
    private Button btnOpretKonference;
    private TextArea txaListeKig;
    private Button btnSeHotelListe;
    private Button btnSeUdflugtsListe;
    private Button btnSeKonferenceListe;
    private Button btnprintHotel;
    private Button btnprintUdflugt;
    private Button btnprintKonference;


    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblOprettedeKonferencer = new Label("Oprettede konferencer");
        pane.add(lblOprettedeKonferencer, 2, 1);

        Label lblLister = new Label("Oversigtslister");
        pane.add(lblLister, 1, 1);

        btnOpretDeltager = new Button("Opret deltager tilmelding");
        pane.add(btnOpretDeltager, 2, 3);
        btnOpretDeltager.setOnAction(event -> this.opretDeltager());

        btnOpretHotel = new Button("Opret hotel");
        pane.add(btnOpretHotel, 2, 4);

        btnOpretKonference = new Button("Opret konference");
        pane.add(btnOpretKonference, 2, 5);
        btnOpretKonference.setOnAction(event -> this.opretKonference());

        btnOpretUdflugt = new Button("Opret udflugt");
        pane.add(btnOpretUdflugt, 2, 6);


        lwlKonferencer = new ListView<>();
        pane.add(lwlKonferencer, 2, 2);
        lwlKonferencer.setPrefWidth(240);
        lwlKonferencer.setPrefHeight(200);
        lwlKonferencer.getItems().setAll(Controller.getKonferencer());
        lwlKonferencer.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        txaListeKig = new TextArea();
        pane.add(txaListeKig, 1, 2);
        txaListeKig.setEditable(false);

        btnSeHotelListe = new Button("Se liste af hoteller");
        pane.add(btnSeHotelListe, 1, 3);
        GridPane.setHalignment(btnSeHotelListe, HPos.LEFT);
        btnSeHotelListe.setOnAction(event -> seHotel());

        btnprintHotel = new Button("Print");
        pane.add(btnprintHotel, 1, 4);
        GridPane.setHalignment(btnprintHotel, HPos.LEFT);
        btnprintHotel.setOnAction(event -> printHotel());


        btnSeKonferenceListe = new Button("Se liste af konferencer tilmeldinger");
        pane.add(btnSeKonferenceListe, 1, 3);
        GridPane.setHalignment(btnSeKonferenceListe, HPos.CENTER);
        btnSeKonferenceListe.setOnAction(event -> seKonferenceDeltager());

        btnprintKonference = new Button("Print");
        pane.add(btnprintKonference, 1, 4);
        GridPane.setHalignment(btnprintKonference, HPos.CENTER);


        btnSeUdflugtsListe = new Button("Se liste af udflugter");
        pane.add(btnSeUdflugtsListe, 1, 3);
        GridPane.setHalignment(btnSeUdflugtsListe, HPos.RIGHT);
        btnSeUdflugtsListe.setOnAction(event -> seUdflugter());

        btnprintUdflugt = new Button("Print");
        pane.add(btnprintUdflugt, 1, 4);
        GridPane.setHalignment(btnprintUdflugt, HPos.RIGHT);
        btnprintUdflugt.setOnAction(event -> printUdflugt());


    }

    public void opretKonference() {
        OpretKonferenceWindow dia = new OpretKonferenceWindow("Opret ny konference");
        dia.showAndWait();


        int selectIndex = lwlKonferencer.getSelectionModel().getSelectedIndex();
        lwlKonferencer.getItems().setAll(Controller.getKonferencer());
        lwlKonferencer.getSelectionModel().select(selectIndex);


    }

    public void opretDeltager() {
        OpretTilmeldingWindow dia = new OpretTilmeldingWindow("Opret deltager tilmelding");
        dia.showAndWait();

    }

    public void seHotel() {
        Konference selected = lwlKonferencer.getSelectionModel().getSelectedItem();

        txaListeKig.setText(Controller.hotelGæstString(selected));

    }

    public void seKonferenceDeltager() {
        Konference selected = lwlKonferencer.getSelectionModel().getSelectedItem();

        txaListeKig.setText(Controller.konferenceDeltagerStringBuilder(selected));
    }

    public void seUdflugter() {
        Konference selected = lwlKonferencer.getSelectionModel().getSelectedItem();

        txaListeKig.setText(Controller.udflugtGæsterStringBulider(selected));
    }

    public void printHotel() {
        Konference selectedKonference = lwlKonferencer.getSelectionModel().getSelectedItem();
        Controller.hotelgæster(selectedKonference);
    }

    public void printUdflugt() {
        Konference selected = lwlKonferencer.getSelectionModel().getSelectedItem();

        Controller.udflugtGæsterPrint(selected);
    }

}