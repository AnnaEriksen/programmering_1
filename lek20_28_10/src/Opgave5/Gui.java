package Opgave5;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("ListView Demo4");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> personsBoy = new ArrayList<>();
    private final ArrayList<Person> personsGirl = new ArrayList<>();
    private final ToggleGroup group = new ToggleGroup();


    private void initContent(GridPane pane) {
        this.initPersons();

        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 3);

        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 1);
        GridPane.setValignment(lblNames, VPos.TOP);

        pane.add(txfName, 1, 3);

        pane.add(lvwPersons, 1, 1);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(personsBoy);

        HBox box = new HBox();
        pane.add(box, 0, 0);

        String[] gender = { "Boy", "Girl" };

        // add 4 radio buttons to the box
        for (int i = 0; i < gender.length; i++) {
            RadioButton rb = new RadioButton();
            box.getChildren().add(rb);
            rb.setText(gender[i]);
            rb.setUserData(gender[i]);
            rb.setToggleGroup(group);
            // set the method to execute when a radio button is selected
            rb.setOnAction(event -> this.toggleGender());
        }

        ChangeListener<Person> listener = (ov, o, n) -> this.personsItemSelected();
        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 2, 3);
        btnAdd.setOnAction(event -> this.addAction());

        RadioButton rb0 = (RadioButton) group.getToggles().get(0);
        rb0.setSelected(true);

        Button btnDelete = new Button("Delete");
        pane.add(btnDelete, 2, 4);
        btnDelete.setOnAction(event -> this.deleteAction());
    }

    // -------------------------------------------------------------------------
    private void toggleGender(){
            RadioButton rb = (RadioButton) group.getSelectedToggle();
            String string = (String) rb.getUserData();
            if (string.equals("Boy")){
                lvwPersons.getItems().setAll(personsBoy);
            } else {
                lvwPersons.getItems().setAll(personsGirl);
            }
    }
    private void initPersons() {
        personsBoy.add(new Person("Jens"));
        personsBoy.add(new Person("Hans"));
        personsBoy.add(new Person("Bo"));
        personsBoy.add(new Person("Børge"));
        personsBoy.add(new Person("Lars"));
        personsBoy.add(new Person("Emil"));
        personsBoy.add(new Person("Troels"));

        personsGirl.add(new Person("Søs"));
    }

    // -------------------------------------------------------------------------
    // Selected item changed in lvwPersons

    private void personsItemSelected() {
        Person selected = lvwPersons.getSelectionModel().getSelectedItem();
        if (selected != null) {
            txfName.setText(selected.toString());
        } else {
            txfName.clear();
        }
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {
        RadioButton rb = (RadioButton) group.getSelectedToggle();
        String gender = (String) rb.getUserData();
        String name = txfName.getText().trim();
        if(name.length() > 0) {
            if (gender.equals("Boy")) {
                txfName.clear();
                Person boy = new Person(name);
                personsBoy.add(boy);
                lvwPersons.getItems().setAll(personsBoy);
            } else {
                txfName.clear();
                Person girl = new Person(name);
                personsGirl.add(girl);
                lvwPersons.getItems().setAll(personsGirl);
            }
        }
    }
// ---------------------------------------------------------------------------------------------------------------------
    private void deleteAction() {
        int index = lvwPersons.getSelectionModel().getSelectedIndex();
        RadioButton rb = (RadioButton) group.getSelectedToggle();
        String gender = (String) rb.getUserData();
        String name = txfName.getText().trim();
        if (index >= 0) {
            if(gender.equals("Boy")) {
                personsBoy.remove(index);
                txfName.clear();
                lvwPersons.getItems().setAll(personsBoy);
            } else{
                personsGirl.remove(index);
                txfName.clear();
                lvwPersons.getItems().setAll(personsGirl);
            }
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Delete person");
            alert.setHeaderText("No person selected");
            alert.setContentText("Select a person to be deleted");
            alert.show();
        }
    }
}
