package Opgave2b;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        this.initContent(pane);
        Scene scene = new Scene(pane, 400, 400);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }


    //Lav ændringer til programmet, så alle figurer nu tegnes med farven gul (yellow). Brug en variabel til
    // at indeholde farven

    // Circle
    private void initContent(Pane pane) {
        int x = 100; // vi bruger denne int som skal lægges til, for at rykke alle 100 pixels til højre
        Color gul = Color.YELLOW;



        Circle circle = new Circle(70 + x, 70, 30);
        pane.getChildren().add(circle);
        circle.setFill(gul);
        circle.setStroke(gul);

        // Rectangle
        Rectangle r1 = new Rectangle(130 + x, 80, 30, 60);
        pane.getChildren().add(r1);
        r1.setStroke(gul);
        r1.setFill(gul);

        //Line
        Line line1 = new Line(10 + x, 30, 190 + x, 190);
        line1.setStrokeWidth(5);
        line1.setStroke(gul);
        pane.getChildren().add(line1);

    }

}



