package agh.ics.oop;
//import Direction;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartowal");

//        run(new String[] {"a", "b"});
//        convert_to_enum();
        run(args);
        System.out.println("system zakonczyl dzialanie");
    }
    public static void run(String[] tab){
        for(String arg : tab) {
            String message = switch (arg) {
                case "f" -> "Do przodu";
                case "b" -> "Do tyłu";
                case "l" -> "W lewo";
                case "r" -> "W prawo";
                default -> "Nieznana komenda";
            };
            if(!message.equals("Nieznana komenda")) {
                System.out.println(message);
            }
        }
//        for (int i = 1; i < tab.length; ++i){
//            System.out.print(", ");
//            System.out.print(tab[i]);
//        }
    }
    public static void convert_to_enum(String[] tab){

    }
}
