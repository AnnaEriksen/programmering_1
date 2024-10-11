package example1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {


    @Override
    public void start(Stage stage) {
        GridPane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent() {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        this.drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------
// Exercise 1
//    private void drawShapes(GraphicsContext gc) {
//        int x = 100;
//        int y = 75;
//        int xLængde = 6;
//        int yLængde = 12;
//        gc.strokeLine(x, y, x+xLængde, y+yLængde);
//        gc.strokeLine(x, y, x+xLængde, y-yLængde);
//
//        x = 100;
//        y = 125;
//        gc.strokeLine(x, y, x+xLængde, y+yLængde);
//        gc.strokeLine(x, y, x+xLængde, y-yLængde);
//
//        x = 20;
//        y = 50;
//        gc.strokeLine(x, y, x+xLængde, y+yLængde);
//        gc.strokeLine(x, y, x+xLængde, y-yLængde);}}

    //Exercise 2
//private void drawShapes(GraphicsContext gc){
//
//        int x1 = 100;
//        int y1 = 200;
//        int x2 = 20;
//        int y2 = 10;
//        while (x2 <= 180){
//            gc.strokeLine(x1, y1, x2, y2);
//            x2 = x2 + 20;
//        } //Divider 100 med 5.
//}
//}

    //Exercise 3a
//private void drawShapes(GraphicsContext gc){
//        int x1 = 10;
//        int y1 = 10;
//        int x2 = 10;
//        int y2 = 180;
//        while (x1 <= 180){
//            gc.strokeLine(x1, y1, x2, y2);
//            x1 = x1 + 40;
//            x2 = x2 + 40;
//        }
//}
//}

    //Exercise 3b, da det er vande
//private void drawShapes(GraphicsContext gc){
//    int x1 = 0;
//    int y1 = 10;
//    int x2 = 150;
//    int y2 = 10;
//    while (y1 <= 180){
//        gc.strokeLine(x1, y1, x2, y2);
//        y1 = y1 + 40;
//        y2 = y2 + 40;
//    }
//}
//}
    // Exercise 3c
//private void drawShapes(GraphicsContext gc){
//        int x1 = 80;
//        int y1 = 10;
//        int x2 = 110;
//        int y2 = 10;
//        while (x2 <= 200){
//            gc.strokeLine(x1, y1, x2, y2);
//            x1 = x1 - 20;
//            x2 = x2 + 20;
//            y1 = y1 + 40;
//            y2 = y2 + 40;
//        }
//}
//}

    //exercise 4a



    //Exercise 4b
//private void drawShapes(GraphicsContext gc){
//        int x = 20;
//        int y = 100;
//        int r = 10;
//
//        while (r <= 100){
//            gc.strokeOval(x-r, y - r, 2 * r, 2 * r);
//            r = r + 10;
//            x = x + 10;
//        }
//}
//}

    //Exercise 4c
//private void drawShapes(GraphicsContext gc){
//
//        //Exercise 4c
//    int x = 100;
//    int y = 100;
//    int r1 = 25; //Radius, r1 er bredden
//    int r2 = 30; //Radius, r2 er højden
//    while (r1 <= 100){
//        gc.strokeOval(x-r1, y - r2, 2 * r1, 2 * r2);
//        r1 = r1 + 10;
//
//
//    }
//}
//}
    //Exercise 5 og 7
//    private void drawShapes(GraphicsContext gc) {
//        String s = "Datamatiker";
//
//        int space = 0;
//
//        for (int y = 1; y <= 11; y++){
//            gc.fillText(s.substring(0,y), 20, 50 + space);
//            space += 12;
//        }
//    }
//    }

    //Exercise 6
    //Create an application that draws an x-axis as shown below.
    // The application must use a for-statement (the axis has 11 ticks).
//    private void drawShapes(GraphicsContext gc){
//        int x1 = 10; //start point (x1, y1)
//        int y1 = 180;
//        int x2 = 190;//end point (x2, y1,)
//
//        gc.strokeLine(x1, y1, x2, y1);
//
//        //ticks/strokes start and end points
//        int a1 = 20; //start point (a1, b1)
//        int b1 = 175;
//        int b2 = 185; //end point (a1, b2)
//
//        //mellemrum mellem ticks
//        int space = 15;
//
//        //ticks (de 11 linjer)
//        for (a1 = 20; a1 <= 180; a1 += space){
//            gc.strokeLine(a1, b1, a1, b2);
//        }
//        //pil
//        int side1 = 180;
//        int side2 = 190;
//        gc.strokeLine(side1, side2, side1 - 10, side2 - 4);
//        gc.strokeLine(side1, side2, side1 - 10, side2 + 4);
//
//        //add more code to make each fifth vertical stroke twice as long as the others
//        gc.strokeLine(20, 170, 20, 190); // dette ændrer værdien af a1 for hver tick
//        gc.strokeLine(95, 170, 95, 190);
//        gc.strokeLine(170, 170, 170, 190);
//    }
//}


//exercise 8
//private void drawShapes(GraphicsContext gc){
//      int x = 16;
//      int y = 160;
//       int y2 = 80;
//        for (int i = 0; i < 10; i++){
//            gc.strokeLine(x, y, x, y2);
//            x = x + 16;
//            y = y - 12
//            y2 = y2 - 4;

    private void drawShapes(GraphicsContext gc){
        //Draw the rightmost line first (e.g. at x=180). Decrease the x-value of each new line with 25 %.
        //Stop when x is below 5.

        int x = 200;
        int decrease = 25;
        int y = 160;
        int y2 = 80;

        while (x > 5 ){
            gc.strokeLine(x, y, x, y2);
            x = x - 25;
            y = y - 20;
            y2 = y2 - 20;
        }

    }
}




