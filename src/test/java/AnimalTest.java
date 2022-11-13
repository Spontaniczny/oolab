import agh.ics.oop.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    @Test
    public void Animal_whole_class_test(){
        AbstractWorldMap map = new RectangularMap(10 , 5);
        Animal animal1 = new Animal(map, new Vector2d(2, 2));   // (2, 2), Północ
        map.place(animal1);
        assertEquals(animal1.toString() + animal1.getPosition(),"N(2,2)");
        String[] tab = {"f", "forward", "b", "backward", "XD", "XDD", "l", "left", "r", "right", "XDDD"};
        MoveDirection[] moves = OptionsParser.parse(tab);
        for(MoveDirection move: moves){
            animal1.move(move);
        }
        assertEquals(animal1.toString() + animal1.getPosition(), "N(2,2)");
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        assertEquals(animal1.toString() + animal1.getPosition(), "N(2,4)");
        animal1.move(MoveDirection.FORWARD);
        assertEquals(animal1.toString() + animal1.getPosition(), "N(2,5)");
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.RIGHT);
        assertEquals(animal1.toString() + animal1.getPosition(), "S(2,5)");
        animal1.move(MoveDirection.LEFT);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        assertEquals(animal1.toString() + animal1.getPosition(), "E(4,5)");
        animal1.move(MoveDirection.FORWARD);
        assertEquals(animal1.toString() + animal1.getPosition(), "E(5,5)");
        animal1.move(MoveDirection.LEFT);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.BACKWARD);
        assertEquals(animal1.toString() + animal1.getPosition(), "N(5,1)");
        animal1.move(MoveDirection.BACKWARD);
        assertEquals(animal1.toString() + animal1.getPosition(), "N(5,0)");
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.BACKWARD);
        assertEquals(animal1.toString() + animal1.getPosition(), "E(1,0)");
        animal1.move(MoveDirection.BACKWARD);
        assertEquals(animal1.toString() + animal1.getPosition(), "E(0,0)");
        animal1.move(MoveDirection.LEFT);
        assertEquals(animal1.toString() + animal1.getPosition(), "N(0,0)");
        animal1.move(MoveDirection.LEFT);
        assertEquals(animal1.toString() + animal1.getPosition(), "W(0,0)");
        animal1.move(MoveDirection.LEFT);
        assertEquals(animal1.toString() + animal1.getPosition(), "S(0,0)");
        animal1.move(MoveDirection.LEFT);
        assertEquals(animal1.toString() + animal1.getPosition(), "E(0,0)");
    }
}
