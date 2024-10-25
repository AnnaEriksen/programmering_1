package Opgave5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Konverter temp opg.5");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txCelsius = new TextField();
    private final TextField txFahrenheit = new TextField();

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
        Label lblCel = new Label("Celsius:");
        pane.add(lblCel, 0, 0);

        Label lblFar = new Label("Fahrenheit:");
        pane.add(lblFar, 0, 1);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
        // Deleted here is:
        // TextField txfName = new TextField();
        pane.add(txCelsius, 1, 0, 1, 1);
        pane.add(txFahrenheit, 1, 1, 1, 1);

        // add a button to the pane (at col=1, row=1)
        Button btnCelsius = new Button("Convert to °C");
        pane.add(btnCelsius, 2,1 );
        GridPane.setMargin(btnCelsius, new Insets(10, 10, 10, 10));

        // connect a method to the button
        btnCelsius.setOnAction(event -> convertToCelsius());

        // add a button to the pane (at col=2, row=1)
        Button btnFar = new Button("Convert to °F");
        pane.add(btnFar, 2, 0);
        GridPane.setMargin(btnFar, new Insets(10, 10, 10, 10));

        // connect a method to the button
        btnFar.setOnAction(event -> this.convertToFahrenheit());
    }

    // -------------------------------------------------------------------------

    private void convertToCelsius() {
        double tal = Double.parseDouble(txFahrenheit.getText());
        txCelsius.setText((tal - 32)/1.8 + "");
    }

    private void convertToFahrenheit() {
            double tal = Double.parseDouble(txCelsius.getText());
            txFahrenheit.setText((tal * 1.8) + 32 + "");
    }
}
