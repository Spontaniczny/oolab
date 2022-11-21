package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    public static void main(String[] args) {
        Application.launch(App.class, args);
//        try {
//            System.out.println("system wystartowal");
//
//            MoveDirection[] directions = new OptionsParser().parse(args);
//            //        IWorldMap map = new RectangularMap(10, 5);
//            IWorldMap map = new GrassField(10);
//            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
//            IEngine engine = new SimulationEngine(directions, map, positions);
//            engine.run();
//            //        MoveDirection[] moves = OptionsParser.parse(args);
//            //        System.out.println(Arrays.toString(moves));
//            //        Animal bobr = new Animal();
//            //        for(MoveDirection move: moves){
//            //            System.out.println(bobr);
//            //            bobr.move(move);
//            //        }
//
//
//            //        Direction[] directions = convert_to_enum_tab(args);
//            //        run(directions);
//            //        System.out.println((GrassField) (map.animals.get));
//            System.out.println("system zakonczyl dzialanie");
//        }
//        catch (IllegalArgumentException exception){
//            throw exception;
//        }
    }


    public static Direction[] convert_to_enum_tab(String[] tab){
        Direction [] directions = new Direction[tab.length];
        for (int i = 0; i < tab.length; ++i){
            switch (tab[i]) {
                case "f" -> directions[i] = Direction.FORWARD;
                case "b" -> directions[i] = Direction.BACKWARD;
                case "l" -> directions[i] = Direction.LEFT;
                case "r" -> directions[i] = Direction.RIGHT;
                default -> throw new IllegalArgumentException(tab[i] + " is not legal move specification");
            }
        }
        return directions;
    }

    public static void run(Direction[] tab){
        String message;
        for(Direction arg : tab) {
            if(arg == null){
                continue;
            }
            switch (arg){
                case FORWARD -> message = "Do przodu";
                case BACKWARD -> message = "Do tyłu";
                case LEFT -> message = "W lewo";
                case RIGHT -> message = "W prawo";
                default -> message = "XD";
            }
            System.out.println(message);
        }
    }
}











