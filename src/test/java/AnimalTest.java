import agh.ics.oop.Animal;
import agh.ics.oop.MoveDirection;
import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    @Test
    public void Animal_whole_class_test(){
        Animal animal1 = new Animal();   // (2, 2), Północ
        assertEquals(animal1.toString(), "position: (2,2) facing: Północ");
        String[] tab = {"f", "forward", "b", "backward", "XD", "XDD", "l", "left", "r", "right", "XDDD"};
        MoveDirection[] moves = OptionsParser.parse(tab);
        for(MoveDirection move: moves){
            animal1.move(move);
        }
        assertEquals(animal1.toString(), "position: (2,2) facing: Północ");
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        assertEquals(animal1.toString(), "position: (2,4) facing: Północ");
        animal1.move(MoveDirection.FORWARD);
        assertEquals(animal1.toString(), "position: (2,4) facing: Północ");
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.RIGHT);
        assertEquals(animal1.toString(), "position: (2,4) facing: Południe");
        animal1.move(MoveDirection.LEFT);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        assertEquals(animal1.toString(), "position: (4,4) facing: Wschód");
        animal1.move(MoveDirection.FORWARD);
        assertEquals(animal1.toString(), "position: (4,4) facing: Wschód");
        animal1.move(MoveDirection.LEFT);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.BACKWARD);
        assertEquals(animal1.toString(), "position: (4,0) facing: Północ");
        animal1.move(MoveDirection.BACKWARD);
        assertEquals(animal1.toString(), "position: (4,0) facing: Północ");
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.BACKWARD);
        assertEquals(animal1.toString(), "position: (0,0) facing: Wschód");
        animal1.move(MoveDirection.BACKWARD);
        assertEquals(animal1.toString(), "position: (0,0) facing: Wschód");
        animal1.move(MoveDirection.LEFT);
        assertEquals(animal1.toString(), "position: (0,0) facing: Północ");
        animal1.move(MoveDirection.LEFT);
        assertEquals(animal1.toString(), "position: (0,0) facing: Zachód");
        animal1.move(MoveDirection.LEFT);
        assertEquals(animal1.toString(), "position: (0,0) facing: Południe");
        animal1.move(MoveDirection.LEFT);
        assertEquals(animal1.toString(), "position: (0,0) facing: Wschód");
    }
}
