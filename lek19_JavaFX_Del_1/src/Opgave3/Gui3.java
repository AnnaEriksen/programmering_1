package Opgave3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui3 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Gui Demo 3");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextField txfName2 = new TextField();
    private final TextArea split = new TextArea();


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
        pane.add(txfName, 0, 1, 1, 1);
        pane.add(txfName2, 1, 1, 1, 1);
        pane.add(split, 0, 0,2,1);
        split.setPrefRowCount(1);
        split.setPrefWidth(1);
        split.setEditable(true);

        // add a button to the pane (at col=1, row=1)
        Button split1 = new Button("Split");
        pane.add(split1, 0, 2);
        GridPane.setMargin(split1, new Insets(10, 10, 0, 10));

        // connect a method to the button
        split1.setOnAction(event -> split());

        // add a button to the pane (at col=2, row=1)

        // connect a method to the button
    }

    // -------------------------------------------------------------------------
    private void split() {
        String text3 = split.getText().trim();

        // Find index for første blanktegn
        int spaceIndex = text3.indexOf(' ');

        // Hvis der er et blanktegn, opdeler vi teksten i to dele
        if (spaceIndex != -1) {
            String text1 = text3.substring(0, spaceIndex);  // Første del af teksten
            String text2 = text3.substring(spaceIndex + 1); // Resten af teksten

            // Sæt de to dele i tekstfelterne
            txfName.setText(text1);
            txfName2.setText(text2);
        } else {
            // Hvis der ikke er noget blanktegn, sættes hele teksten i text1
            txfName.setText(text3);
            txfName2.clear(); // Rens text2 feltet
        }

        System.out.println(txfName.getText() + " " + txfName2.getText());
    }
    }
