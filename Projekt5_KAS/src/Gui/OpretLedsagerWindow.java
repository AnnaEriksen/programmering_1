package Gui;


import Application.Controller.Controller;
import Application.Model.Ledsager;
import Application.Model.Tildmelding;
import Application.Model.Udflugt;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;


public class OpretLedsagerWindow extends Stage {
    public OpretLedsagerWindow(String title) {

        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);
        this.setTitle(title);

        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);


    }

    private static TextField txfLedsagerNavn;
    private TextField txfLedsagerTlf;
    private static ListView<Udflugt> lwlUdflugter;
    private Button btnFortsæt;


    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);


        Label lblLedsagerInfo = new Label("Ledsager information");
        pane.add(lblLedsagerInfo, 0, 0);

        Label lblLedsagerNavn = new Label("Ledsager navn");
        pane.add(lblLedsagerNavn, 0, 1);

        txfLedsagerNavn = new TextField();
        pane.add(txfLedsagerNavn, 1, 1);

        Label lblLedsagerTlf = new Label("Ledsager tlf");
        pane.add(lblLedsagerTlf, 0, 2);

        txfLedsagerTlf = new TextField();
        pane.add(txfLedsagerTlf, 1, 2);

        Label LblUdlflugt = new Label("Vælg udflugt/udflugter");
        pane.add(LblUdlflugt, 1, 3);
        GridPane.setHalignment(LblUdlflugt, HPos.CENTER);

        lwlUdflugter = new ListView<>();
        pane.add(lwlUdflugter, 1, 4);
        lwlUdflugter.setPrefWidth(200);
        lwlUdflugter.setPrefHeight(150);
        lwlUdflugter.getItems().setAll(Controller.getUdflugter());
        lwlUdflugter.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        btnFortsæt = new Button("Fortsæt");
        pane.add(btnFortsæt, 1, 5);
        btnFortsæt.setOnAction(event -> {
            this.close();
        });
    }

    public static String opretLedsagernavn(Tildmelding tildmelding) {
        String ledsagerNavn = txfLedsagerNavn.getText();
        Controller.createLedsager(tildmelding, ledsagerNavn);


        return ledsagerNavn;
    }

    public static ArrayList<Udflugt> opretLedsagerUdflugter(Tildmelding tildmelding) {
        ArrayList<Udflugt> valgteUdflugter = new ArrayList<>(lwlUdflugter.getSelectionModel().getSelectedItems());

        for (int i = 0; i < valgteUdflugter.size(); i++) {
            Controller.addUdflugt(tildmelding, valgteUdflugter.get(i));
        }

        return valgteUdflugter;

    }


}
