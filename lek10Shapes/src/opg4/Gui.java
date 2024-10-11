package opg4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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


        //Vær kreativ og lav et program der tegner et billede efter dit eget valg!

        Ellipse ellipse = new Ellipse(180, 170, 50, 12);
        pane.getChildren().add(ellipse);
        ellipse.setFill(Color.GREY);
        ellipse.setStroke(Color.GREY);
        ellipse.setStrokeWidth(5);

        Text text1 = new Text(170, 170, "sten");
        text1.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));
        pane.getChildren().add(text1);

    }

}



