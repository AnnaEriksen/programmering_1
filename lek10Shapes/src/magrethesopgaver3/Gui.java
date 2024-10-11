package magrethesopgaver3;

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


    private void initContent(Pane pane) {
        Circle circle = new Circle(150, 150, 100);
        pane.getChildren().add(circle);
        circle.setFill(null);
        circle.setStroke(Color.BLACK);


        // øje 1
        Circle circle2 = new Circle(90, 145, 20);
            pane.getChildren().add(circle2);
            circle2.setFill(null);
            circle2.setStroke(Color.BLACK);


            // øje 2
        Circle circle3 = new Circle(190, 145, 20);
        pane.getChildren().add(circle3);
        circle3.setFill(null);
        circle3.setStroke(Color.BLACK);

        //mund
        Line line1 = new Line(110, 195, 190, 195);
        line1.setStrokeWidth(5);
        line1.setStroke(Color.GREEN);
        pane.getChildren().add(line1);





}

}
