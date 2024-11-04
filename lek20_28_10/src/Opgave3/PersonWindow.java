package Opgave3;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonWindow extends Stage {
    public PersonWindow(String title, Stage owner) {
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

    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final CheckBox checkBox = new CheckBox();
    private Person actualPerson = null;

    private void initContent(GridPane pane) {
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

        Button btnAdd = new Button("Ok");
        pane.add(btnAdd, 1, 4);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());

        Button btnAdd1 = new Button("Cancel");
        pane.add(btnAdd1, 2, 4);

        // connect a method to the button
        btnAdd1.setOnAction(event -> this.cancelAction());

    }

    private void addAction() {
        String name = txfName.getText().trim();
        String title = txfTitle.getText().trim();
        Boolean senior = checkBox.isSelected();
        if (name.length() > 0 && title.length() > 0) {
            actualPerson = new Person(name, title, senior);
            txfName.clear();
            txfTitle.clear();
            txfName.requestFocus();
            PersonWindow.this.hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Add Person");
            alert.setHeaderText("Information missing");
            alert.setContentText("Type Name and title");
            alert.show();
        }

    }

    private void cancelAction() {
        txfTitle.clear();

        //betyder hvor cursoren skal stå
        txfTitle.requestFocus();
        txfName.clear();
        actualPerson = null;
        PersonWindow.this.hide();
    }

    public Person getActualPerson() {
        return actualPerson;
    }
}
