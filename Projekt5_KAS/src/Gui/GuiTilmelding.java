package Gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiTilmelding extends Application {
    public void start(Stage stage) {
        stage.setTitle("Teaterforestilling");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(100);
        pane.setVgap(100);

        Label lblErdu = new Label("Er du kunde eller deltager?");
        pane.add(lblErdu,1,0);


        Button btnOpretDeltager = new Button("Deltager ");
        pane.add(btnOpretDeltager,0,1);
        btnOpretDeltager.setOnAction(event -> this.opretDeltagerWindow());



        Button btnOpretArrangør = new Button("Arrangør ");
        pane.add(btnOpretArrangør,2,1);
        btnOpretArrangør.setOnAction(event -> this.opretArrangørWindow());


    }

    private void opretDeltagerWindow() {
        OpretTilmeldingWindow dia = new OpretTilmeldingWindow("Opret tilmelding");

        dia.showAndWait();

    }

    private void opretArrangørWindow() {
        ArrangørWindow dia = new ArrangørWindow("Opret arrangør tilmelding");
        dia.showAndWait();

    }

}
