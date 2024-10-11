package magrethesOpgaver5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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

        //Blå cirkel
        Circle circleBlue = new Circle(70, 70, 30);
        pane.getChildren().add(circleBlue);
        circleBlue.setFill(Color.WHITE);
        circleBlue.setStroke(Color.BLUE);
        circleBlue.setStrokeWidth(3);


        // sort
        Circle circleBlack = new Circle(130, 70, 30);
        pane.getChildren().add(circleBlack);
        circleBlack.setFill(Color.WHITE);
        circleBlack.setStroke(Color.BLACK);
        circleBlack.setStrokeWidth(3);

        //Rød
        Circle circleRed = new Circle(190, 70, 30);
        pane.getChildren().add(circleRed);
        circleRed.setFill(null);
        circleRed.setStroke(Color.RED);
        circleRed.setStrokeWidth(3);


        //Gul
        Circle circleGul = new Circle(98, 110, 30);
        pane.getChildren().add(circleGul);
        circleGul.setFill(null);
        circleGul.setStroke(Color.YELLOW);
        circleGul.setStrokeWidth(3);

        //Grøn
        Circle circleGrøn = new Circle(160, 110, 30);
        pane.getChildren().add(circleGrøn);
        circleGrøn.setFill(null);
        circleGrøn.setStroke(Color.GREEN);
        circleGrøn.setStrokeWidth(3);








    }
}