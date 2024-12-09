package Gui;

import Application.Controller.Controller;
import Application.Model.*;
import com.sun.source.tree.ConstantCaseLabelTree;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;


public class DeltagerBekræftelsesWindow extends Stage {
    public DeltagerBekræftelsesWindow(String title) {

        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);


    }

    private TextField txfDeltagerNavn;
    private TextField txfAdresse;
    private TextField txfBy;
    private TextField txfLand;
    private TextField txfAnkomstDato;
    private TextField txfAfrejseDato;
    private TextField txfFirmaNavn;
    private TextField txfTlfNr;
    private TextField txfFirmaTlf;
    private TextField txfLedsagerNavn;
    private TextArea txaHotel;
    private TextArea txaKonference;
    private TextArea txaUdflugt;
    private TextField txfSamletPris;
    private Button btnBekræft;
    private CheckBox chbLedsager1 = new CheckBox("Ja");
    private CheckBox chbLedsager2 = new CheckBox("Nej");


    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblInformationer = new Label("Dine valg/informationer");
        pane.add(lblInformationer, 0, 0);

        Label lblName = new Label("Navn");
        pane.add(lblName, 0, 1);


        txfDeltagerNavn = new TextField();
        pane.add(txfDeltagerNavn, 1, 1);
        txfDeltagerNavn.setFocusTraversable(false);
        txfDeltagerNavn.setEditable(false);

        Label lblAdresse = new Label("Adresse");
        pane.add(lblAdresse, 0, 2);

        txfAdresse = new TextField();
        pane.add(txfAdresse, 1, 2);
        txfAdresse.setFocusTraversable(false);
        txfAdresse.setEditable(false);

        Label lblTlfNr = new Label("Eventuelt firma tlf.");
        pane.add(lblTlfNr, 0, 3);

        txfTlfNr = new TextField();
        pane.add(txfTlfNr, 1, 3);
        txfTlfNr.setFocusTraversable(false);
        txfTlfNr.setEditable(false);


        Label lblBy = new Label("By");
        pane.add(lblBy, 0, 4);

        txfBy = new TextField();
        pane.add(txfBy, 1, 4);
        txfBy.setFocusTraversable(false);
        txfBy.setEditable(false);

        Label lblLand = new Label("Land");
        pane.add(lblLand, 0, 5);

        txfLand = new TextField();
        pane.add(txfLand, 1, 5);
        txfLand.setFocusTraversable(false);
        txfLand.setEditable(false);


        Label lblAnkomstsDato = new Label("Ankomst dato");
        pane.add(lblAnkomstsDato, 0, 6);

        txfAnkomstDato = new TextField();
        pane.add(txfAnkomstDato, 1, 6);
        txfAnkomstDato.setFocusTraversable(false);
        txfAnkomstDato.setEditable(false);


        Label lblafrejseDato = new Label("Afrejse dato");
        pane.add(lblafrejseDato, 0, 7);

        txfAfrejseDato = new TextField();
        pane.add(txfAfrejseDato, 1, 7);
        txfAfrejseDato.setFocusTraversable(false);
        txfAfrejseDato.setEditable(false);


        Label lblFirmaNavn = new Label("Eventuelt firmanavn");
        pane.add(lblFirmaNavn, 0, 8);

        txfFirmaNavn = new TextField();
        pane.add(txfFirmaNavn, 1, 8);
        txfFirmaNavn.setFocusTraversable(false);
        txfFirmaNavn.setEditable(false);

        Label lblFirmaTlf = new Label("Eventuelt firma tlf.");
        pane.add(lblFirmaTlf, 0, 9);

        txfFirmaTlf = new TextField();
        pane.add(txfFirmaTlf, 1, 9);
        txfFirmaTlf.setFocusTraversable(false);
        txfFirmaTlf.setEditable(false);


        Label lblLedsager = new Label("Ledsager?");
        pane.add(lblLedsager, 0, 10);

        chbLedsager1 = new CheckBox("Ja");
        pane.add(chbLedsager1, 1, 10);
        GridPane.setHalignment(chbLedsager1, HPos.LEFT);


        chbLedsager2 = new CheckBox("nej");
        pane.add(chbLedsager2, 1, 10);
        GridPane.setHalignment(chbLedsager2, HPos.CENTER);

        Label lblLedsagerNavn = new Label("Ledsager navn");
        pane.add(lblLedsagerNavn, 0, 11);

        txfLedsagerNavn = new TextField();
        pane.add(txfLedsagerNavn, 1, 11);
        txfLedsagerNavn.setFocusTraversable(false);
        txfLedsagerNavn.setEditable(false);

        Label lblKonference = new Label("Valgt konference");
        pane.add(lblKonference, 4, 0);

        txaKonference = new TextArea();
        pane.add(txaKonference, 4, 1);
        txaKonference.setFocusTraversable(false);
        txaKonference.setPrefRowCount(4);
        txaKonference.setEditable(false);


        Label lblHotel = new Label("Valgt hotel + eventuelle tilvalg");
        pane.add(lblHotel, 4, 2);

        txaHotel = new TextArea();
        pane.add(txaHotel, 4, 3);
        txaHotel.setFocusTraversable(false);
        txaHotel.setPrefRowCount(4);
        txaHotel.setEditable(false);


        Label lbludflugt = new Label("Valgte udflugt/udflugter");
        pane.add(lbludflugt, 4, 4);

        txaUdflugt = new TextArea();
        pane.add(txaUdflugt, 4, 5);
        txaUdflugt.setFocusTraversable(false);
        txaUdflugt.setPrefRowCount(4);
        txaUdflugt.setEditable(false);


        Label lblSamlerPris = new Label("Samlet pris");
        pane.add(lblSamlerPris, 4, 8);
        GridPane.setHalignment(lblSamlerPris, HPos.CENTER);

        txfSamletPris = new TextField();
        pane.add(txfSamletPris, 4, 9);
        txfSamletPris.setFocusTraversable(false);
        txfSamletPris.setEditable(false);


        btnBekræft = new Button("Bekræft tilmelding");
        pane.add(btnBekræft, 4, 11);
        GridPane.setHalignment(btnBekræft, HPos.CENTER);
        btnBekræft.setOnAction(event -> setAction());

    }


    public void setDeltagerInfo(String deltagerNavn, String adresse, String by, String land, String ankomstDato, String afrejseDato, String firmaNavn, String tlfNr, String firmaTlf) {
        txfDeltagerNavn.setText(deltagerNavn);
        txfAdresse.setText(adresse);
        txfBy.setText(by);
        txfLand.setText(land);
        txfAnkomstDato.setText(ankomstDato);
        txfAfrejseDato.setText(afrejseDato);
        txfFirmaNavn.setText(firmaNavn);
        txfTlfNr.setText(tlfNr);
        txfFirmaTlf.setText(firmaTlf);

    }

    public void setAndreInfo(String selectedHotel, String selectedKonference, String selectedTilæg, Tildmelding tilmeding) {
        txaHotel.setText(selectedHotel + "\n" + selectedTilæg);
        txaKonference.setText(selectedKonference);

        txfSamletPris.setText(Controller.getSamletPris(tilmeding) + "");

        Ledsager l = Controller.createLedsager(tilmeding, txfLedsagerNavn.getText());

    }

    public void setUdflugter(ArrayList<Udflugt> valgteUdflugter) {
        txaUdflugt.setText(String.valueOf(valgteUdflugter));

    }

    public void setLedsagerNavn(String ledsagerNavn) {
        txfLedsagerNavn.setText(ledsagerNavn);

    }


    public void setAction() {
        this.close();
    }

}
