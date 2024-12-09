package Gui;

import Application.Controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.time.LocalDate;

public class OpretKonferenceWindow extends Stage {

    public OpretKonferenceWindow(String title) {

        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);


    }

    private TextField txfnavn;
    private TextField txfStartDato;
    private TextField txfSlutDato;
    private TextField txfSted;
    private TextField txfKonferenceAfgift;
    private TextField txfFordragsholder;
    private Button btnOpretKonfernece;


    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblInformationer = new Label("Informationer");
        pane.add(lblInformationer, 0, 0);

        Label lblName = new Label("Navn");
        pane.add(lblName, 0, 1);

        txfnavn = new TextField();
        pane.add(txfnavn, 1, 1);

        Label lblStartDato = new Label("Start dato");
        pane.add(lblStartDato, 0, 2);

        txfStartDato = new TextField();
        pane.add(txfStartDato, 1, 2);


        Label lblSlutDato = new Label("Slut dato");
        pane.add(lblSlutDato, 0, 3);
        txfSlutDato = new TextField();
        pane.add(txfSlutDato, 1, 3);

        Label lblSted = new Label("Sted");
        pane.add(lblSted, 0, 4);
        txfSted = new TextField();
        pane.add(txfSted, 1, 4);

        Label lblKonferenceAfgift = new Label("Konference afgift");
        pane.add(lblKonferenceAfgift, 0, 5);
        txfKonferenceAfgift = new TextField();
        pane.add(txfKonferenceAfgift, 1, 5);

        btnOpretKonfernece = new Button("Opret konference");
        pane.add(btnOpretKonfernece, 0, 6);
        btnOpretKonfernece.setOnAction(event -> this.opretAction());

    }

    public void opretAction() {
        String navn = txfnavn.getText().trim();
        String startDato = txfStartDato.getText().trim();
        String slutDato = txfSlutDato.getText().trim();
        String sted = txfSted.getText().trim();
        int konferenceAfgift = Integer.parseInt(txfKonferenceAfgift.getText().trim());


        if (!navn.isEmpty() && !sted.isEmpty()) {
            LocalDate sD = LocalDate.parse(startDato);
            LocalDate slD = LocalDate.parse(slutDato);
            Controller.createKonference(navn, sD, slD, sted, konferenceAfgift);
            hide();

        }
    }


}
