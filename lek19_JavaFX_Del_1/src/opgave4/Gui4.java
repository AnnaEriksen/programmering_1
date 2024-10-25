package opgave4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static java.lang.Integer.parseInt;

public class Gui4 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Gui Demo 4");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final Label label = new Label("Number: ");
    private final TextField tal = new TextField("50");


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
        pane.add(tal, 1, 2);
        pane.add(label, 0, 2);

        // add a button to the pane (at col=1, row=1)
        Button plus = new Button("+");
        Button minus = new Button("-");

        pane.add(plus, 3, 1);
        GridPane.setMargin(plus, new Insets(10, 10, 0, 10));
        pane.add(minus, 3, 3);
        GridPane.setMargin(minus, new Insets(10, 10, 0, 10));

        // connect a method to the button
        plus.setOnAction(event -> plus());
        minus.setOnAction(event -> minus());

        // add a button to the pane (at col=2, row=1)

        // connect a method to the button
    }

    // -------------------------------------------------------------------------

    private void plus() {

        //konverterer en streng til en int:
        String tekst1 = tal.getText().trim();
        int temp = parseInt(tekst1);
        String s = String.valueOf(temp+1);
        tal.setText(s);
    }

    private void minus(){
        String tekst1 = tal.getText().trim();
        int temp = parseInt(tekst1);
        String s = String.valueOf(temp-1);
        tal.setText(s);

    }

}
