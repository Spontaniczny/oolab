package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class App extends Application {

    IWorldMap map;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("y/x");
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        GridPane.setHalignment(label, HPos.CENTER);
        grid.getRowConstraints().add(new RowConstraints(10));
        grid.getColumnConstraints().add(new ColumnConstraints(20));

        Vector2d[] bounds = map.getMapBounds();

        grid.add(label, 1, 1);

        int x_min = bounds[0].x;
        int y_min = bounds[0].y;
        int x_max = bounds[1].x;
        int y_max = bounds[1].y;
        int temp = 2;

        for(int i = x_min; i <= x_max; ++i){
            grid.add(new Label(String.valueOf(i)), temp, 1);
            temp -= -1;
        }

        temp = 2;
        for(int i = y_max; i >= y_min; --i){
            grid.add(new Label(String.valueOf(i)), 1, temp);
            temp -= -1;
        }


//        grid.add(new Label("y/x"), 2, 2);
//        grid.add(new Label("y/x"), 5, 5);
        for(int i = x_min; i <= x_max; ++i){
            for(int j = y_max; j >= y_min; --j){
                Vector2d vector2d = new Vector2d(i, j);
                if(map.isOccupied(vector2d)){
                    var obj = map.objectAt(vector2d);
                    grid.add(new Label(obj.toString()), i + 2 - x_min, y_max - j + 2 - y_min);

                }
            }
        }


        Scene scene = new Scene(grid, 400, 400);
//        System.out.println(getParameters().getRaw());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r"};
        System.out.println("system wystartowal");
        MoveDirection[] directions = OptionsParser.parse(args);
        //        IWorldMap map = new RectangularMap(10, 5);
        map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println("system zakonczyl dzialanie");
    }
}
