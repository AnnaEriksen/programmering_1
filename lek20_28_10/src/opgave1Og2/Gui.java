package opgave1Og2;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {

  
    @Override
    public void start(Stage stage) {
        stage.setTitle("Add person opgave 2");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<opgave1Og2.Person> lvwPersons = new ListView<>();
    private final ArrayList<opgave1Og2.Person> persons = new ArrayList<>();
    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final CheckBox checkBox = new CheckBox();

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

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        Label lblNames = new Label("Title:");
        pane.add(lblNames, 0, 1);


        pane.add(txfName, 1, 0, 2, 1);
        pane.add(txfTitle, 1, 1, 2, 1);

        checkBox.setText("Senior");
        pane.add(checkBox, 1, 3);

        // add a listView to the pane(at col=1, row=0)
        pane.add(lvwPersons, 1, 4, 1, 5);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);

        ChangeListener<opgave1Og2.Person> listener = (ov, oldPerson, newPerson) -> this.selectionChanged();
        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwPersons.getSelectionModel().clearSelection();

        Button btnAdd = new Button("Add Person");
        pane.add(btnAdd, 6, 3);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());

    }

    // -------------------------------------------------------------------------

    // Button actions
    private void addAction() {
        String name = txfName.getText().trim();
        String title = txfTitle.getText().trim();
        Boolean senior = checkBox.isSelected();
        if (name.length() > 0 && title.length() > 0) {
            opgave1Og2.Person p = new opgave1Og2.Person(name,title,senior);
            persons.add(p);
            lvwPersons.getItems().setAll(persons);

            //opgave 2, lav en fejlbesked
        } else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Add Person");
            alert.setHeaderText("Information missing");
            alert.setContentText("Type Name and title");
            alert.show();
        }
    }

    // -------------------------------------------------------------------------
    // Selection changed action

    private void selectionChanged() {
        opgave1Og2.Person newPerson = lvwPersons.getSelectionModel().getSelectedItem();
        if (newPerson != null) {
            txfName.setText(newPerson.getName());
        } else {
            txfName.clear();
        }
    }
}
