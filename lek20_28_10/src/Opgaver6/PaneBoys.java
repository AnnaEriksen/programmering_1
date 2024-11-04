package Opgaver6;

import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class PaneBoys extends GridPane {
    private final ListView<String> lvwNames = new ListView<>();
    private final ArrayList<String> namesBoys = new ArrayList<>();

    public PaneBoys(){
        setGridLinesVisible(false);
        initBoys();

        // set padding of the pane
        setPadding(new Insets(20));
        // set horizontal gap between components
        setHgap(10);
        // set vertical gap between components
        setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("Name:");
        GridPane.setValignment(lblName, VPos.TOP);
        add(lblName, 0, 0);

        add(lvwNames,1,0);
        lvwNames.setPrefWidth(200);
        lvwNames.setPrefHeight(200);
        lvwNames.getItems().setAll(namesBoys);
    }
    public void initBoys(){
        namesBoys.add("Jonas");
        namesBoys.add("William");
        namesBoys.add("Tobias");
        namesBoys.add("Morten");
        namesBoys.add("Hugo");
    }



}
