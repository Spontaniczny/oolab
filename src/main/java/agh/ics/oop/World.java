package agh.ics.oop;


public class World {
    public static void main(String[] args) {
        System.out.println("system wystartowal");

//        run(new String[] {"a", "b"});
        Direction[] directions = convert_to_enum_tab(args);

        run(directions);
        System.out.println("system zakonczyl dzialanie");
    }
    public static void run(Direction[] tab){
        for(Direction arg : tab) {
            String message = switch (arg) {
                case f -> "Do przodu";
                case b -> "Do tyłu";
                case l -> "W lewo";
                case r -> "W prawo";
                default -> "unexpected_value";
            };
            System.out.println(message);
        }
//        for (int i = 1; i < tab.length; ++i){
//            System.out.print(", ");
//            System.out.print(tab[i]);
//        }
    }
    public static Direction[] convert_to_enum_tab(String[] tab){
        Direction [] directions = new Direction[tab.length];
        for (int i = 0; i < tab.length; ++i){
            directions[i] = switch(tab[i]){
                case "f" -> Direction.f;
                case "b" -> Direction.b;
                case "l" -> Direction.l;
                case "r" -> Direction.r;
                default -> Direction.unexpected_value;
            };
        }
        return directions;
    }
}
