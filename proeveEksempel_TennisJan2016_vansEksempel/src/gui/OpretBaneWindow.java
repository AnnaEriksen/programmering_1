package gui;

import application.controller.Controller;
import application.model.Bane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OpretBaneWindow extends Stage {
    public OpretBaneWindow(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }


    private final TextField txfNr = new TextField();
    private final TextField txfInfo = new TextField();

    private Bane bane = null;

    private void initContent(GridPane pane) {
        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblNummer = new Label("Nummer:");
        pane.add(lblNummer,0,0);
        pane.add(txfNr,1,0);

        Label lblInfo = new Label("Info:");
        pane.add(lblInfo,0,1);
        pane.add(txfInfo,1,1);

        HBox buttonBox = new HBox(20);  // placerer knapperne horisontalt fra venstre til højre, hvor '20' er afstand i mellem
        pane.add(buttonBox, 0, 3);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.TOP_RIGHT);

        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        buttonBox.getChildren().add(btnOK);
        btnOK.setOnAction(event -> this.okAction());

    }

    // Button actions

    private void cancelAction() {
        txfNr.clear();
        txfInfo.clear();
        bane = null;
       OpretBaneWindow.this.hide();
    }

    private void okAction() {
        String nr = txfNr.getText().trim();
        String info = txfInfo.getText().trim();

        int nrint = Integer.parseInt(nr);

        if (!nr.isEmpty() && !info.isEmpty()) {
            bane = Controller.createBane(nrint, info);
            txfNr.clear();
            txfInfo.clear();
            OpretBaneWindow.this.hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Opret bane");
            alert.setHeaderText("Information mangler");
            alert.setContentText("Indtast bane nummer og baneinfo");
            alert.show();
        }
    }

    public Bane getOprettetBane() {
        return bane;
    }



}
