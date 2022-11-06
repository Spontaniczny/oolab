import agh.ics.oop.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimalMovementTest {

    @Test
    public void Animal_movement_test_with_no_moves(){
        String[] args1 = {};
        MoveDirection[] directions = new OptionsParser().parse(args1);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(3, 4)));
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
    }

    @Test
    public void Animal_movement_test_with_another_animal_collision(){
        String[] args1 = {"f", "b", "r", "l", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args1);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(3, 3)));
        assertTrue(map.isOccupied(new Vector2d(2, 3)));
    }

    @Test
    public void Animal_movement_test_with_wall_collision(){
        String[] args1 = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args1);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(3, 5)));
        assertTrue(map.isOccupied(new Vector2d(2, 0)));
    }
}