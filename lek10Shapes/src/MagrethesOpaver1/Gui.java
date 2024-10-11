package MagrethesOpaver1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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



        // Rectangle
        Rectangle r1 = new Rectangle(200 , 150, 100, 60);
        pane.getChildren().add(r1);
        r1.setStroke(Color.BLUE);
        r1.setFill(Color.BLUE);

        Text text1 = new Text(220, 200, "Anna");
        text1.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));
        pane.getChildren().add(text1);


    }

}



