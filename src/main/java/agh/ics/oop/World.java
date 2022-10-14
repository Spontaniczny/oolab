package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartowal");

        Direction[] directions = convert_to_enum_tab(args);

        run(directions);
        System.out.println("system zakonczyl dzialanie");
    }

    public static Direction[] convert_to_enum_tab(String[] tab){
        Direction [] directions = new Direction[tab.length];
        for (int i = 0; i < tab.length; ++i){
            switch (tab[i]) {
                case "f" -> directions[i] = Direction.FORWARD;
                case "b" -> directions[i] = Direction.BACKWARD;
                case "l" -> directions[i] = Direction.LEFT;
                case "r" -> directions[i] = Direction.RIGHT;
                default -> directions[i] = null;
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











