package agh.ics.oop;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args){
        int correct_values = 0;
        for(String arg: args){
            switch (arg){
                case "f", "forward", "b", "backward", "l", "left", "r", "right" -> correct_values += 1;
            }
        }
        MoveDirection[] tab = new MoveDirection[correct_values];
        int i = 0;
        for(String arg: args){
            switch (arg){
                case "f", "forward" -> tab[i] = MoveDirection.FORWARD;
                case "b", "backward" -> tab[i] = MoveDirection.BACKWARD;
                case "l", "left" -> tab[i] = MoveDirection.LEFT;
                case "r", "right" -> tab[i] = MoveDirection.RIGHT;
            }
            if(tab[i] != null) {
                i += 1;
                if (i == correct_values) {
                    break;
                }
            }
            else{
                throw new IllegalArgumentException(arg + " is not legal move specification");
            }
        }
        return tab;
    }
}
