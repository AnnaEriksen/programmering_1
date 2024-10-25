package Opgave2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui2 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Gui Demo 2");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextField txfName2 = new TextField();


    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
        // Deleted here is:
        // TextField txfName = new TextField();
        pane.add(txfName, 0, 0);
        pane.add(txfName2, 0, 1);


        // add a button to the pane (at col=1, row=1)
        Button ombyt = new Button("Ombyt");
        pane.add(ombyt, 0, 2);
        GridPane.setMargin(ombyt, new Insets(10, 10, 0, 10));

        // connect a method to the button
        ombyt.setOnAction(event -> swap());

        // add a button to the pane (at col=2, row=1)

        // connect a method to the button
    }

    // -------------------------------------------------------------------------

    private void swap() {
        String tekst1 = txfName.getText().trim();
        String tekst2 = txfName2.getText().trim();

        //dette bytter rundt på de to tekster
        txfName.setText(tekst2);
        txfName2.setText(tekst1);



    }

}
