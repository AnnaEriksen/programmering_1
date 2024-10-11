package opg3a;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
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


    // Circle
    private void initContent(Pane pane) {

        // vægge
        Rectangle r1 = new Rectangle(100, 100, 50, 70);
        pane.getChildren().add(r1);
        r1.setStroke(Color.RED);
        r1.setFill(Color.RED);

        Line line1 = new Line(100, 170, 200, 170);
        line1.setStrokeWidth(3);
        line1.setStroke(Color.BLACK);
        pane.getChildren().add(line1);

        //vindue
        Rectangle r2 = new Rectangle(110, 120, 10, 10);
        pane.getChildren().add(r2);
        r2.setStroke(Color.BLACK);
        r2.setFill(Color.BLACK);

        //sol
        Circle circle = new Circle(200, 70, 30);
        pane.getChildren().add(circle);
        circle.setFill(Color.YELLOW);
        circle.setStroke(Color.BLACK);

        //tag
        Polygon polygon = new Polygon(90, 100, 160, 100, 125, 65);
        pane.getChildren().add(polygon);
        polygon.setFill(Color.PINK);

        // sten
        Ellipse ellipse = new Ellipse(170, 170, 30, 2);
        pane.getChildren().add(ellipse);
        ellipse.setFill(Color.GREY);
        ellipse.setStroke(Color.GREY);
        ellipse.setStrokeWidth(5);

        //et græs strå
        Line line2 = new Line(200, 150, 200, 170);
        line2.setStrokeWidth(2);
        line2.setStroke(Color.GREEN);
        pane.getChildren().add(line2);








    }
}