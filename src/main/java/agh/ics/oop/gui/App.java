package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    Stage stage;
    GridPane grid;
    IWorldMap map;
    int moveDelay = 300;

    @Override
    public void init() throws Exception {
//        String[] args = {"l", "l", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f"};
        String[] args = getParameters().getRaw().toArray(new String[0]);
//        System.out.println("system wystartowal");
        MoveDirection[] directions = OptionsParser.parse(args);
        //        IWorldMap map = new RectangularMap(10, 5);
        map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        Runnable engine = new ThreadSimulationEngine(directions, map, positions, this);
//        engine.run();
        Thread engineThread = new Thread(engine);
        engineThread.start();
//        System.out.println("system zakonczyl dzialanie");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        grid = new GridPane();
        stage = primaryStage;
        drawGrid();
        Scene scene = new Scene(grid, 1600, 800);
//        System.out.println(getParameters().getRaw());
        stage.setScene(scene);
        stage.show();
//        grid.getChildren().clear();


    }

    public void drawGrid() throws Exception {

        Label label = new Label("y/x");
        grid.setGridLinesVisible(false);
        grid.getChildren().clear();
        grid.setGridLinesVisible(true);
        Vector2d[] bounds = map.getMapBounds();
        label.setMinHeight(40);
        label.setMinWidth(40);
        label.setAlignment(Pos.CENTER);
        label.centerShapeProperty();
        grid.add(label, 0, 0, 1, 1);

        int x_min = bounds[0].x;
        int y_min = bounds[0].y;
        int x_max = bounds[1].x;
        int y_max = bounds[1].y;
        int temp = 1;

        for(int i = x_min; i <= x_max; ++i){
            label = new Label(String.valueOf(i));
            label.setMinWidth(40);
            grid.add(label, temp, 0, 1, 1);
            label.setAlignment(Pos.CENTER);
            temp++;
        }

        temp = 1;
        for(int i = y_max; i >= y_min; --i){
            label = new Label(String.valueOf(i));
            label.setMinHeight(40);
            grid.add(label, 0, temp);
            GridPane.setHalignment(label, HPos.CENTER);
            temp++;
        }


//        grid.add(new Label("y/x"), 2, 2);
//        grid.add(new Label("y/x"), 5, 5);
        for(int i = x_min; i <= x_max; ++i){
            for(int j = y_max; j >= y_min; --j){
                Vector2d vector2d = new Vector2d(i, j);
                if(map.isOccupied(vector2d)){
                    IMapElement obj = (IMapElement) map.objectAt(vector2d);
//                    label = new Label(obj.toString());
                    VBox label2 = new GuiElementBox(obj).vbox;
                    grid.add(label2, i + 1 - x_min, y_max - j + 1);
                    GridPane.setHalignment(label2, HPos.CENTER);
                }
            }
        }
    }
}
