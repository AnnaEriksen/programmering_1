package Opgave3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {

  
    @Override
    public void start(Stage stage) {
        stage.setTitle("Add person opgave 3");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        personWindow = new PersonWindow("Add person", stage);
    }

    // -------------------------------------------------------------------------

    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();
    private PersonWindow personWindow;


    private void initContent(GridPane pane) {
        //this.initPersons();

        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);


        // add a listView to the pane(at col=1, row=0)
        pane.add(lvwPersons, 1, 1, 1, 5);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);

        Button btnAdd = new Button("Add person");
        pane.add(btnAdd, 3,3 );

        // connect a method to the button
        btnAdd.setOnAction(event -> this.createPersonAction());
//----------------------------------------------------------------------------------------------------------------------
    }
    private void createPersonAction() {
        personWindow.showAndWait();

        // wait for the dialog to close ...

        if (personWindow.getActualPerson() != null) {
            Person person = personWindow.getActualPerson();
            persons.add(person);
            lvwPersons.getItems().setAll(persons);;
        }
    }
}
