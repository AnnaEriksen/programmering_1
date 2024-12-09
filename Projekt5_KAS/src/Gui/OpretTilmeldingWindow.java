package Gui;

import Application.Controller.Controller;
import Application.Model.*;
import com.sun.source.tree.IfTree;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;

public class OpretTilmeldingWindow extends Stage {
    public OpretTilmeldingWindow(String title) {

        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);
        this.setTitle(title);

        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);


    }

    private static TextField txfDeltagerNavn;
    private static TextField txfAdresse;
    private static TextField txfBy;
    private static TextField txfLand;
    private static TextField txfAnkomstDato;
    private static TextField txfAfrejseDato;
    private static TextField txfFirmaNavn;
    private static TextField txfTlfNr;
    private static TextField txfFirmaTlf;


    private static CheckBox chbLedsager1 = new CheckBox("Ja");
    private static CheckBox chbLedsager2 = new CheckBox("nej");

    private static CheckBox chbFordrag2 = new CheckBox("nej");
    private static CheckBox chbFordrag1 = new CheckBox("Ja");

    private static ListView<Hotel> lwlHoteller;
    private static ListView<Tilæg> lwlTilægListe;
    private static ListView<Konference> lwlkonferencer;

    private Button btnOpretTilmelding;


    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);


        Label lblInformationer = new Label("Deltager informationer");
        pane.add(lblInformationer, 0, 0);

        Label lblName = new Label("Navn");
        pane.add(lblName, 0, 1);

        txfDeltagerNavn = new TextField();
        pane.add(txfDeltagerNavn, 1, 1);

        Label lblAdresse = new Label("Adresse");
        pane.add(lblAdresse, 0, 2);

        txfAdresse = new TextField();
        pane.add(txfAdresse, 1, 2);


        Label lblBy = new Label("By");
        pane.add(lblBy, 0, 3);
        txfBy = new TextField();
        pane.add(txfBy, 1, 3);

        Label lblLand = new Label("Land");
        pane.add(lblLand, 0, 4);
        txfLand = new TextField();
        pane.add(txfLand, 1, 4);


        Label lblAnkomstsDato = new Label("Ankomst dato");
        pane.add(lblAnkomstsDato, 0, 5);

        txfAnkomstDato = new TextField();
        pane.add(txfAnkomstDato, 1, 5);


        Label lblFirmaNavn = new Label("Eventuelt firmanavn");
        pane.add(lblFirmaNavn, 0, 6);
        txfFirmaNavn = new TextField();
        pane.add(txfFirmaNavn, 1, 6);

        Label lblLedsager = new Label("Ledsager?");
        pane.add(lblLedsager, 0, 7);

        chbLedsager1 = new CheckBox("Ja");
        pane.add(chbLedsager1, 1, 7);
        GridPane.setHalignment(chbLedsager1, HPos.LEFT);
        chbLedsager1.setFocusTraversable(false);


        chbLedsager2 = new CheckBox("nej");
        pane.add(chbLedsager2, 1, 7);
        GridPane.setHalignment(chbLedsager2, HPos.CENTER);
        chbLedsager2.setFocusTraversable(false);


        Label lblFordrag = new Label("Fordragsholder?");
        pane.add(lblFordrag, 2, 1);


        pane.add(chbFordrag1, 3, 1);
        GridPane.setHalignment(chbFordrag1, HPos.LEFT);
        chbFordrag1.setFocusTraversable(false);


        pane.add(chbFordrag2, 3, 1);
        GridPane.setHalignment(chbFordrag2, HPos.CENTER);
        chbFordrag2.setFocusTraversable(false);


        Label lblTlfNr = new Label("Tlf. nr");
        pane.add(lblTlfNr, 2, 2);

        txfTlfNr = new TextField();
        pane.add(txfTlfNr, 3, 2);

        Label lblAfrejseDato = new Label("Afrejse dato");
        pane.add(lblAfrejseDato, 2, 3);

        txfAfrejseDato = new TextField();
        pane.add(txfAfrejseDato, 3, 3);

        Label lblFirmaTlf = new Label("Eventuel firma tlf.");
        pane.add(lblFirmaTlf, 2, 4);


        txfFirmaTlf = new TextField();
        pane.add(txfFirmaTlf, 3, 4);


        Label lblKonference = new Label("Valg af konference");
        pane.add(lblKonference, 4, 1);

        lwlkonferencer = new ListView<>();
        pane.add(lwlkonferencer, 4, 2);
        lwlkonferencer.setPrefWidth(200);
        lwlkonferencer.setPrefHeight(150);
        lwlkonferencer.getItems().setAll(Controller.getKonferencer());
        lwlkonferencer.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        GridPane.setColumnSpan(lwlkonferencer, 3);


        Label lblHotel = new Label("Valg af hotel");
        pane.add(lblHotel, 4, 3);

        lwlHoteller = new ListView<>();
        pane.add(lwlHoteller, 4, 4);
        lwlHoteller.setPrefWidth(200);
        lwlHoteller.setPrefHeight(150);
        lwlHoteller.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lwlkonferencer.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            konferenceSelection();
        });


        GridPane.setColumnSpan(lwlHoteller, 3);


        Label lblTilæg = new Label("Tilæg tilvalg");
        pane.add(lblTilæg, 4, 5);


        lwlTilægListe = new ListView<>();
        pane.add(lwlTilægListe, 4, 6);
        lwlTilægListe.setPrefWidth(200);
        lwlTilægListe.setPrefHeight(150);
        lwlTilægListe.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lwlHoteller.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            tillægsSelection();
            ;
        });
        GridPane.setColumnSpan(lwlTilægListe, 3);


        Button btnOpretTilmelding = new Button("Fortsæt");
        pane.add(btnOpretTilmelding, 4, 7);
        btnOpretTilmelding.setOnAction(event -> {
            if (chbLedsager1.isSelected()) {
                opretLedsager();
            }
            opretInfo();
            this.close();
        });
    }

    public void opretLedsager() {
        if (chbLedsager1.isSelected()) {
            OpretLedsagerWindow dia = new OpretLedsagerWindow("Opret Ledsager");

            dia.showAndWait();
            close();
        }
    }

    public static void opretInfo() {
        String deltagerNavn = txfDeltagerNavn.getText();
        String adresse = txfAdresse.getText();
        String by = txfBy.getText();
        String land = txfLand.getText();
        String tlf = txfTlfNr.getText();

        String ankomstDato = txfAnkomstDato.getText();
        String afrejseDato = txfAfrejseDato.getText();
        String firmaNavn = txfFirmaNavn.getText();
        String tlfNr = txfTlfNr.getText();
        String firmaTlf = txfFirmaTlf.getText();
        Konference selectedKonference = lwlkonferencer.getSelectionModel().getSelectedItem();
        Hotel selectedHotel = lwlHoteller.getSelectionModel().getSelectedItem();
        Tilæg selectedTilæg = lwlTilægListe.getSelectionModel().getSelectedItem();


        DeltagerBekræftelsesWindow dia = new DeltagerBekræftelsesWindow("Bekræft deltager");
        dia.setDeltagerInfo(deltagerNavn, adresse, by, land, ankomstDato, afrejseDato, firmaNavn, tlfNr, firmaTlf);


        Deltager deltager = Controller.createDeltager(deltagerNavn, adresse, land, by, tlfNr);

        boolean fordrasholder;

        if (chbFordrag1.isSelected()) {
            fordrasholder = true;
        } else fordrasholder = false;
        //


        Tildmelding tildmelding = Controller.createTildmelding(fordrasholder, LocalDate.parse(txfAnkomstDato.getText()), LocalDate.parse(txfAfrejseDato.getText()), selectedKonference, selectedHotel, deltager);

        if (chbLedsager1.isSelected()) {
            dia.setLedsagerNavn(OpretLedsagerWindow.opretLedsagernavn(tildmelding));
        }
        dia.show();

        if (chbLedsager1.isSelected()) {
            dia.setUdflugter(OpretLedsagerWindow.opretLedsagerUdflugter(tildmelding));
        }

        if (selectedTilæg == null) {
            dia.setAndreInfo(String.valueOf(selectedHotel), String.valueOf(selectedKonference), String.valueOf(selectedTilæg), tildmelding);
        } else {
            Controller.addTillæg(tildmelding, selectedTilæg);
            dia.setAndreInfo(String.valueOf(selectedHotel), String.valueOf(selectedKonference), String.valueOf(selectedTilæg), tildmelding);
        }

    }

    public void tillægsSelection() {
        Hotel selected =
                lwlHoteller.getSelectionModel().getSelectedItem();
        if (selected != null) {
            lwlTilægListe.getItems().setAll(Controller.getTilægsListe(selected));

        } else {
            lwlTilægListe.getItems().clear();
        }
    }

    public void konferenceSelection() {
        Konference selected =
                lwlkonferencer.getSelectionModel().getSelectedItem();
        if (selected != null) {
            lwlHoteller.getItems().setAll(Controller.getHoteller(selected));

        } else {
            lwlHoteller.getItems().clear();
        }
    }
}
