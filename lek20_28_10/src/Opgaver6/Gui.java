package Opgaver6;

import eksempeltab.PaneDemo2;
import eksempeltab.PaneDemoTextArea;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Demo Tab view");
        BorderPane pane = new BorderPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);


    }

    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabBoys = new Tab("Boys");
        Tab tabGirls = new Tab("Girls");
        tabPane.getTabs().setAll(tabBoys,tabGirls);

        PaneBoys paneBoys = new PaneBoys();
        PaneGirls paneGirls = new PaneGirls();

        tabBoys.setContent(paneBoys);
        tabGirls.setContent(paneGirls);
    }




    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // Selected item changed in lvwPersons


    // -------------------------------------------------------------------------
    // Button actions


}
